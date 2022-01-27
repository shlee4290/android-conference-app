package com.survivalcoding.ifkakao.presentation.common

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class CommonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(binder: CommonBinder)
}