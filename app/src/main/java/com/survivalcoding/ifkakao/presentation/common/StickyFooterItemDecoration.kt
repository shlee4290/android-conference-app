package com.survivalcoding.ifkakao.presentation.common

import android.graphics.Rect
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration


class StickyFooterItemDecoration : ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        val adapterItemCount = parent.adapter?.itemCount ?: 0
        if (adapterItemCount == RecyclerView.NO_POSITION || adapterItemCount - 1 != position) return // 리스트의 마지막 아이템이 아니면 return

        outRect.top = calculateTopOffset(parent, view, adapterItemCount)
    }

    private fun calculateTopOffset(parent: RecyclerView, footerView: View, itemCount: Int): Int {
        val topOffset =
            parent.height - parent.paddingTop - parent.paddingBottom - visibleChildHeightWithFooter(
                parent,
                footerView,
                itemCount
            )
        return topOffset.coerceAtLeast(0)
    }

    private fun visibleChildHeightWithFooter(
        parent: RecyclerView,
        footerView: View,
        itemCount: Int
    ): Int {

        var totalHeight = 0
        val onScreenItemCount = parent.childCount.coerceAtMost(itemCount)
        for (i in 0 until onScreenItemCount - 1) {
            val layoutParams = parent.getChildAt(i).layoutParams as RecyclerView.LayoutParams
            val height =
                (parent.getChildAt(i).height + layoutParams.topMargin + layoutParams.bottomMargin)
            totalHeight += height
        }

        var footerHeight = footerView.height
        if (footerHeight == 0) {
            fixLayoutSize(footerView, parent)
            footerHeight = footerView.height
        }
        footerHeight += footerView.paddingBottom + footerView.paddingTop

        return totalHeight + footerHeight
    }

    private fun fixLayoutSize(view: View, parent: ViewGroup) {
        // Check if the view has a layout parameter and if it does not create one for it
        if (view.layoutParams == null) {
            view.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }

        // Create a width and height spec using the parent as an example:
        // For width we make sure that the item matches exactly what it measures from the parent.
        //  IE if layout says to match_parent it will be exactly parent.getWidth()
        val widthSpec = View.MeasureSpec.makeMeasureSpec(parent.width, View.MeasureSpec.EXACTLY)
        // For the height we are going to create a spec that says it doesn't really care what is calculated,
        //  even if its larger than the screen
        val heightSpec =
            View.MeasureSpec.makeMeasureSpec(parent.height, View.MeasureSpec.UNSPECIFIED)

        // Get the child specs using the parent spec and the padding the parent has
        val childWidth = ViewGroup.getChildMeasureSpec(
            widthSpec,
            parent.paddingLeft + parent.paddingRight, view.layoutParams.width
        )
        val childHeight = ViewGroup.getChildMeasureSpec(
            heightSpec,
            parent.paddingTop + parent.paddingBottom, view.layoutParams.height
        )

        // Finally we measure the sizes with the actual view which does margin and padding changes to the sizes calculated
        view.measure(childWidth, childHeight)

        // And now we setup the layout for the view to ensure it has the correct sizes.
        view.layout(0, 0, view.measuredWidth, view.measuredHeight)
    }
}