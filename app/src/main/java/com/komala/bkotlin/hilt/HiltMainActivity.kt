package com.komala.bkotlin.hilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.komala.bkotlin.R
import com.komala.bkotlin.api.User
import com.komala.bkotlin.utility.Status
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_hilt_main.*

@AndroidEntryPoint
class HiltMainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var adapter: MainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hilt_main)
        setupUI()
        setupObserver()
    }

    private fun setupUI() {
        recycler_view_users.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(arrayListOf())
        recycler_view_users.addItemDecoration(
            DividerItemDecoration(
                recycler_view_users.context,
                (recycler_view_users.layoutManager as LinearLayoutManager).orientation
            )
        )
        recycler_view_users.adapter = adapter
    }

    private fun setupObserver() {
        mainViewModel.users.observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    progressbar.visibility = View.GONE
                    it.data?.let { users -> renderList(users) }
                    recycler_view_users.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    progressbar.visibility = View.VISIBLE
                    recycler_view_users.visibility = View.GONE
                }
                Status.ERROR -> {
                    progressbar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun renderList(users: List<User>) {
        adapter.addData(users)
        adapter.notifyDataSetChanged()
    }
}