package com.survivalcoding.ifkakao.presentation.main

import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bumptech.glide.Glide
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFragment : Fragment() {

    private var binding: FragmentMainBinding? = null

    private val viewModel: MainViewModel by viewModels()

    private val adapter: SessionListAdapter by lazy {
        SessionListAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.sessionListRecyclerView?.adapter = adapter

        if (binding != null) {
            Glide.with(requireContext())
                .load(getString(R.string.main_banner_image_url))
                .into(binding!!.mainBannerImageView)


            if (android.os.Build.VERSION.SDK_INT >= 31) {
                binding!!.mainBannerImageView.setRenderEffect(
                    RenderEffect.createBlurEffect(
                        10f,
                        10f,
                        Shader.TileMode.CLAMP
                    )
                )
            }

            Glide.with(requireContext())
                .asGif()
                .load(getString(R.string.main_hand_gif_url))
                .into(binding!!.handImageView)
        }

        repeatOnStart {
            viewModel.highlightSessions.collectLatest {
                adapter.submitList(it)
            }
        }
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