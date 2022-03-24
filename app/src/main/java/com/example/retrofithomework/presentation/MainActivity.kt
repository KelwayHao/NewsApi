package com.example.retrofithomework.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        initView()
        initObserver()
        searchNews()
    }

    private fun initView() {
        recyclerDate.adapter = adapter
    }

    private fun initObserver() {

    }

    private fun searchNews() {
        //search_bar.
    }
}