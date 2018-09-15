package marshi.android.feedpond.feedlist

import android.content.Context
import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

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
