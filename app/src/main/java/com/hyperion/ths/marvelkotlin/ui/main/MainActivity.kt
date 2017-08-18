package com.hyperion.ths.marvelkotlin.ui.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.hyperion.ths.marvelkotlin.MainApplication
import com.hyperion.ths.marvelkotlin.R
import com.hyperion.ths.marvelkotlin.databinding.ActivityMainBinding
import com.hyperion.ths.marvelkotlin.ui.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity() {

  @Inject
  lateinit var mPresenter: MainContract.Presenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    DaggerMainComponent.builder()
        .appComponent((application as MainApplication).appComponent)
        .mainModule(MainModule(this))
        .build()
        .inject(this)

    val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    binding.viewModel = this
  }

  override fun onStart() {
    super.onStart()
    mPresenter.onStart()
  }

  override fun onStop() {
    mPresenter.onStop()
    super.onStop()
  }

}
