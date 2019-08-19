package com.latihan.mvvmlatihan.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.latihan.mvvmlatihan.R
import kotlinx.android.synthetic.main.post_list_fragment.*

class PostListFragment : Fragment() {

    companion object {
        fun newInstance() = PostListFragment()
    }

    private lateinit var viewModel: PostListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.post_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PostListViewModel::class.java)

        viewModel.getPost().observe(viewLifecycleOwner, Observer {
            textview.text = it.toString()
        })
    }

}
