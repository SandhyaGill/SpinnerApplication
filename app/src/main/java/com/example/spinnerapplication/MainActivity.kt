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
    var array = arrayListOf<String>("Testing","Testing 1","Testing 2")
    lateinit var arrayAdapter: ArrayAdapter<String>
    var spinnerAdapter = SpinnerAdapter(array)
    var companyArray = arrayListOf<CompanyModel>(CompanyModel(1,"o7 Services","Jal"),
        CompanyModel(1,"o7 Solutions","Jal"),
        CompanyModel(1,"o7 Tec","Hsp"))

    lateinit var companyAdapter: ArrayAdapter<CompanyModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, array)
        binding.adapterSpinner.adapter = arrayAdapter

        binding.userClassSpinner.adapter = spinnerAdapter

        companyAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, companyArray)
        binding.companySpinner.adapter = companyAdapter

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
            array.add(dialogBinding.etName.text.toString())
            dialog.cancel()
        }
    }


}