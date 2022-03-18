package com.malliga.week4assignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.malliga.week4assignment.databinding.PeopleListLayoutBinding
import com.malliga.week4assignment.model.PeopleItem

class PeopleAdapter : RecyclerView.Adapter<PeopleViewHolder> {

    private lateinit var peoplelists : List<PeopleItem>

    constructor(peoplesItem: List<PeopleItem>): super(){
        this.peoplelists = peoplesItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PeopleViewHolder (
        PeopleListLayoutBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        ),parent.context
    )

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        holder.onBind(peoplelists[position])
    }

    override fun getItemCount(): Int {
        return peoplelists.size
    }
}