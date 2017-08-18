package com.hyperion.ths.marvelkotlin.data.source.remote.api

import android.app.Application
import com.framgia.fbook.data.source.remote.api.middleware.InterceptorImpl
import com.framgia.fbook.data.source.remote.api.middleware.RxErrorHandlingCallAdapterFactory
import com.framgia.fbook.data.source.remote.api.service.BooleanAdapter
import com.framgia.fbook.data.source.remote.api.service.IntegerAdapter
import com.framgia.fbook.data.source.remote.api.service.NameApi
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.hyperion.ths.marvelkotlin.BuildConfig
import com.hyperion.ths.marvelkotlin.utils.dagger.AppScope
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by ThS on 8/17/2017.
 */
@Module
class NetworkModule(private val mApplication: Application) {

  companion object {
    private val CONNECTION_TIMEOUT = 60
  }

  @AppScope
  @Provides
  fun provideApplication(): Application {
    return mApplication
  }

  @AppScope
  @Provides
  fun provideGson(): Gson {
    val booleanAdapter = BooleanAdapter()
    val integerAdapter = IntegerAdapter()
    return GsonBuilder()
        .registerTypeAdapter(Boolean::class.java, booleanAdapter)
        .registerTypeAdapter(Boolean::class.javaPrimitiveType, booleanAdapter)
        .registerTypeAdapter(Int::class.java, integerAdapter)
        .registerTypeAdapter(Int::class.javaPrimitiveType, integerAdapter)
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .excludeFieldsWithoutExposeAnnotation()
        .create()
  }

  @AppScope
  @Provides
  fun provideOkHttpCache(application: Application): Cache {
    val cacheSize = 10 * 1024 * 1024 // 10 MiB
    return Cache(application.cacheDir, cacheSize.toLong())
  }

  @AppScope
  @Provides
  fun provideInterceptor(): Interceptor {
    return InterceptorImpl()
  }

  @AppScope
  @Provides
  fun provideOkHttpClient(cache: Cache, interceptor: Interceptor): OkHttpClient {
    val httpClientBuilder = OkHttpClient.Builder()
    httpClientBuilder.cache(cache)
    httpClientBuilder.addInterceptor(interceptor)
    httpClientBuilder.readTimeout(CONNECTION_TIMEOUT.toLong(), TimeUnit.SECONDS)
    httpClientBuilder.connectTimeout(CONNECTION_TIMEOUT.toLong(), TimeUnit.SECONDS)
    if (BuildConfig.DEBUG) {
      val logging = HttpLoggingInterceptor()
      httpClientBuilder.addInterceptor(logging)
      logging.level = HttpLoggingInterceptor.Level.BODY
    }
    return httpClientBuilder.build()
  }

  @AppScope
  @Provides
  fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl("Url")
        .addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttpClient)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
  }

  @AppScope
  @Provides
  fun provideNameApi(retrofit: Retrofit): NameApi {
    return retrofit.create(NameApi::class.java)
  }
}