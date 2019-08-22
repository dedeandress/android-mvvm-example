package com.latihan.mvvmlatihan.ui.post

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.latihan.mvvmlatihan.R
import com.latihan.mvvmlatihan.domain.entity.PostModel
import kotlinx.android.synthetic.main.item_post.view.*

class PostAdapter: RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    private val items: ArrayList<PostModel> = arrayListOf()

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun bind(items: List<PostModel>) {
        this.items.clear()
        if(items.isNotEmpty()) {
            this.items.addAll(items)
        }
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindPost(items[position])
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(items[position]) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return ViewHolder(view)
    }

    inner class ViewHolder(private val view: View): RecyclerView.ViewHolder(view){

        fun bindPost(post: PostModel) {
            view.title.text = post.title
            view.body.text = post.body
        }
    }

    interface OnItemClickCallback{
        fun onItemClicked(post: PostModel)
    }
}