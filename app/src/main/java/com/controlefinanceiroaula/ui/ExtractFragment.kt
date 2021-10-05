package com.controlefinanceiroaula.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.controlefinanceiroaula.databinding.FragmentExtractBinding

class ExtractFragment : Fragment() {

    private var _binding: FragmentExtractBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView (
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        return super.onCreateView(inflater, container, savedInstanceState)
        _binding = FragmentExtractBinding.inflate(inflater, container, false)

        val root: View = binding.root
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}