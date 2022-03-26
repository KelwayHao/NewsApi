package com.example.retrofithomework.presentation.recycler.viewholders

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.retrofithomework.R
import com.example.retrofithomework.domain.models.BaseItem
import com.example.retrofithomework.domain.models.News
import com.example.retrofithomework.presentation.recycler.BaseViewHolder
import com.example.retrofithomework.presentation.recycler.clicklisteners.OnClickShareListener
import kotlinx.android.synthetic.main.section_news.view.*

class NewsSectionViewHolder(itemView: View, private val clickShare: OnClickShareListener) :
    BaseViewHolder(itemView) {
    companion object {
        const val VIEW_TYPE = 2
        fun newInstance(parent: ViewGroup, clickShare: OnClickShareListener) = NewsSectionViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.section_news, parent, false),
            clickShare
        )
    }

    @SuppressLint("SetTextI18n", "CheckResult")
    override fun bindItem(item: BaseItem) {
        (item as News).apply {

            Glide.with(itemView.context)
                .load(previewUrlToImage)
                .into(itemView.imageNews)

            itemView.textTitleNews.text = title
            itemView.descriptionNews.text = description
            itemView.textAuthorNews.text =
                "${itemView.context.getString(R.string.author)} $author"
            itemView.imageShare.setOnClickListener {
                clickShare.sendNews(articleUrl)
            }
        }
    }
}