package vn.mrlongg71.vnchat.src.application

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import vn.mrlongg71.vnchat.src.network.apiModule
import vn.mrlongg71.vnchat.src.network.repositoryModule
import vn.mrlongg71.vnchat.src.network.retrofitModule
import vn.mrlongg71.vnchat.src.network.viewModelModule


class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(listOf(repositoryModule, viewModelModule, retrofitModule, apiModule))
        }
    }
}