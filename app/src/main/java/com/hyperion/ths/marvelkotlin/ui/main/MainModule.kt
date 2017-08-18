package com.hyperion.ths.marvelkotlin.ui.main

import android.app.Activity
import com.hyperion.ths.marvelkotlin.utils.dagger.ActivityScope
import com.hyperion.ths.marvelkotlin.utils.navigator.Navigator
import dagger.Module
import dagger.Provides

/**
 * Created by ThS on 8/17/2017.
 */
@Module
class MainModule(private val mActivity: Activity) {

  @ActivityScope
  @Provides
  fun providePresenter(navigator: Navigator): MainContract.Presenter {
    val presenter = MainPresenter(navigator)
    presenter.setViewModel(mActivity as MainContract.ViewModel)
    return presenter
  }

  @ActivityScope
  @Provides
  fun provideNavigator(): Navigator {
    return Navigator(mActivity)
  }

}