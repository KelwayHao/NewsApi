package com.example.retrofithomework.presentation.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofithomework.domain.models.BaseItem

abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bindItem(item: BaseItem)
}