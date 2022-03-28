package com.example.retrofithomework.utils.extensions

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.retrofithomework.data.models.ArticleResponse
import com.example.retrofithomework.data.models.NewsResponse
import com.example.retrofithomework.domain.models.BaseItem
import com.example.retrofithomework.domain.models.Date
import com.example.retrofithomework.domain.models.News
import com.example.retrofithomework.domain.models.NewsInfo

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