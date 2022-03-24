package com.example.retrofithomework.presentation.recycler.viewholders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.retrofithomework.R
import com.example.retrofithomework.domain.models.BaseItem
import com.example.retrofithomework.domain.models.News
import com.example.retrofithomework.presentation.recycler.BaseViewHolder
import kotlinx.android.synthetic.main.section_news.view.*

class NewsSectionViewHolder(itemView: View) : BaseViewHolder(itemView) {
    companion object {
        const val VIEW_TYPE = 2
        fun newInstance(parent: ViewGroup) = NewsSectionViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.section_news, parent, false)
        )
    }

    override fun bindItem(item: BaseItem) {
        (item as News).apply {
            itemView.textTitleNews.text = item.title
        }
    }
}