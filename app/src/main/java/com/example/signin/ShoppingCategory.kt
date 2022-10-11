package com.example.signin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_shopping_category.*

class ShoppingCategory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_category)

        val intent = intent
        val email = intent.getStringExtra("email")
        welcomeEmail.text = "welcome $email"

        imgbtnElectronics.setOnClickListener() {
            Toast.makeText(this,"You have chosen the ${textEle.text.toString()} category of shopping.", Toast.LENGTH_LONG).show()
        }

        imgbtnClothing.setOnClickListener() {
                Toast.makeText(this,"You have chosen the ${txtClothing.text.toString()} category of shopping.", Toast.LENGTH_LONG).show()
            }

        imgbtnBeauty.setOnClickListener(){
            Toast.makeText(this,"You have chosen the ${txtBeauty.text.toString()} category of shopping.", Toast.LENGTH_LONG).show()
        }

        imgbtnFood.setOnClickListener(){
            Toast.makeText(this,"You have chosen the ${txtFood.text.toString()} of shopping.", Toast.LENGTH_LONG).show()
        }
    }
}