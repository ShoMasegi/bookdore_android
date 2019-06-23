package com.sho.masegi.bookdore

import android.app.Application
import com.sho.masegi.bookdore.network.Client
import com.sho.masegi.bookdore.network.Networking
import com.sho.masegi.bookdore.views.cards.CardsViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

class Application: Application() {

    private val clientModule: Module = module {
        factory { Client.httpClient() }
    }

    private val networkModule: Module = module {
        single { Networking(get()) }
    }

    private val viewModelModule: Module = module {
        viewModel { CardsViewModel(get()) }
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@Application)
            modules(listOf(networkModule, viewModelModule, clientModule))
        }
    }
}
