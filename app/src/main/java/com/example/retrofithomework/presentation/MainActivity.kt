package com.example.retrofithomework.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.widget.ProgressBar
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofithomework.R
import com.example.retrofithomework.presentation.recycler.BaseAdapter
import com.example.retrofithomework.presentation.recycler.clicklisteners.OnItemClickListener
import com.example.retrofithomework.presentation.viewmodel.NewsViewModel
import com.example.retrofithomework.utils.extensions.createIntentForShareNews
import com.example.retrofithomework.utils.extensions.hideKeyboard
import com.example.retrofithomework.utils.extensions.setOnQueryListener
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: NewsViewModel by viewModel()
    private val adapter by lazy { BaseAdapter(shareNews) }

    private val shareNews by lazy {
        object : OnItemClickListener {
            override fun onShareButtonClickListener(urlNews: String) {
                createIntentForShareNews(
                    urlNews,
                    getString(R.string.news),
                    getString(R.string.share)
                )
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        searchNews()
        initView()
        initObserver()
    }

    private fun searchNews() {
        searchBar.setOnQueryListener { stringQuery ->
            viewModel.setWord(stringQuery.toString())
            circularProgressBar.visibility = ProgressBar.VISIBLE
            hideKeyboard(searchBar)
            return@setOnQueryListener true
        }
    }

    private fun initView() {
        recyclerDate.adapter = adapter
    }

    @SuppressLint("SetTextI18n")
    private fun initObserver() {
        viewModel.news.observe(this) { listNews ->
            circularProgressBar.visibility = ProgressBar.INVISIBLE
            textDisplayNumberOfResult.text =
                "${getString(R.string.numbers_of_result, listNews.amountNews)} "
            adapter.submitList(listNews.listNews)
        }
    }
}