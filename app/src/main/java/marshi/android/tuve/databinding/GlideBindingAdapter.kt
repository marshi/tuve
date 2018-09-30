package marshi.android.tuve.databinding

import android.net.Uri
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import marshi.android.tuve.GlideApp
import java.net.URL

@BindingAdapter("glideUrl")
fun loadImage(view: AppCompatImageView, url: URL) {
  GlideApp.with(view)
    .load(Uri.parse(url.toString()))
    .centerCrop()
    .into(view)
}