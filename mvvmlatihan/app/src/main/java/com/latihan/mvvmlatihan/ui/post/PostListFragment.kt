package com.latihan.mvvmlatihan.ui.post

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.latihan.mvvmlatihan.R
import com.latihan.mvvmlatihan.domain.entity.PostModel
import com.latihan.mvvmlatihan.utils.Resource
import com.latihan.mvvmlatihan.utils.ResourceState
import kotlinx.android.synthetic.main.post_list_fragment.*

class PostListFragment : Fragment() {

    private lateinit var adapter: PostAdapter

    companion object {
        fun newInstance() = PostListFragment()
    }

    private lateinit var viewModel: PostListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as? AppCompatActivity)?.supportActionBar?.title = "Post"
        return inflater.inflate(R.layout.post_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(requireActivity()).get(PostListViewModel::class.java)

        adapter = PostAdapter()
        rv_post.adapter = adapter
        rv_post.layoutManager = LinearLayoutManager(requireContext())

        viewModel.getResource().observe(viewLifecycleOwner, Observer {
            handleResult(it)
        })

        itemCallback()

    }


    private fun handleResult(resource: Resource<List<PostModel>>) {
        when(resource.state){
            ResourceState.SUCCESS -> {
                progress_bar.visibility = View.GONE
                resource.data?.apply {
                    adapter.bind(this)
                }
                Log.e("ResourceState","Success")
            }
            ResourceState.LOADING -> {
                Log.e("ResourceState","Loading")
                progress_bar.visibility = View.VISIBLE
            }
            ResourceState.ERROR -> {
                Log.e("ResourceState","Error")
                progress_bar.visibility = View.GONE
                Toast.makeText(requireContext(), "No Internet Connection", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun itemCallback(){
        adapter.setOnItemClickCallback(object : PostAdapter.OnItemClickCallback{
            override fun onItemClicked(post: PostModel) {
                viewModel.insertPost(post)
                Toast.makeText(requireContext(), "Favorite Post added to list", Toast.LENGTH_SHORT).show()
            }
        })
    }

}
