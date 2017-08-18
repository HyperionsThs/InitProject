package com.framgia.fbook.data.source.remote.api.service

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter
import java.io.IOException

/**
 * Created by ThS on 8/17/2017.
 */

class BooleanAdapter : TypeAdapter<Boolean>() {
  @Throws(IOException::class)
  override fun write(out: JsonWriter, value: Boolean?) {
    if (value == null) {
      out.nullValue()
      return
    }
    out.value(value)
  }

  @Throws(IOException::class)
  override fun read(input: JsonReader): Boolean? {
    val peek = input.peek()
    when (peek) {
      JsonToken.NULL -> {
        input.nextNull()
        return null
      }

      JsonToken.BOOLEAN -> return input.nextBoolean()

      JsonToken.NUMBER -> return input.nextInt() != 0

      JsonToken.STRING -> return java.lang.Boolean.valueOf(input.nextString())

      else -> return null
    }
  }
}
