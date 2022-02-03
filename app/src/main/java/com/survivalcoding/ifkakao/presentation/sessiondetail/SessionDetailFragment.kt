package com.survivalcoding.ifkakao.presentation.sessiondetail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.FragmentSessionDetailBinding
import com.survivalcoding.ifkakao.domain.entity.Categories
import com.survivalcoding.ifkakao.domain.entity.Session
import com.survivalcoding.ifkakao.presentation.MainActivity
import com.survivalcoding.ifkakao.presentation.common.CommonAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SessionDetailFragment : Fragment() {

    private var binding: FragmentSessionDetailBinding? = null

    private val viewModel: SessionDetailViewModel by viewModels()

    private val adapter: CommonAdapter by lazy {
        CommonAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments != null) {
            val session = arguments?.getParcelable<Session>(SESSION)
            if (session != null) viewModel.setSession(session)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSessionDetailBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.recyclerView?.adapter = adapter

        observe()
    }

    private fun observe() {
        repeatOnStart {
            viewModel.uiState.collectLatest {
                adapter.submitList(it.binderList)
            }
        }

        repeatOnStart {
            viewModel.eventFlow.collect {
                handleEvent(it)
            }
        }
    }

    private fun handleEvent(event: SessionDetailViewModel.Event) {
        when (event) {
            is SessionDetailViewModel.Event.NavigateToWebView -> navigateToWebView(event.url)
            is SessionDetailViewModel.Event.NavigateToSessionList -> navigateToSessionList()
            is SessionDetailViewModel.Event.NavigateToSessionDetail -> navigateToSessionDetail(event.session)
            is SessionDetailViewModel.Event.NavigateToCategorySessionList -> navigateToAssociatedSessionList(
                event.categories,
                event.title
            )
        }
    }

    private fun navigateToWebView(url: String) {
        Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
            if (resolveActivity(requireActivity().packageManager) != null) {
                requireActivity().startActivity(this)
            }
        }
    }

    private fun navigateToSessionList() {
        (requireActivity() as MainActivity).navigateToSessionList()
    }

    private fun navigateToSessionDetail(session: Session) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, SessionDetailFragment.newInstance(session))
            .addToBackStack(null)
            .commit()
    }

    private fun navigateToAssociatedSessionList(categories: Categories, title: String) {

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

    companion object {
        private const val SESSION = "SESSION"

        @JvmStatic
        fun newInstance(session: Session) = SessionDetailFragment().apply {
            arguments = Bundle().apply {
                putParcelable(SESSION, session)
            }
        }
    }
}