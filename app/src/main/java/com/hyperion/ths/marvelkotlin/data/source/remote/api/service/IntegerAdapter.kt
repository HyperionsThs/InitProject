package com.framgia.fbook.data.source.remote.api.service

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter
import java.io.IOException

/**
 * Created by ThS on 8/17/2017.
 */

class IntegerAdapter : TypeAdapter<Int>() {
  @Throws(IOException::class)
  override fun write(out: JsonWriter, value: Int?) {
    if (value == null) {
      out.nullValue()
      return
    }
    out.value(value)
  }

  @Throws(IOException::class)
  override fun read(input: JsonReader): Int? {
    val peek = input.peek()
    when (peek) {
      JsonToken.NULL -> {
        input.nextNull()
        return null
      }

      JsonToken.NUMBER -> return input.nextInt()

      JsonToken.BOOLEAN -> return if (input.nextBoolean()) 1 else 0

      JsonToken.STRING -> {
        try {
          return Integer.valueOf(input.nextString())
        } catch (e: NumberFormatException) {
          return null
        }
      }
      else -> return null
    }
  }
}
