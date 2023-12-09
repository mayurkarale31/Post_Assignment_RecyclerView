package com.example.taskactivity_assignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class CreatePostAdapter(
    private val posts : ArrayList<Post>)
    : RecyclerView.Adapter<CreatePostAdapter.PostViewHolder>(){

        interface OnPostClickListener{
            fun onPostClick(position: Int, post: Post, view: View)
        }

    var onPostClickListener : OnPostClickListener? = null

        inner class PostViewHolder(view : View) : RecyclerView.ViewHolder(view){
            val imgSender : ImageView
            val txtName : TextView
            val txtAddress : TextView
            val txtRent : TextView

            init {
                imgSender = view.findViewById(R.id.imgSender)
                txtName = view.findViewById(R.id.txtName)
                txtAddress = view.findViewById(R.id.txtAddress)
                txtRent = view.findViewById(R.id.txtRent)

                itemView.setOnClickListener {
                    if (onPostClickListener != null) {
                        onPostClickListener!!.onPostClick(
                            adapterPosition,
                            posts[adapterPosition],
                            it
                        )
                    }
                }
            }

        }

    override fun getItemCount() = posts.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.create_post_view, null)

        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.imgSender.setImageResource(posts[position].imgRoom)
        holder.txtName.text = posts[position].name
        holder.txtAddress.text = posts[position].address
        holder.txtRent.text = posts[position].rent.toString()
    }
}