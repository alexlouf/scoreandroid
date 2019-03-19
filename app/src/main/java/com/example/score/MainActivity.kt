package com.example.score

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.io.Serializable
import java.util.*

class Score(point: String, date: String) : Serializable {
    var point = point
    var date = date
}

class Stockage() : Serializable {
    var array = mutableListOf<Score>()

    fun push(score: Score) {
        array.add(score)
    }
}

var data = Stockage()

class MainActivity : AppCompatActivity() {

   // var data = Stockage()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val result = findViewById<TextView>(R.id.textView)
        val plus = findViewById<Button>(R.id.button2)
        val moins = findViewById<Button>(R.id.button)
        val save = findViewById<Button>(R.id.button3)
        val see = findViewById<Button>(R.id.button4)

        plus.setOnClickListener{
            increase(result)
        }

        moins.setOnClickListener{
            decrease(result)
        }

        save.setOnClickListener{
            save(result)
        }

        see.setOnClickListener{
            showScore(data)
        }
    }

    private fun increase(result: TextView) {
       var temp = Integer.parseInt(result.text as String)
        temp += 1
        result.text = temp.toString()
    }

    private fun decrease(result: TextView) {
        var temp = Integer.parseInt(result.text as String)
        temp -= 1
        result.text = temp.toString()
    }

    private fun save(result: TextView) {
        val date = Date().toString()
        val score = Score(result.text.toString(), date)
        data.push(score)
    }

    private fun showScore(array: Stockage) {
        val intent = Intent(this, Main2Activity::class.java)
        var j = 0
        intent.putExtra("data", data)

        startActivity(intent)
    }
}
