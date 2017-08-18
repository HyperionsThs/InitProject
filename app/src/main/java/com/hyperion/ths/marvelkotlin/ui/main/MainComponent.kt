package com.hyperion.ths.marvelkotlin.ui.main

import com.hyperion.ths.marvelkotlin.AppComponent
import com.hyperion.ths.marvelkotlin.utils.dagger.ActivityScope
import dagger.Component

/**
 * Created by ThS on 8/17/2017.
 */

@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(MainModule::class))
interface MainComponent {
  fun inject(mainActivity: MainActivity)
}