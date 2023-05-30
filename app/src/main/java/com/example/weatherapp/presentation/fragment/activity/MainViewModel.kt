package com.example.weatherapp.presentation.fragment.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.core.UIState
import com.example.weatherapp.data.model.MainResponse
import com.example.weatherapp.data.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: WeatherRepository
): ViewModel() {

    var liveData: LiveData<UIState<MainResponse>> = MutableLiveData()

    fun getWeather(cityName: String){
        liveData = repository.getWeather(cityName)
    }
}