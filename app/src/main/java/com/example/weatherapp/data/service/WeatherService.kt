package com.example.weatherapp.data.service


import com.example.weatherapp.BuildConfig.API_KEY
import com.example.weatherapp.data.model.MainResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherService {

    @GET("forecast.json")
    fun getCityWeatherData(
        @Query("q") name :String? = "London",
        @Query("key") key: String = API_KEY,
        @Query("days") days: Int = 7
    ):Call<MainResponse>

}