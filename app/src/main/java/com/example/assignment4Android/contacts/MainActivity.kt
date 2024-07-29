package com.example.assignment4Android.contacts

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment4.R
import com.example.assignment4.databinding.ActivityContactsHomeBinding
import com.example.assignment4Android.contactDetails.ContactDetailsActivity
import com.example.assignment4Android.models.ContactsDM

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ContactsAdapter
    var contacts = ArrayList<ContactsDM>()

    lateinit var binding : ActivityContactsHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactsHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ContactsAdapter(contacts){contacts , index ->

            openDetailsContactActivity(contacts.name , contacts.phoneNumber)
        }

        binding.saveBtn.setOnClickListener {
            recyclerView = findViewById(R.id.saved_contacts_rv)
            recyclerView.adapter = adapter
            saveBtnClick()
        }

    }

    fun saveBtnClick() {
        if (binding.nameText.text.isNotEmpty() && binding.phonenumberText.text.isNotEmpty()) {
            contacts.add(
                ContactsDM(
                    name = binding.nameText.text.toString(),
                    phoneNumber = binding.phonenumberText.text.toString()
                )
            )
        }else
        {
            Toast.makeText(this,"Please enter your contact data",Toast.LENGTH_SHORT).show()
        }
    }

    fun openDetailsContactActivity( nameResId : String , phoneResId : String ){
        val intent = Intent(this , ContactDetailsActivity::class.java)
        intent.putExtra("name" , nameResId)
        intent.putExtra("phone" , phoneResId)
        startActivity(intent)
    }
    }



