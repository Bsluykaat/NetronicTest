package com.kerumitbsl.netronictest.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.kerumitbsl.netronictest.R

fun loadImage(pathSrc: String, imageView: ImageView) {
    Glide.with(imageView.context).load(pathSrc).placeholder(R.drawable.ic_launcher_foreground).into(imageView)
}