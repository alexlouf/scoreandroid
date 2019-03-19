package com.example.score

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.*
import java.io.Serializable
import java.util.*

class Main2Activity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //var data2 = Stockage()

        val stockage: Stockage = intent.extras["data"] as Stockage
        val tableView = findViewById<TableLayout>(R.id.tablelayout)
        val button = findViewById<Button>(R.id.button7)

        button.setOnClickListener{
            addLigne(tableView)
        }


        for (i in stockage.array) {
            val row = TableRow(this)
            val text = TextView(this)
            text.text = "pt(s) : " + i.point + " à : " + Date(i.date).hours.toString() + "h " +Date(i.date).minutes.toString() + "m " + Date(i.date).seconds.toString() +"s"
            text.textSize = 24F
            val params = TableRow.LayoutParams()
            params.gravity = Gravity.CENTER
            row.addView(text)
            tableView.addView(row)
        }


    }

    private fun addLigne(tableView : TableLayout) {
        val row = TableRow(this)
        val textInput = EditText(this)
        row.addView(textInput)
        tableView.addView(row)
    }
}
