package com.galvez.oliva.commons

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by Oliva on 20/06/2018.
 */

@BindingAdapter("imageUrl")
    fun loadImage (imageView: ImageView, url: String) {
        Glide.with(imageView)
                .load(url)
                .into(imageView)
    }