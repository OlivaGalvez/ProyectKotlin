package com.galvez.oliva.commons

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


/**
 * Created by Oliva on 14/06/2018.
 */

fun ViewGroup.inflate(layoutResId: Int, attachToRoot: Boolean = false) :View {
    val inflater = LayoutInflater.from(context)
    return inflater.inflate(layoutResId, this, attachToRoot)
}