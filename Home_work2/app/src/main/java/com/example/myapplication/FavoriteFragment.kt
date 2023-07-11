package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentBlankBinding


class FavoriteFragment : Fragment(R.layout.fragment_blank) {

    private var binding: FragmentBlankBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentBlankBinding.bind(view)

        binding?.run {
            btnToSearch.setOnClickListener {
                findNavController().navigate(R.id.action_blankFragment_to_searchFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
