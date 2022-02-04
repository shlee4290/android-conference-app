package com.survivalcoding.ifkakao.presentation.sessiondetail

import com.survivalcoding.ifkakao.domain.entity.Category
import com.survivalcoding.ifkakao.domain.entity.Session
import com.survivalcoding.ifkakao.presentation.common.*

class SessionDetailBinderListBuilder {

    private val tmpBinderList = mutableListOf<CommonBinder>()

    fun build(): List<CommonBinder> = tmpBinderList

    fun addVideo(
        session: Session,
        onPlayButtonClick: (String) -> Unit,
        onShareButtonClick: () -> Unit
    ): SessionDetailBinderListBuilder {
        if (session.video.isNotEmpty()) {
            tmpBinderList.add(
                SessionVideoBinder(
                    session.video.first(),
                    session.thumbnailUrl,
                    session.title,
                    onPlayButtonClick,
                    onShareButtonClick
                )
            )
        }
        return this
    }

    fun addCategory(session: Session, onClick: (Category) -> Unit): SessionDetailBinderListBuilder {
        tmpBinderList.add(CategoryListBinder(session.categories, onClick))
        return this
    }

    fun addTitle(session: Session): SessionDetailBinderListBuilder {
        tmpBinderList.add(SessionTitleBinder(session.title))
        return this
    }

    fun addContent(session: Session): SessionDetailBinderListBuilder {
        tmpBinderList.add(SessionContentBinder(session.content))
        return this
    }

    fun addTags(session: Session): SessionDetailBinderListBuilder {
        tmpBinderList.add(SessionTagsBinder(session.contentTag))
        return this
    }

    fun addSpeakers(session: Session): SessionDetailBinderListBuilder {
        tmpBinderList.addAll(
            session.contentsSpeakers.map {
                SpeakerBinder(it)
            }
        )
        return this
    }

    fun addLinks(
        onClickTalk: () -> Unit,
        onClickFacebook: () -> Unit,
        onClickTwit: () -> Unit,
        onClickShare: () -> Unit,
    ): SessionDetailBinderListBuilder {
        tmpBinderList.add(
            SessionLinksBinder(
                onClickTalk,
                onClickFacebook,
                onClickTwit,
                onClickShare
            )
        )
        return this
    }

    fun addAssociatedSessions(
        associatedSessionList: List<Session>,
        associatedSessionLastIndex: Int,
        currentSession: Session,
        onSessionClick: (Session) -> Unit,
        onMoreButtonClick: () -> Unit
    ): SessionDetailBinderListBuilder {
        if (associatedSessionList.none { it.idx != currentSession.idx }) return this

        tmpBinderList.add(AssociatedSessionTitleBinder())
        tmpBinderList.addAll(
            associatedSessionList.take(associatedSessionLastIndex)
                .filter { it.idx != currentSession.idx }
                .map {
                    SessionListItemBinder(
                        it, onSessionClick
                    )
                }
        )
        if (associatedSessionLastIndex < associatedSessionList.size - 1) {
            addButton("연관세션 더보기") { onMoreButtonClick() }
        }
        return this
    }

    fun addButton(text: String, onClick: () -> Unit): SessionDetailBinderListBuilder {
        tmpBinderList.add(SessionButtonBinder(text, onClick))
        return this
    }

    fun addFooter(): SessionDetailBinderListBuilder {
        tmpBinderList.add(FooterBinder())
        return this
    }
}