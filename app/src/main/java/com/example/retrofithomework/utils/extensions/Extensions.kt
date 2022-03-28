package com.example.retrofithomework.utils.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.SearchView
import androidx.core.content.ContextCompat.startActivity
import com.bumptech.glide.Glide
import com.example.retrofithomework.R
import com.example.retrofithomework.data.models.ArticleResponse
import com.example.retrofithomework.data.models.NewsResponse
import com.example.retrofithomework.domain.models.BaseItem
import com.example.retrofithomework.domain.models.Date
import com.example.retrofithomework.domain.models.News
import com.example.retrofithomework.domain.models.NewsInfo
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.section_news.view.*

fun List<ArticleResponse>.toBaseItems(): List<BaseItem> {
    val listBaseItem = mutableListOf<BaseItem>()

    this.forEachIndexed() { index, article ->
        if (listBaseItem.isEmpty()) {
            listBaseItem.add(
                Date(
                    dateNews = article.publishedAt.toDate()
                )
            )
        } else if (article.publishedAt.toDate() != this[index - 1].publishedAt.toDate()) {
            listBaseItem.add(
                Date(
                    dateNews = article.publishedAt.toDate()
                )
            )
        }

        listBaseItem.add(
            News(
                author = article.author,
                title = article.title,
                description = article.description,
                articleUrl = article.articleUrl,
                previewUrlToImage = article.previewUrlToImage,
                content = article.content,
                idNewsChannel = article.source.idNewsChannel,
                nameNewsChannel = article.source.nameNewsChannel
            )
        )
    }

    return listBaseItem.toList()
}

fun String.toDate(): String {
    return this.substring(0, 10)
}

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

fun NewsResponse.toNewsInfo(): NewsInfo {
    return NewsInfo(
        this.totalResults.toString(),
        this.article.toBaseItems()
    )
}

fun ImageView.setImageByUrl(url: String) {
    Glide.with(this.context)
        .load(url)
        .into(this)
}

fun Context.createIntentForShareNews(urlNews: String?, getSubject: String, getTitleShareMenu:String){
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, getSubject)
        putExtra(Intent.EXTRA_TEXT, urlNews)
    }

    this.startActivity(Intent.createChooser(intent, getTitleShareMenu))
}

fun SearchView.setOnQueryListener(submit: (String?) -> Boolean) {
    this.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?): Boolean {
            return submit(query)
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            return false
        }
    })
}


/*setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    viewModel.setWord(query)
                    initView()
                    initObserver()
                    hideKeyboard(search_bar)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })*/
