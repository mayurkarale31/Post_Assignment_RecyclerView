package com.example.taskactivity_assignment

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class EditPost:AppCompatActivity() {

    private lateinit var name : String
    private lateinit var address : String
    private var rent : Int = 0

    private lateinit var image1 : ImageView
    private lateinit var image2 : ImageView
    private lateinit var image3 : ImageView
    private lateinit var editedName : EditText
    private lateinit var editedAddress : EditText
    private lateinit var editedRent : EditText
    private lateinit var btnUpdate : Button

    private lateinit var updatedName : String
    private lateinit var updatedAddress : String
    private var updatedRent : Int = 0
    private var selectedImage : Int =0

    private var position: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.edit_post)

        initData()
        initListener()

        name = intent.getStringExtra("name").toString()
        address = intent.getStringExtra("address").toString()
        rent = intent.getIntExtra("rent", 0).toString().toInt()

        editedName.setText(name)
        editedAddress.setText(address)
        editedRent.setText("$rent")

        btnUpdate.setOnClickListener{
            updatedName = editedName.text.toString()
            updatedAddress = editedAddress.text.toString()
            updatedRent = editedRent.text.toString().toInt()

            val intent = Intent()
            intent.putExtra("position", position)
            intent.putExtra("name", updatedName)
            intent.putExtra("address", updatedAddress)
            intent.putExtra("rent", updatedRent)
            intent.putExtra("selectedImage", selectedImage)

            setResult(3, intent)
            finish()
        }
    }
    private fun initData(){

        image1 = findViewById(R.id.image1)
        image2 = findViewById(R.id.image2)
        image3 = findViewById(R.id.image3)
        editedName = findViewById(R.id.editedName)
        editedAddress = findViewById(R.id.editedAddress)
        editedRent = findViewById(R.id.editedRent)
        btnUpdate = findViewById(R.id.btnUpdate)
    }

    private fun initListener(){
        image1.setOnClickListener {
            selectedImage = R.drawable.room1
        }
        image2.setOnClickListener {
            selectedImage = R.drawable.room2
        }
        image3.setOnClickListener {
            selectedImage = R.drawable.room3
        }
    }

}