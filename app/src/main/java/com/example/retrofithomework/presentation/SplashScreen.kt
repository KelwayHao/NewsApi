package com.example.retrofithomework.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofithomework.presentation.viewmodel.NewsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

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

    private fun initObserver() {
        viewModel.news.observe(this) { listNews ->
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


}