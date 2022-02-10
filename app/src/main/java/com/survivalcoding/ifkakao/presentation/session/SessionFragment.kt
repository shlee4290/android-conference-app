package com.survivalcoding.ifkakao.presentation.session

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.view.GravityCompat
import androidx.core.view.isVisible
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.FragmentSessionBinding
import com.survivalcoding.ifkakao.domain.entity.Session
import com.survivalcoding.ifkakao.presentation.common.*
import com.survivalcoding.ifkakao.presentation.sessiondetail.SessionDetailFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
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

    private var firstViewPagerPageScrolledFlag = true

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
        binding?.sessionBannerVideoView?.setVideoURI(Uri.parse(getString(R.string.session_banner_video_url)))
        binding?.sessionBannerVideoView?.setOnPreparedListener {
            it.isLooping = true
            binding?.sessionBannerVideoView?.start()
            viewLifecycleOwner.lifecycleScope.launch {
                delay(100L)
                binding?.sessionBannerThumbnail?.visibility = View.INVISIBLE
            }
        }
        initDrawer()

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
        firstViewPagerPageScrolledFlag = true
        binding?.sessionViewPager?.adapter = viewPagerAdapter
        TabLayoutMediator(
            binding?.tabLayout ?: return,
            binding?.sessionViewPager ?: return
        ) { tab, position ->
            tab.text = "Day${position + 1}" + if (position == DURATION - 1) "(All)" else ""
        }.attach()
        binding?.sessionViewPager?.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                if (firstViewPagerPageScrolledFlag) {
                    firstViewPagerPageScrolledFlag = false
                } else {
                    binding?.appBarLayout?.setExpanded(false)
                }
            }
        })
    }

    private fun observe() {
        repeatOnStart {
            viewModel.uiState.collectLatest {
                viewPagerAdapter.submitList(
                    listOf(
                        it.day1Sessions,
                        it.day2Sessions,
                        it.day3Sessions
                    )
                )

                drawerListAdapter.submitList(it.drawerBinderList)

                binding?.selectedCategoryCountTextView?.isVisible = it.selectedCategoryCount != 0
                binding?.selectedCategoryCountTextView?.text = it.selectedCategoryCount.toString()
            }
        }

        repeatOnStart { viewModel.eventFlow.collect { handleEvent(it) } }
    }

    private fun handleEvent(event: SessionViewModel.Event) {
        when (event) {
            is SessionViewModel.Event.NoMatchingSessions -> showNoMatchingSessionDialog()
            is SessionViewModel.Event.NavigateToSessionDetail -> navigateToSessionDetail(event.id)
        }
    }

    private fun showNoMatchingSessionDialog() {
        customDialogWithOneButton(
            requireActivity(),
            getString(R.string.no_matching_result_message),
            getString(R.string.ok),
            viewModel::resetSelectedCategories
        ).show()
    }

    private fun navigateToSessionDetail(id: Int) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, SessionDetailFragment.newInstance(id))
            .addToBackStack(null)
            .commit()
    }

    private fun initDrawer() {
        drawer = binding?.drawerLayout
        binding?.drawerCloseButton?.setOnClickListener { closeDrawer() }
        binding?.drawerRecyclerView?.itemAnimator = null
        binding?.drawerRecyclerView?.adapter = drawerListAdapter
        binding?.sessionCategoryButton?.setOnClickListener { openDrawer() }
        binding?.resetButton?.setOnClickListener { viewModel.resetSelectedCategories() }
        binding?.applyButton?.setOnClickListener {
            viewModel.setCategoryFilter()
            binding?.sessionViewPager?.setCurrentItem(viewPagerAdapter.itemCount - 1, false)
            closeDrawer()
        }
        binding?.drawerLayout?.addDrawerListener(object : DrawerLayout.DrawerListener {
            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {}

            override fun onDrawerOpened(drawerView: View) {}

            override fun onDrawerClosed(drawerView: View) {
                (requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(
                    drawerView.windowToken,
                    0
                )
            }

            override fun onDrawerStateChanged(newState: Int) {}
        })
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
        private const val DURATION = 3
    }
}