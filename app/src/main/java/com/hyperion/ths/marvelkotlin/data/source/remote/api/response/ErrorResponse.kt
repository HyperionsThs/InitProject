package com.framgia.fbook.data.source.remote.api.response

import com.google.gson.annotations.Expose

/**
 * Created by ThS on 8/17/2017.
 */

class ErrorResponse {
  @Expose
  val documentationUrl: String? = null
  @Expose
  val message: String? = null
}
