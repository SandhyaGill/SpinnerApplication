package com.example.spinnerapplication

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.spinnerapplication.databinding.ActivityMainBinding
import com.example.spinnerapplication.databinding.DialogBoxBinding

class MainActivity : AppCompatActivity() {
    lateinit var  binding: ActivityMainBinding
    var itemsCount = arrayListOf<String>()
//    var items = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        spinner()
    binding.fab.setOnClickListener {
        showDialog()
    }
    }
    fun showDialog(){
        var dialogBinding = DialogBoxBinding.inflate(layoutInflater)
        var dialog = Dialog(this).apply {
            setContentView(dialogBinding.root)
            window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
            )
            show()
        }
        dialogBinding.btnSave.setOnClickListener {
            itemsCount.add(dialogBinding.etName.text.toString())
            dialog.cancel()
        }
//
    }
    fun spinner(){
        var items = arrayOf("1","2","3","4","5")
        itemsCount.add("Test Item")
        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item, itemsCount)
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        binding.spinner.adapter = adapter
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                var item = parent?.getItemAtPosition(position).toString()
                Toast.makeText(this@MainActivity,"$item" ,Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }
}