package com.malliga.week4assignment.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.malliga.week4assignment.databinding.PeopleListLayoutBinding
import com.malliga.week4assignment.model.PeopleItem
import com.malliga.week4assignment.network.PeopleApi
import com.malliga.week4assignment.network.RoomApi
import com.squareup.picasso.Picasso

class PeopleViewHolder(val binding: PeopleListLayoutBinding, val context: Context): RecyclerView.ViewHolder(binding.root) {
    fun onBind(people: PeopleItem){
        binding.peopleListName.text = people.firstName +" " + people.lastName
        binding.peopleListEmail.text = people.email
        binding.peopleListJobTitle.text = people.jobTitle

        Picasso
            .get()
            .load(RoomApi.IMAGE_URL+people.avatar[0]+".jpg")
            //.resize(50,50)
            .into(binding.peopleListImage)

    }
}