package com.example.spinnerapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class SpinnerAdapter(var arrayList: ArrayList<String>) : BaseAdapter() {
    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(position: Int): Any {
        return arrayList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
      var initView = LayoutInflater.from(parent?.context).inflate(R.layout.spinner_item,parent, false)
      var tvTittle = initView.findViewById<TextView>(R.id.tvTittle)
        tvTittle.setText(arrayList[position])
        return initView
    }
}