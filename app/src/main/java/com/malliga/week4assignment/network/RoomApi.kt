package com.malliga.week4assignment.network

import com.malliga.week4assignment.model.People
import com.malliga.week4assignment.model.Rooms
import com.malliga.week4assignment.model.RoomsItem
import com.malliga.week4assignment.network.RoomApi.Companion.ROOM_DATA
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RoomApi {
    @GET(
        ROOM_DATA
    )
    fun roomData():Call<Rooms>

    @GET(
        PEOPLE_DATA
    )
    fun peopleData():Call<People>
    companion object{
        fun initRetrofit(): RoomApi {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RoomApi::class.java)

        }
        const val IMAGE_URL="https://randomuser.me/api/portraits/"
        const val BASE_URL = "https://61d6afbe35f71e0017c2e74b.mockapi.io/api/v1/"
        const val ROOM_DATA = "rooms"
        const val PEOPLE_DATA = "people"
        //const val APPID = "65a333888ab1ef71d42c575349fe329b"

    }
}