package com.ridhamsharma.alertdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
         var btnAlert: Button? = null
    var tvNumber: TextView? = null
    var item = arrayOf("Cat", "Dog", "Tiger")
    var  number =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvNumber = findViewById(R.id.tvNumber)
        btnAlert = findViewById(R.id.btnAlert)

        btnAlert?.setOnClickListener {
            var btnAlert = AlertDialog.Builder(this)
                .setTitle("Delete")
               // .setMessage("Do you want to delete it")
                .setCancelable(false)
                .setItems(item) { _, position ->
                    Toast.makeText(this, "Selected ${item[position]}", Toast.LENGTH_SHORT).show()
                }
                .setNeutralButton("new"){_,_,->
                    Toast.makeText(this,"clicked new",Toast.LENGTH_SHORT).show()
                    number = 0
                    tvNumber?.setText(number.toString())
                }
                .setPositiveButton("yes") { _, _ ->
                    Toast.makeText(this, "clicked Yes", Toast.LENGTH_SHORT).show()
                    number += 2
                    tvNumber?.setText(number.toString())
                }
                .setNegativeButton("No") { _, _ ->
                    Toast.makeText(this, "clicked No", Toast.LENGTH_SHORT).show()
                    number-= 2
                    tvNumber?.setText(number.toString())
                }
                btnAlert.show()


        }
    }

}
