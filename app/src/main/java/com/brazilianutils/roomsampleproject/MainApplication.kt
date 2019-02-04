package com.brazilianutils.roomsampleproject

import android.app.Application
import org.koin.android.ext.android.startKoin
import org.koin.android.viewmodel.experimental.builder.viewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import java.security.SecureRandom
import java.util.Collections.singleton

class MainApplication : Application() {

//    val kodein = Kodein {
//        bind<NoteRepository>() with provider { SecureRandom() }
//    }

    private val appModule = module {
        single { NoteRepository(this@MainApplication) }
        viewModel { NoteViewModel(get()) }
    }

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(appModule))
    }
}