package com.latihan.mvvmlatihan.ui.favorite

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.latihan.mvvmlatihan.R
import com.latihan.mvvmlatihan.domain.entity.PostModel
import kotlinx.android.synthetic.main.favorite_fragment.*

class FavoriteFragment : Fragment() {

    companion object {
        fun newInstance() = FavoriteFragment()
    }

    private lateinit var viewModel: FavoriteViewModel

    private lateinit var adapter: FavoritePostAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as? AppCompatActivity)?.supportActionBar?.title = "Favorite Post"
        return inflater.inflate(R.layout.favorite_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(requireActivity()).get(FavoriteViewModel::class.java)
        adapter = FavoritePostAdapter()
        rv_favorite_post.adapter = adapter
        rv_favorite_post.layoutManager = LinearLayoutManager(requireContext())

        viewModel.favoritePost().observe(viewLifecycleOwner, Observer {
            adapter.bind(it)
        })

        adapter.setOnDeleteClickCallback(object : FavoritePostAdapter.OnDeleteClickCallback{
            override fun onItemClicked(post: PostModel) {
                viewModel.deletePost(post)
            }
        })

    }

}
