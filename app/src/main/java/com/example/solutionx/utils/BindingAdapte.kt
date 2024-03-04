package com.example.solutionx.utils

import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.solutionx.AdapterModel
import com.example.solutionx.MainAdapter


@BindingAdapter("app:showWhenSelected")
fun showWhenSelected(view: View, condition: Boolean) {
    Log.d("hhh", "showWhenSelected called with condition: $condition")
    view.visibility = if (condition) View.VISIBLE else View.GONE
}

@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView, items: List<AdapterModel>?) {
    (view.adapter as MainAdapter<AdapterModel>?)?.setItems(items ?: emptyList())
}
