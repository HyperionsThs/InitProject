package com.hyperion.ths.marvelkotlin.data

/**
 * Created by ThS on 8/17/2017.
 */
interface BaseLocalDataSource {
  fun openTransaction()

  fun closeTransaction()
}