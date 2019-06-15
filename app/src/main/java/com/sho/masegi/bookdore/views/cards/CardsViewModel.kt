package com.sho.masegi.bookdore.views.cards

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sho.masegi.bookdore.domain.model.Cards
import com.sho.masegi.bookdore.network.Networking
import kotlinx.coroutines.*

class CardsViewModel(
    private val networking: Networking
) : ViewModel() {

    private val _cards = MutableLiveData<Cards>()
    val cards: LiveData<Cards> get() = _cards

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    init { fetch() }

    private fun fetch() = viewModelScope.launch {
        _isLoading.value = true
        _cards.value = networking.bdapi.cards().data
        _isLoading.value = false
    }
}
