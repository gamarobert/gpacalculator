package com.example.robertgama.gpacalculator

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.display_row.*


class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val newArray = getIntent().getExtras().getSerializable("listPASS") as ArrayList<Info>

        val newListView = findViewById<ListView>(R.id.displayView)

        // https://medium.com/@developine/serialize-deserialize-data-class-in-kotlin-dfaec8b63f05

        val adapter =  ArrayAdapter(this, R.layout.display_row, R.id.displayView, newArray)

        newListView?.adapter = adapter

        newListView.adapter = object : ArrayAdapter<Info>(this, R.layout.display_row, R.id.displayView, newArray) {

            private val mContext: Context = context

            override fun getCount(): Int {
                return newArray.size
            }

            override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
                val layoutInflater = LayoutInflater.from(mContext)
                val mainRow = layoutInflater.inflate(R.layout.display_row, parent, false)

                val classname = mainRow.findViewById<TextView>(R.id.classDisplayID)
                classname.text = newArray[position].course

                return mainRow
            }
        }
    }

//getIntent().getExtras().getSerializableExtra(EXTRA_PEOPLE) as? People


}


