package com.survivalcoding.ifkakao.data.datasource

import android.app.Application
import android.content.Context
import androidx.datastore.core.CorruptionException
import androidx.datastore.core.DataStore
import androidx.datastore.core.Serializer
import androidx.datastore.dataStore
import com.google.protobuf.InvalidProtocolBufferException
import com.survivalcoding.ifkakao.BuildConfig
import com.survivalcoding.ifkakao.FavoriteSessions
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import javax.inject.Inject

class IfKakaoProtoDatastoreDataSource @Inject constructor(private val application: Application) :
    IfKakaoLocalDataSource {
    override suspend fun addFavoriteSession(sessionId: Int) {
        application.favoriteSessionsStore.updateData {
            it.toBuilder().addId(sessionId).build()
        }
    }

    override suspend fun removeFavoriteSession(sessionId: Int) {
        application.favoriteSessionsStore.updateData {
            val currentFavoriteSessions = it.idList.filter { it != sessionId }
            it.toBuilder().clear().addAllId(currentFavoriteSessions).build()
        }
    }

    override suspend fun getAllFavorite(): List<Int> {
        return application.favoriteSessionsStore.data.catch { exception ->
            if (exception is IOException) {
                if (BuildConfig.DEBUG) {
                    exception.printStackTrace()
                }
                emit(FavoriteSessions.getDefaultInstance())
            } else {
                throw exception
            }
        }.first().idList
    }

    private val Context.favoriteSessionsStore: DataStore<FavoriteSessions> by dataStore(
        FAVORITE_SESSIONS_DATA_STORE_FILE_NAME,
        FavoriteSessionsSerializer
    )

    private object FavoriteSessionsSerializer : Serializer<FavoriteSessions> {
        override val defaultValue: FavoriteSessions
            get() = FavoriteSessions.getDefaultInstance()

        @Suppress("BlockingMethodInNonBlockingContext")
        override suspend fun readFrom(input: InputStream): FavoriteSessions {
            try {
                return FavoriteSessions.parseFrom(input)
            } catch (exception: InvalidProtocolBufferException) {
                throw CorruptionException("Cannot read proto.", exception)
            }
        }

        @Suppress("BlockingMethodInNonBlockingContext")
        override suspend fun writeTo(t: FavoriteSessions, output: OutputStream) = t.writeTo(output)

    }

    companion object {
        private const val FAVORITE_SESSIONS_DATA_STORE_FILE_NAME = "FAVORITE_SESSIONS_DATA_STORE"
    }
}