package com.example.daopractice.fragments.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.daopractice.R
import com.example.daopractice.data.User
import org.w3c.dom.Text

class ListAdapter: RecyclerView.Adapter<com.example.daopractice.fragments.list.ListAdapter.MyViewHolder>() {

    private var userList= emptyList<User>()


    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var id_txt: TextView = itemView.findViewById(R.id.id_txt)
        var firstName: TextView= itemView.findViewById(R.id.firstName_txt)
        var lastName: TextView= itemView.findViewById(R.id.lastName_txt)
        var age: TextView= itemView.findViewById(R.id.age)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem= userList[position]
        holder.id_txt.text= currentItem.id.toString()
        holder.firstName.text= currentItem.firstName
        holder.lastName.text= currentItem.lastName
        holder.age.text= currentItem.age.toString()

    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setData(user: List<User>){
        this.userList= user
        notifyDataSetChanged()
    }

}