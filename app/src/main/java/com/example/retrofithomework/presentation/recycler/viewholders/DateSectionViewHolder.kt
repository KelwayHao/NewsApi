package com.example.retrofithomework.presentation.recycler.viewholders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.retrofithomework.R
import com.example.retrofithomework.domain.models.BaseItem
import com.example.retrofithomework.domain.models.Date
import com.example.retrofithomework.presentation.recycler.BaseViewHolder
import kotlinx.android.synthetic.main.section_date.view.*

class DateSectionViewHolder(itemView: View): BaseViewHolder(itemView) {
    companion object {
        const val VIEW_TYPE = 1
        fun newInstance(parent: ViewGroup) = DateSectionViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.section_date, parent, false)
        )
    }

    override fun bindItem(item: BaseItem) {
        (item as Date).apply {
            itemView.textDate.text = item.dateNews.replace("-", ".")
        }
    }
}