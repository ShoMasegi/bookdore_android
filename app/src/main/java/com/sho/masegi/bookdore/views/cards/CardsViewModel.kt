package com.sho.masegi.bookdore.views.cards

import android.util.Log
import androidx.lifecycle.ViewModel
import com.sho.masegi.bookdore.network.Networking
import kotlinx.coroutines.*

class CardsViewModel(
    private val networking: Networking
) : ViewModel() {

    private val viewModelJob = SupervisorJob()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun click() {
        uiScope.launch { fetch() }
    }


    suspend fun fetch() = withContext(Dispatchers.Default) {
        val response = networking.bdapi.cards()
        Log.i("cards", "content : ${response.data}")
    }
}
