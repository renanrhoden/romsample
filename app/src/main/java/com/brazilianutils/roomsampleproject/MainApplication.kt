package com.brazilianutils.roomsampleproject

import android.app.Application
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.provider
import java.security.SecureRandom
import java.util.Collections.singleton

class MainApplication : Application() {

//    val kodein = Kodein {
//        bind<WordRepository>() with provider { SecureRandom() }
//    }
}