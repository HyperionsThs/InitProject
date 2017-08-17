package com.hyperion.ths.marvelkotlin.data

/**
 * Created by ThS on 8/17/2017.
 */
interface UserDataSource {
  /**
   * LocalData For User
   */
  interface LocalDataSource : BaseLocalDataSource {
  }

  /**
   * RemoteData For User
   */
  interface RemoteDataSource {
  }
}