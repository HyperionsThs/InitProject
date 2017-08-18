package com.hyperion.ths.marvelkotlin.data.source.remote

import com.framgia.fbook.data.source.remote.api.service.NameApi
import com.hyperion.ths.marvelkotlin.data.UserDataSource
import javax.inject.Inject

/**
 * Created by ThS on 8/17/2017.
 */
class UserRemoteDataSource @Inject constructor(nameApi: NameApi) : BaseRemoteDataSource(
    nameApi), UserDataSource.RemoteDataSource {

}