package com.sho.masegi.bookdore.views.cards

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sho.masegi.bookdore.databinding.FragmentCardsScreenBinding

import org.koin.android.ext.android.inject

class CardsScreen : Fragment() {

    private val viewModel: CardsViewModel by inject()
    private lateinit var binding: FragmentCardsScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCardsScreenBinding.inflate(inflater, container, false)
        binding.button.setOnClickListener {
            viewModel.click()
        }
        return binding.root
    }
}
