package com.example.solutionx

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.solutionx.databinding.ItemRecyclerBinding

class MainAdapter<T : AdapterModel>(
    private var items: List<T>,
    private val listener: MainInteractionListener<T>
) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        )

    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val currentItem = items[position]
        holder.binding.item = currentItem
        holder.binding.listener = listener
        holder.binding.executePendingBindings() // Ensure immediate binding

    }

    fun setItems(newList: List<T>) {
        items = newList
        notifyDataSetChanged()
    }


    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemRecyclerBinding.bind(itemView)

    }
}

interface MainInteractionListener<T:AdapterModel> {
    fun onClickItem(item: T)
}