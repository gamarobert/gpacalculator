package com.example.robertgama.gpacalculator

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

private var courses = arrayListOf<Info> ()

data class Info(val course : String, val grade : String, val units : String)

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val listView = findViewById<ListView>(R.id.prev_listview)

        val adapter = ArrayAdapter(this, R.layout.preview_row, R.id.prevClassTextView, courses)

        listView.adapter = object : ArrayAdapter<Info>(this, R.layout.preview_row, R.id.prevClassTextView, courses) {
              private val mContext: Context = context

            override fun getCount(): Int {
                  return courses.size

                }

              override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
                  val layoutInflater = LayoutInflater.from(mContext)
                  val previewRow = layoutInflater.inflate(R.layout.preview_row, parent, false)

                  val courseTextView = previewRow.findViewById<TextView>(R.id.prevClassTextView)
                  courseTextView.text = "Course: ${courses[position].course} Units: ${courses[position].units}"

                  return previewRow
              }
          }

        addButtonID.setOnClickListener {
            val course: String = courseInput.text.toString()
            val grade: String = gradeInput.text.toString()
            val unit: String = unitInput.text.toString()

            //check if the EditText have values or not
            if(course.isNotEmpty() && grade.isNotEmpty() && unit.isNotEmpty()) {
                adapter.add(Info(courseInput.text.toString(), gradeInput.text.toString(), unitInput.text.toString()))

                courseInput.text.clear()
                gradeInput.text.clear()
                unitInput.text.clear()
            }else{
                Toast.makeText(applicationContext, "Don't leave any fields blank!", Toast.LENGTH_SHORT).show()
            }

        }


        doneButton.setOnClickListener{

            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            intent.putExtra("ARRAY_NAME", courses  )

            startActivity(intent)

        }

    }

}
