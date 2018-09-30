package marshi.android.tuve.feedlist

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MarginDecoration private constructor(
  private val top: Int,
  private val bottom: Int
) : RecyclerView.ItemDecoration() {
  
  companion object {
    fun newInstance(
      context: Context,
      top: Int,
      bottom: Int
    ): MarginDecoration {
      val displayMetrics = context.resources.displayMetrics
      val topPx = (displayMetrics.density * top).toInt()
      val bottomPx = (displayMetrics.density * bottom).toInt()
      return MarginDecoration(topPx, bottomPx)
    }
  }
  
  override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
    outRect.also {
      it.top = top
      it.bottom = bottom
    }
  }
  
}
