package com.latihan.mvvmlatihan.ui.favorite

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IntegerRes
import androidx.recyclerview.widget.RecyclerView
import com.latihan.mvvmlatihan.R
import com.latihan.mvvmlatihan.domain.entity.PostModel
import kotlinx.android.synthetic.main.favorite_item.view.*
import kotlinx.android.synthetic.main.item_post.view.body
import kotlinx.android.synthetic.main.item_post.view.title

private const val TAG = "FavoritePostAdapter"

class FavoritePostAdapter: RecyclerView.Adapter<FavoritePostAdapter.ViewHolder>() {

    private val items: ArrayList<PostModel> = arrayListOf()

    private lateinit var onDeleteClickCallback: OnDeleteClickCallback

    fun setOnDeleteClickCallback(onDeleteClickCallback: OnDeleteClickCallback) {
        this.onDeleteClickCallback = onDeleteClickCallback
    }

    fun bind(items: List<PostModel>) {
        this.items.clear()
        if(items.isNotEmpty()) {
            this.items.addAll(items)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.favorite_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindPost(items[position])

        holder.deleteBtn.setOnClickListener { onDeleteClickCallback.onItemClicked(items[position]) }

        holder.moreBtn.setOnClickListener {
            holder.body.maxLines = Integer.MAX_VALUE
            holder.moreBtn.visibility = View.INVISIBLE
            holder.lessBtn.visibility = View.VISIBLE
        }

        holder.lessBtn.setOnClickListener {
            holder.body.maxLines = 3
            holder.moreBtn.visibility = View.VISIBLE
            holder.lessBtn.visibility = View.INVISIBLE
        }
    }


    inner class ViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        fun bindPost(post: PostModel) {
            view.title.text = post.title
            view.body.text = post.body
            view.body.maxLines = 3
        }

        val body = view.body


        val deleteBtn = view.delete_btn

        val moreBtn = view.btn_more

        val lessBtn = view.btn_less

    }

    interface OnDeleteClickCallback{
        fun onItemClicked(post: PostModel)
    }




}