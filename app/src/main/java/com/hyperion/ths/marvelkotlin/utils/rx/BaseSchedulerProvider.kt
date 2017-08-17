package com.hyperion.ths.marvelkotlin.utils.rx

import io.reactivex.Scheduler

/**
 * Created by ThS on 8/17/2017.
 */
interface BaseSchedulerProvider {
  fun computation(): Scheduler

  fun io(): Scheduler

  fun ui(): Scheduler
}