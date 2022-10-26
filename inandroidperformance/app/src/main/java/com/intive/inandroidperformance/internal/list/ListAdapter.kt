package com.intive.inandroidperformance.internal.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.intive.inandroidperformance.R

internal class ListAdapter(
    private val dataProvider: DataProvider,
) : RecyclerView.Adapter<ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        android.util.Log.d("ListAdapter", "onCreateViewHolder(...)")
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fibonacci_item, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        android.util.Log.d("ListAdapter", "onBindViewHolder(...)")
        holder.setData(position, dataProvider.provideData(position))
    }

    override fun getItemCount(): Int = 9_999_999
}