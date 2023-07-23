package com.example.recyclerviewproject

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewproject.databinding.ActivityMainBinding
import com.example.recyclerviewproject.databinding.CustomDialogLayoutBinding

class MainActivity : AppCompatActivity() {
    private val arrayList = arrayListOf<StudentInfo>()
    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerAdapter: RecyclerAdapter
    private lateinit var layoutManager: LinearLayoutManager
    //lateinit var clicks: Clicks
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerAdapter = RecyclerAdapter(arrayList, this)
        layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = recyclerAdapter

        binding.fab.setOnClickListener {
            val dialog = Dialog(this)
            val dialogBinding = CustomDialogLayoutBinding.inflate(layoutInflater)
            dialog.setContentView(dialogBinding.root)
            dialog.setCancelable(false)

            dialogBinding.btnAdd.setOnClickListener {
                val name = dialogBinding.etName.text.toString()
                val rollNo = dialogBinding.etRoll.text.toString()

                if (name.isEmpty()) {
                    dialogBinding.etName.error = "Please Enter your name"
                } else if (rollNo.isEmpty()) {
                    dialogBinding.etRoll.error = "Please Enter the roll no"
                } else {
                    arrayList.add(StudentInfo(name, rollNo.toInt()))
                    recyclerAdapter.notifyDataSetChanged()
                    Toast.makeText(this, "Added successfully", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
            }

            dialog.show()
        }

    }
}

    /*override fun ClickUpdate(position: Int) {
        Toast.makeText(this, "hi", Toast.LENGTH_SHORT).show()

        var dialog=Dialog(this)
        var dialogBinding = CustomDialogLayoutBinding.inflate(layoutInflater)
        dialog.setCancelable(false)
        dialog.setContentView(dialogBinding.root)
        dialogBinding.btnAdd.setText("Update")
        dialogBinding.btnAdd.setOnClickListener {
            if (dialogBinding.etName.text.toString().isNullOrEmpty()) {
                dialogBinding.etName.error="Enter your name"
            } else if (dialogBinding.etRoll.text.toString().isNullOrEmpty()) {
                dialogBinding.etRoll.error="Enter your roll no"
            } else {
                arrayList.set(position,StudentInfo(dialogBinding.etName.text.toString(),dialogBinding.etRoll.text.toString().toInt()))
                recyclerAdapter.notifyDataSetChanged()
                dialog.dismiss()
            }
        }
        dialog.show()

    }

    override fun ClickDelete(position: Int) {
        arrayList.removeAt(position)
        recyclerAdapter.notifyDataSetChanged()
    }
}*/


