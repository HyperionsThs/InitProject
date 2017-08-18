package com.hyperion.ths.marvelkotlin.data

import com.hyperion.ths.marvelkotlin.data.source.remote.UserRemoteDataSource
import javax.inject.Inject

/**
 * Created by ThS on 8/17/2017.
 */
class UserRepositoryImpl @Inject constructor(
    val remoteDataSource: UserRemoteDataSource) : UserRepository {

}