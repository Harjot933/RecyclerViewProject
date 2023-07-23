package com.example.recyclerviewproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(var arrayList: ArrayList<StudentInfo>,  MainActivity : AppCompatActivity) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Declaration
        var tvName: TextView = view.findViewById(R.id.tvName)
        var tvRoll: TextView = view.findViewById(R.id.tvRollNo)
        var btnUpdate: Button = view.findViewById(R.id.btnUpdate)
        var btnDelete: Button = view.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
    return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName.text = arrayList[position].name
        holder.tvRoll.text = arrayList[position].roll.toString()
       // holder.btnUpdate.setOnClickListener {
         //   clicks.ClickUpdate(position)
       // holder.btnDelete.setOnClickListener{
         //   clicks.ClickDelete(position)
         //   }
      //  }

    }
}
