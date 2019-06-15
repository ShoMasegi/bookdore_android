package com.sho.masegi.bookdore.views.cards

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.sho.masegi.bookdore.databinding.FragmentCardsScreenBinding
import com.sho.masegi.bookdore.domain.model.Status
import com.sho.masegi.bookdore.views.cards.list.CardItem
import com.sho.masegi.bookdore.views.cards.list.HeaderItem
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.databinding.ViewHolder

import org.koin.android.ext.android.inject

class CardsScreen : Fragment() {

    private val viewModel: CardsViewModel by inject()
    private lateinit var binding: FragmentCardsScreenBinding
    private val adapter = GroupAdapter<ViewHolder<*>>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCardsScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        binding.isLoading = viewModel.isLoading
        binding.recyclerView.adapter = adapter
        viewModel.cards.observe(this, Observer { data ->
            val wants = data.cards.filter { it.status == Status.want }
            val readings = data.cards.filter { it.status == Status.reading }
            val read = data.cards.filter { it.status == Status.read }
            val bought = data.cards.filter { it.status == Status.bought }
            val items = listOf(
                HeaderItem(Status.reading.name),
                CardItem(readings[0]),
                CardItem(readings[1]),
                HeaderItem(Status.want.name),
                CardItem(wants[0]),
                CardItem(wants[1]),
                HeaderItem(Status.bought.name),
                CardItem(bought[0]),
                CardItem(bought[1]),
                HeaderItem(Status.read.name),
                CardItem(read[0]),
                CardItem(read[1])
            )
            adapter.update(items)
        })
    }
}
