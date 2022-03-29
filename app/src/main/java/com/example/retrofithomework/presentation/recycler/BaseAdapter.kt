package com.example.retrofithomework.presentation.recycler

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofithomework.domain.models.BaseItem
import com.example.retrofithomework.domain.models.Date
import com.example.retrofithomework.domain.models.News
import com.example.retrofithomework.presentation.recycler.clicklisteners.OnItemClickListener
import com.example.retrofithomework.presentation.recycler.viewholders.DateSectionViewHolder
import com.example.retrofithomework.presentation.recycler.viewholders.NewsSectionViewHolder

class BaseAdapter(
    private val clickShare: OnItemClickListener
) : RecyclerView.Adapter<BaseViewHolder>() {

    private var items: List<BaseItem> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            DateSectionViewHolder.VIEW_TYPE -> DateSectionViewHolder.newInstance(parent)
            NewsSectionViewHolder.VIEW_TYPE -> NewsSectionViewHolder.newInstance(parent, clickShare)
            else -> throw IllegalStateException("Wrong view holder type")
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is Date -> DateSectionViewHolder.VIEW_TYPE
            is News -> NewsSectionViewHolder.VIEW_TYPE
            else -> throw IllegalStateException("Wrong view view type")
        }
    }

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(data: List<BaseItem>) {
        items = data
        notifyDataSetChanged()
    }
}