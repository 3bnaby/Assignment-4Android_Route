package com.example.assignment4Android.contacts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.assignment4.R
import com.example.assignment4Android.models.ContactsDM

class ContactsAdapter (var contacts : ArrayList<ContactsDM> , var onClick : (contact:ContactsDM , index:Int) -> Unit)
    : Adapter<ContactsAdapter.MyViewHolder>() {


    class MyViewHolder (itemView : View) : ViewHolder(itemView) {

        var nameTextView : TextView = itemView.findViewById(R.id.contact_name_rv)
        var phoneNumberTextView : TextView = itemView.findViewById(R.id.contact_phone_rv)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv , parent , false)
        return MyViewHolder(view)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val contactsDM = contacts[position]
        holder.nameTextView.text = contactsDM.name
        holder.phoneNumberTextView.text = contactsDM.phoneNumber
        holder.itemView.setOnClickListener{
            onClick.invoke(contactsDM , position)
        }
    }

    override fun getItemCount(): Int = contacts.size



}