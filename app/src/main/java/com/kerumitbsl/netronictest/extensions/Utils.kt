package com.kerumitbsl.netronictest.extensions

import android.os.Build
import android.text.Html
import android.text.Spanned
import android.widget.ImageView
import androidx.core.text.HtmlCompat
import com.bumptech.glide.Glide
import com.kerumitbsl.netronictest.R

fun loadImage(pathSrc: String, imageView: ImageView) {
    Glide.with(imageView.context).load(pathSrc).placeholder(R.drawable.ic_icon_placeholder).into(imageView)
}

fun formatHtml(string: String?): Spanned? {
    return if (string.isNullOrBlank()) {
        null
    } else if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        HtmlCompat.fromHtml(string, HtmlCompat.FROM_HTML_MODE_LEGACY)
    } else {
        Html.fromHtml(string)
    }
}