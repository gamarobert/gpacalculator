package com.example.robertgama.gpacalculator

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }


//getIntent().getExtras().getSerializableExtra(EXTRA_PEOPLE) as? People
    val newArray = intent.extras.get("listPASS") as ArrayList<Info>

    val listView = findViewById<ListView>(R.id.displayAllID)

    // https://medium.com/@developine/serialize-deserialize-data-class-in-kotlin-dfaec8b63f05

    val adapter = ArrayAdapter(this, R.layout.display_row, R.id.classDisplayID, listPass)



    listView.adapter = object : ArrayAdapter<Info>(this, R.layout.display_row, R.id.classDisplayID, newArray){

        private val mContext: Context = context

        override fun getCount(): Int {
            return newArray.size

        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val layoutInflater = LayoutInflater.from(mContext)
            val previewRow = layoutInflater.inflate(R.layout.preview_row, parent, false)

            val courseTextView = previewRow.findViewById<TextView>(R.id.prevClassTextView)
            courseTextView.text = "Course: ${courses[position].course} Units: ${courses[position].units}"

            return previewRow
        }
    }



}


