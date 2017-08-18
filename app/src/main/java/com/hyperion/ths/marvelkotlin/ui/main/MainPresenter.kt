package com.hyperion.ths.marvelkotlin.ui.main

import com.hyperion.ths.marvelkotlin.utils.navigator.Navigator
import com.hyperion.ths.marvelkotlin.utils.rx.BaseSchedulerProvider
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by ThS on 8/17/2017.
 */
class MainPresenter(private var navigator: Navigator) : MainContract.Presenter {

  private lateinit var mMainViewModel: MainContract.ViewModel
  private lateinit var mSchedulerProvider: BaseSchedulerProvider
  private val mCompositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

  override fun onStart() {
  }

  override fun onStop() {
    mCompositeDisposable.dispose()
  }


  override fun setViewModel(viewModel: MainContract.ViewModel) {
    mMainViewModel = viewModel
  }

}