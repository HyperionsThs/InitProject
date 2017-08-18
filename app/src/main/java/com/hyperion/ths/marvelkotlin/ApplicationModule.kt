package com.hyperion.ths.marvelkotlin

import android.content.Context
import com.hyperion.ths.marvelkotlin.utils.dagger.AppScope
import com.hyperion.ths.marvelkotlin.utils.rx.BaseSchedulerProvider
import com.hyperion.ths.marvelkotlin.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides

/**
 * Created by ThS on 8/17/2017.
 */
@Module
class ApplicationModule(private val mContext: Context) {

  @Provides
  @AppScope
  fun provideApplicationContext(): Context {
    return mContext
  }

  @Provides
  @AppScope
  fun provideBaseSchedulerProvider(): BaseSchedulerProvider {
    return SchedulerProvider.instance
  }
}