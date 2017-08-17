package com.hyperion.ths.marvelkotlin.utils.rx

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by ThS on 8/17/2017.
 */
class SchedulerProvider private constructor() : BaseSchedulerProvider {
  override fun computation(): Scheduler {
    return Schedulers.computation()
  }

  override fun io(): Scheduler {
    return Schedulers.io()
  }

  override fun ui(): Scheduler {
    return AndroidSchedulers.mainThread()
  }

  private object SchedulerProvider {
    val instance = SchedulerProvider()
  }

  companion object {
    val instance: com.hyperion.ths.marvelkotlin.utils.rx.SchedulerProvider by lazy { SchedulerProvider.instance }
  }
}