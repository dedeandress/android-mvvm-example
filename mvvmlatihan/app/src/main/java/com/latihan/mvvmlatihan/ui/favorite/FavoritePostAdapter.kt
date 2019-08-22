package com.latihan.mvvmlatihan.ui.favorite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.latihan.mvvmlatihan.R
import com.latihan.mvvmlatihan.domain.entity.PostModel
import kotlinx.android.synthetic.main.item_post.view.*

class FavoritePostAdapter: RecyclerView.Adapter<FavoritePostAdapter.ViewHolder>() {

    private val items: ArrayList<PostModel> = arrayListOf()

    fun bind(items: List<PostModel>) {
        this.items.clear()
        if(items.isNotEmpty()) {
            this.items.addAll(items)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindPost(items[position])
    }


    inner class ViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        fun bindPost(post: PostModel) {
            view.title.text = post.title
            view.body.text = post.body
        }
    }
}