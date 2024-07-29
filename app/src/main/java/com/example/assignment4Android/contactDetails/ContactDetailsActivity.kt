package com.example.assignment4Android.contactDetails

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.assignment4.R
import com.example.assignment4.databinding.ActivityContactDetailsBinding

open class ContactDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityContactDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

   binding.detailsNameTv.text =  intent.getStringExtra("name")
   binding.detailsPhoneNumberTv.text = intent.getStringExtra("phone" )



    }
}