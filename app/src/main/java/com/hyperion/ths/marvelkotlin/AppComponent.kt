package com.hyperion.ths.marvelkotlin

import android.content.Context
import com.framgia.fbook.data.source.remote.api.service.NameApi
import com.hyperion.ths.marvelkotlin.data.source.remote.api.NetworkModule
import com.hyperion.ths.marvelkotlin.utils.dagger.AppScope
import com.hyperion.ths.marvelkotlin.utils.rx.BaseSchedulerProvider
import dagger.Component

/**
 * Created by ThS on 8/17/2017.
 */
@AppScope
@Component(modules = arrayOf(ApplicationModule::class, NetworkModule::class))
interface AppComponent {
  //============== Region for Repository ================//

  fun nameApi(): NameApi

  //=============== Region for common ===============//

  fun applicationContext(): Context

  fun baseSchedulerProvider(): BaseSchedulerProvider
}