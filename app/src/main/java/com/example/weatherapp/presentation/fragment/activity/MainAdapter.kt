package com.example.weatherapp.presentation.fragment.activity

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.weatherapp.data.model.Forecastday
import com.example.weatherapp.databinding.ItemItemBinding
import com.example.weatherapp.presentation.fragment.loadImage

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    private var list : ArrayList<Forecastday> = arrayListOf()


    @SuppressLint("NotifyDataSetChanged")
    fun addList(list: List<Forecastday>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MainViewHolder (
        ItemItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount() = list.size


    inner class MainViewHolder(private var binding: ItemItemBinding) : ViewHolder(binding.root) {
        fun onBind(mainModel: Forecastday) {
            binding.txtData.text = mainModel.date
            binding.grad35.text = mainModel.day.maxtemp_c.toString()
            binding.grad26.text = mainModel.day.mintemp_c.toString()
            binding.imgSunny.loadImage(mainModel.day.condition.icon)
        }
    }
}
