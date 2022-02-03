package com.survivalcoding.ifkakao.presentation.session

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.google.android.material.tabs.TabLayoutMediator
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.FragmentSessionBinding
import com.survivalcoding.ifkakao.domain.entity.Session
import com.survivalcoding.ifkakao.presentation.common.CommonAdapter
import com.survivalcoding.ifkakao.presentation.common.CommonListBinder
import com.survivalcoding.ifkakao.presentation.common.FooterBinder
import com.survivalcoding.ifkakao.presentation.common.SessionListItemBinder
import com.survivalcoding.ifkakao.presentation.sessiondetail.SessionDetailFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SessionFragment : Fragment() {

    private var binding: FragmentSessionBinding? = null

    private val viewModel: SessionViewModel by viewModels()

    private val viewPagerAdapter: CommonAdapter by lazy {
        CommonAdapter()
    }

    private var drawer: DrawerLayout? = null
    private val drawerListAdapter: CommonAdapter by lazy {
        CommonAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSessionBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewPager()
        binding?.sessionBannerVideoView?.setVideoURI(Uri.parse("https://t1.kakaocdn.net/service_if_kakao_prod/videos/mo/vod_teaser_2021.mp4"))
        binding?.sessionBannerVideoView?.setOnPreparedListener {
            it.isLooping = true
            binding?.sessionBannerVideoView?.start()
            viewLifecycleOwner.lifecycleScope.launch {
                delay(100L)
                binding?.sessionBannerThumbnail?.visibility = View.INVISIBLE
            }
        }
        initDrawer()
        binding?.sessionCategoryButton?.setOnClickListener { openDrawer() }

        observe()
    }

    override fun onPause() {
        super.onPause()
        binding?.sessionBannerVideoView?.pause()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding?.sessionBannerVideoView?.stopPlayback()
        binding = null
    }

    private fun initViewPager() {
        binding?.sessionViewPager?.adapter = viewPagerAdapter
        TabLayoutMediator(
            binding?.tabLayout ?: return,
            binding?.sessionViewPager ?: return
        ) { tab, position ->
            tab.text = "Day${position + 1}" + if (position == 3 - 1) "(All)" else ""
        }.attach()
    }

    private fun observe() {
        repeatOnStart {
            viewModel.sessionUiState.collect {
                val commonListBinders =
                    listOf(
                        it.day1Sessions.toBinderList(),
                        it.day2Sessions.toBinderList(),
                        it.day3Sessions.toBinderList()
                    )
                viewPagerAdapter.submitList(commonListBinders)

                drawerListAdapter.submitList(it.drawerBinderList)
            }
        }
    }

    private fun List<Session>.toBinderList(): CommonListBinder {
        return CommonListBinder(
            this.map { session -> SessionListItemBinder(session, ::navigateToSessionDetail) }
                .plus(FooterBinder())
        )
    }

    private fun navigateToSessionDetail(session: Session) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, SessionDetailFragment.newInstance(session))
            .addToBackStack(null)
            .commit()
    }

    private fun initDrawer() {
        drawer = binding?.drawerLayout
        binding?.drawerCloseButton?.setOnClickListener { closeDrawer() }
        binding?.drawerRecyclerView?.adapter = drawerListAdapter
    }

    private fun openDrawer() {
        if (drawer?.isOpen == false) {
            drawer?.openDrawer(GravityCompat.START)
        }
    }

    private fun closeDrawer() {
        if (drawer?.isDrawerOpen(GravityCompat.START) == true) {
            drawer?.closeDrawer(GravityCompat.START)
        }
    }

    private fun repeatOnStart(block: suspend CoroutineScope.() -> Unit) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED, block)
        }
    }

    companion object {
        const val TAG = "SessionFragment"
    }
}