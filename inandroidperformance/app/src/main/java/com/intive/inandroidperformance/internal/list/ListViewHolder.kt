package com.intive.inandroidperformance.internal.list

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.intive.inandroidperformance.R

internal class ListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val label: TextView = view.findViewById(R.id.value)
    private val index: TextView = view.findViewById(R.id.index)

    fun setData(position: Int, value: Int) {
        label.text = "$value"
        index.text = "$position"
    }
}