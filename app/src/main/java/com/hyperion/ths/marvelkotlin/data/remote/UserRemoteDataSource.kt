package com.hyperion.ths.marvelkotlin.data.remote

import com.framgia.fbook.data.source.remote.api.service.NameApi
import com.hyperion.ths.marvelkotlin.data.UserDataSource

/**
 * Created by ThS on 8/17/2017.
 */
class UserRemoteDataSource constructor(nameApi: NameApi) : BaseRemoteDataSource(
    nameApi), UserDataSource.RemoteDataSource {

}