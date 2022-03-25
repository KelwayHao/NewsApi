package com.example.retrofithomework.presentation

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofithomework.R
import com.example.retrofithomework.presentation.recycler.BaseAdapter
import com.example.retrofithomework.presentation.recycler.clicklisteners.OnClickShareListener
import com.example.retrofithomework.presentation.viewmodel.NewsViewModel
import com.example.retrofithomework.utils.extensions.hideKeyboard
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: NewsViewModel by viewModel()
    private val adapter by lazy { BaseAdapter(shareNews) }

    private val shareNews by lazy {
        object : OnClickShareListener {
            override fun sendNews(urlNews: String?) {
                val intent = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_SUBJECT, "News")
                    putExtra(Intent.EXTRA_TEXT, urlNews)
                }
                startActivity(Intent.createChooser(intent, "Share"))
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
    }

    private fun searchNews() {
        search_bar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
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
        })
    }

    private fun initView() {
        recyclerDate.adapter = adapter
    }

    @SuppressLint("SetTextI18n")
    private fun initObserver() {
        viewModel.news.observe(this) { mapList ->
            textDisplayNumberOfResult.text =
                "${getString(R.string.numbers_of_result)} ${mapList.keys.first()}"
            adapter.submitList(mapList.values.first())
        }
    }
}