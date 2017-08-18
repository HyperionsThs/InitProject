package com.hyperion.ths.marvelkotlin.ui

import android.content.Context
import android.support.v7.widget.RecyclerView

/**
 * Created by ThS on 8/17/2017.
 */
abstract class BaseRecyclerViewAdapter<V : RecyclerView.ViewHolder> internal constructor(
    internal val context: Context) : RecyclerView.Adapter<V>()