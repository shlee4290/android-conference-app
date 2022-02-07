package com.survivalcoding.ifkakao.presentation.common

import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.survivalcoding.ifkakao.core.dp2Px
import com.survivalcoding.ifkakao.databinding.CategoryListBinding
import com.survivalcoding.ifkakao.domain.entity.toList

class CategoryListViewHolder private constructor(private val binding: CategoryListBinding) :
    CommonViewHolder(binding.root) {

    override fun bind(binder: CommonBinder) {
        binder as CategoryListBinder

        val badgeBinderList = binder.categories.toList().map {
            BadgeBinder(it, isHighlight = false, isBig = true, onClick = binder.onClick)
        }
        (binding.categoryRecyclerView.adapter as CommonAdapter).submitList(badgeBinderList)
    }

    companion object {
        private var itemDecoration: RecyclerView.ItemDecoration? = null
        private const val RIGHT_MARGIN_IN_DP = 8F
        private const val TOP_MARGIN_IN_DP = 4F

        fun from(parent: ViewGroup): CategoryListViewHolder {
            val binding =
                CategoryListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            binding.categoryRecyclerView.adapter = CommonAdapter()
            binding.categoryRecyclerView.addItemDecoration(
                itemDecoration ?: CategoryClassItemDecoration(
                    rightMarginInPx = dp2Px(
                        parent.context,
                        RIGHT_MARGIN_IN_DP
                    ).toInt(),
                    topMarginInPx = dp2Px(
                        parent.context,
                        TOP_MARGIN_IN_DP
                    ).toInt()
                ).apply { itemDecoration = this })

            return CategoryListViewHolder(binding)
        }
    }
}

class CategoryClassItemDecoration(
    private val rightMarginInPx: Int,
    private val topMarginInPx: Int
) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.right = rightMarginInPx
        outRect.top = topMarginInPx
    }
}