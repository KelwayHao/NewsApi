package com.example.retrofithomework.presentation

import android.app.DownloadManager
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.retrofithomework.R
import com.example.retrofithomework.domain.models.NewsInfo
import com.example.retrofithomework.presentation.viewmodel.NewsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class SplashScreen : AppCompatActivity() {

    private val viewModel: NewsViewModel by viewModel()

    override fun onStart() {
        super.onStart()
        searchNews()
        initObserver()
    }

    private fun searchNews() {
        viewModel.setWordSplashScreen("Android",3L, 4L)
    }

    private lateinit var observer: Observer<NewsInfo>

    private fun initObserver() {

        observer = Observer<NewsInfo> { listNews->
            intent = Intent(this, MainActivity::class.java)
            intent.putExtra("Android", listNews)
            startActivity(intent)
            finish()

        }

        viewModel.news.observe(this, observer)
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.news.removeObserver(observer)
    }
}
