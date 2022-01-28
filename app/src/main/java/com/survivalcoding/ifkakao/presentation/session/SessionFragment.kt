package com.survivalcoding.ifkakao.presentation.session

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.google.android.material.tabs.TabLayoutMediator
import com.survivalcoding.ifkakao.databinding.FragmentSessionBinding
import com.survivalcoding.ifkakao.domain.entity.Session
import com.survivalcoding.ifkakao.presentation.common.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SessionFragment : Fragment() {

    private var binding: FragmentSessionBinding? = null

    private val viewModel: SessionViewModel by viewModels()

    private val viewPagerAdapter: CommonAdapter by lazy {
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

        observe()
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
            }
        }
    }

    private fun List<Session>.toBinderList(): CommonListBinder {
        return CommonListBinder(
            this.map { session -> SessionBinder(session) }
                .plus(FooterBinder())
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun repeatOnStart(block: suspend CoroutineScope.() -> Unit) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED, block)
        }
    }
}