package com.example.retrofithomework.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import com.example.retrofithomework.R
import com.example.retrofithomework.presentation.recycler.BaseAdapter
import com.example.retrofithomework.presentation.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: NewsViewModel by viewModel()
    private val adapter by lazy { BaseAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        searchNews()
    }

    private fun searchNews() {
        search_bar.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                textDisplayNumberOfResult.text = query
                initView()
                initObserver()
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

    private fun initObserver() {

    }
}