package com.sho.masegi.bookdore.views.cards.list

import com.bumptech.glide.Glide
import com.sho.masegi.bookdore.R
import com.sho.masegi.bookdore.databinding.ItemCardBinding
import com.sho.masegi.bookdore.domain.model.Card
import com.xwray.groupie.databinding.BindableItem

data class CardItem(val card: Card): BindableItem<ItemCardBinding>(
    card.hashCode().toLong()
) {
    override fun getLayout() = R.layout.item_card

    override fun bind(viewBinding: ItemCardBinding, position: Int) {
        viewBinding.title = card.book.title
        viewBinding.pages = "${card.currentPage}P / ${card.book.page}P"
        Glide.with(viewBinding.root)
             .load(card.book.thumbnail)
             .centerCrop()
             .into(viewBinding.imageView)
    }
}