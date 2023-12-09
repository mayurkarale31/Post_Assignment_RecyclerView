package com.example.taskactivity_assignment

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class CreatePost: AppCompatActivity() {

    private lateinit var img1 : ImageView
    private lateinit var img2 : ImageView
    private lateinit var img3 : ImageView
    private lateinit var edtName : EditText
    private lateinit var edtAddress : EditText
    private lateinit var edtRent : EditText
    private lateinit var btnMakePost : Button

    private var selectedImage : Int =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.post)

        initData()
        initListener()

        btnMakePost.setOnClickListener{
            val name = edtName.text.toString()
            val address = edtAddress.text.toString()
            val rent = edtRent.text.toString().toInt()

            val intent = Intent()
            intent.putExtra("name", name)
            intent.putExtra("address", address)
            intent.putExtra("rent", rent)
            intent.putExtra("image", selectedImage)

            setResult(1, intent)
            finish()
        }
    }
    private fun initData(){

        img1 = findViewById(R.id.img1)
        img2 = findViewById(R.id.img2)
        img3 = findViewById(R.id.img3)
        edtName = findViewById(R.id.edtName)
        edtAddress = findViewById(R.id.edtAddress)
        edtRent = findViewById(R.id.edtRent)
        btnMakePost = findViewById(R.id.btnMakePost)
    }

    private fun initListener(){
        img1.setOnClickListener {
            selectedImage = R.drawable.room1
        }
        img2.setOnClickListener {
            selectedImage = R.drawable.room2
        }
        img3.setOnClickListener {
            selectedImage = R.drawable.room3
        }
    }
}