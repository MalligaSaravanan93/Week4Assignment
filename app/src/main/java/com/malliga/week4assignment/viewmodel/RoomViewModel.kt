package com.malliga.week4assignment.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.malliga.week4assignment.model.People
import com.malliga.week4assignment.model.Rooms
import com.malliga.week4assignment.model.RoomsItem
import com.malliga.week4assignment.network.RoomApi
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class RoomViewModel(): ViewModel() {
    private val _roomdata : MutableLiveData<Rooms> = MutableLiveData<Rooms>()
    val roomdata : LiveData<Rooms> get() = _roomdata

    private val _peopledata : MutableLiveData<People> = MutableLiveData<People>()
    val peopledata : LiveData<People> get() = _peopledata

    fun getRoomData(){
        RoomApi.initRetrofit().roomData()
            .enqueue(object : retrofit2.Callback<Rooms> {
                override fun onResponse(call: Call<Rooms>, response: Response<Rooms>) {
                    if(response.isSuccessful){
                        response.body()?.let {
                            _roomdata.value = it
                        }
                    }
                }

                override fun onFailure(call: Call<Rooms>, t: Throwable) {
                    Log.d("Error", "onFailure: "+t.localizedMessage)
                }

            })
    }

    fun getPeopleData(){
        RoomApi.initRetrofit().peopleData()
            .enqueue(object : retrofit2.Callback<People> {
                override fun onResponse(call: Call<People>, response: Response<People>) {
                    if(response.isSuccessful){
                        response.body()?.let {
                            _peopledata.value = it
                        }
                    }
                }

                override fun onFailure(call: Call<People>, t: Throwable) {
                    Log.d("Error", "onFailure: "+t.localizedMessage)
                }

            })
    }
}
