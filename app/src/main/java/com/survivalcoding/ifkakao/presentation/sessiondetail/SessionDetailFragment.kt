package com.survivalcoding.ifkakao.presentation.sessiondetail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.kakao.sdk.link.LinkClient
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.FragmentSessionDetailBinding
import com.survivalcoding.ifkakao.domain.entity.Categories
import com.survivalcoding.ifkakao.domain.entity.Session
import com.survivalcoding.ifkakao.presentation.MainActivity
import com.survivalcoding.ifkakao.presentation.categorySession.CategorySessionFragment
import com.survivalcoding.ifkakao.presentation.common.CommonAdapter
import com.survivalcoding.ifkakao.presentation.session.SessionFragment
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
            is SessionDetailViewModel.Event.NavigateToCategorySessionList -> navigateToCategorySessionList(
                event.categories,
                event.title
            )
            is SessionDetailViewModel.Event.ShareSessionWithTalk -> shareSessionUrlWithTalk(event.sessionIdx)
            is SessionDetailViewModel.Event.ShareSession -> shareSession(event.sessionIdx)
        }
    }

    private fun shareSession(sessionIdx: Int) {
        Intent(Intent.ACTION_SEND).apply {
            type = "text/pain"
            putExtra(Intent.EXTRA_TEXT, getString(R.string.session_url, sessionIdx))
            startActivity(Intent.createChooser(this, "세션 공유하기"))
        }
    }

    private fun shareSessionUrlWithTalk(sessionIdx: Int) {
        if (LinkClient.instance.isKakaoLinkAvailable(requireContext())) {
            // 카카오톡으로 카카오링크 공유 가능
            LinkClient.instance.scrapTemplate(
                requireContext(),
                getString(R.string.session_url, sessionIdx)
            ) { linkResult, error ->
                if (error != null) {
                    Log.e(TAG, "카카오링크 보내기 실패", error)
                } else if (linkResult != null) {
                    Log.d(TAG, "카카오링크 보내기 성공 ${linkResult.intent}")
                    startActivity(linkResult.intent)

                    // 카카오링크 보내기에 성공했지만 아래 경고 메시지가 존재할 경우 일부 컨텐츠가 정상 동작하지 않을 수 있습니다.
                    Log.w(TAG, "Warning Msg: ${linkResult.warningMsg}")
                    Log.w(TAG, "Argument Msg: ${linkResult.argumentMsg}")
                }
            }
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

    private fun navigateToCategorySessionList(categories: Categories, title: String) {
        parentFragmentManager.beginTransaction().replace(
            R.id.fragment_container_view,
            CategorySessionFragment.newInstance(categories, title)
        ).addToBackStack(null)
            .commit()
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
        private val TAG = SessionDetailFragment::class.simpleName

        @JvmStatic
        fun newInstance(session: Session) = SessionDetailFragment().apply {
            arguments = Bundle().apply {
                putParcelable(SESSION, session)
            }
        }
    }
}