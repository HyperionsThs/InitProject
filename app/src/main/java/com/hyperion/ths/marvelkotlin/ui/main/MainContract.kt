package com.hyperion.ths.marvelkotlin.ui.main

import com.hyperion.ths.marvelkotlin.ui.BasePresenter
import com.hyperion.ths.marvelkotlin.ui.BaseViewModel

/**
 * Created by ThS on 8/17/2017.
 */
interface MainContract {

  interface ViewModel : BaseViewModel {
  }

  interface Presenter : BasePresenter<ViewModel> {
  }
}