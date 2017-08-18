package com.hyperion.ths.marvelkotlin.ui

/**
 * Created by ThS on 8/17/2017.
 */
interface BasePresenter<T : BaseViewModel> {
  fun onStart()

  fun onStop()

  fun setViewModel(viewModel: T)
}