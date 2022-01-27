package com.survivalcoding.ifkakao.presentation.session

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.FragmentSessionBinding
import com.survivalcoding.ifkakao.databinding.FragmentSessionDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SessionFragment : Fragment() {

    private var binding: FragmentSessionBinding? = null

    private val viewModel: SessionViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSessionBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}