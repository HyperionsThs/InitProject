package com.hyperion.ths.marvelkotlin

import android.app.Application
import com.hyperion.ths.marvelkotlin.data.source.remote.api.NetworkModule

/**
 * Created by ThS on 8/17/2017.
 */
class MainApplication : Application() {

  lateinit var appComponent: AppComponent

  override fun onCreate() {
    super.onCreate()
    appComponent = DaggerAppComponent.builder()
        .applicationModule(ApplicationModule(applicationContext))
        .networkModule(NetworkModule(this))
        .build()
  }
}