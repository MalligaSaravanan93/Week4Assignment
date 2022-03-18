package com.malliga.week4assignment.adapter

import android.content.Context
import android.graphics.Color
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.malliga.week4assignment.R
import com.malliga.week4assignment.Utils.Companion.dateFormat
import com.malliga.week4assignment.databinding.RoomListLayoutBinding
import com.malliga.week4assignment.model.RoomsItem

class RoomViewHolder(val binding: RoomListLayoutBinding, val context: Context): RecyclerView.ViewHolder(binding.root) {
    fun onBind(room: RoomsItem){
        binding.roomListName.text = room.name
        binding.roomListCreateDate.text = dateFormat.format(room.getDate())
        binding.roomListOccupancyCount.text = room.maxOccupancy.toString()
        //binding.roomListStatus.text = room.isOccupied.toString()

        val roomStatus = room.isOccupied
        if(roomStatus == true){
            binding.roomListStatus.text = "Occupied"
            binding.roomListStatus.setBackgroundColor(ContextCompat.getColor(context, R.color.purple_500))
        }
        else{
            binding.roomListStatus.text = "Not Occupied"
            binding.roomListStatus.setBackgroundColor(ContextCompat.getColor(context, R.color.black))
        }
    }
}