package com.sho.masegi.bookdore.views.cards.list

import com.sho.masegi.bookdore.R
import com.sho.masegi.bookdore.databinding.ItemHeaderBinding
import com.xwray.groupie.databinding.BindableItem

data class HeaderItem(val text: String): BindableItem<ItemHeaderBinding>(
    text.hashCode().toLong()
) {
    override fun getLayout() = R.layout.item_header

    override fun bind(viewBinding: ItemHeaderBinding, position: Int) {
        viewBinding.text = text
    }
}