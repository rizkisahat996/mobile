package com.example.tubesss.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tubesss.R
import com.example.tubesss.data.Data
import com.example.tubesss.data.Task

class CustomAdapter(
    val context: Context,
    val taskList: List<Task>
) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        var itemView = LayoutInflater.from(context).inflate(R.layout.card_view_design, parent)
//        return ViewHolder(itemView)
//    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.card_view_design, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val task = taskList[position]
        holder.bind(task)
    }

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val taskView = LayoutInflater.from(context).inflate(R.layout.card_view_design, parent, false)
//        return ViewHolder(taskView)
//    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val textId: TextView = itemView.findViewById(R.id.textId)
        private val textUserId: TextView = itemView.findViewById(R.id.textUserId)
        private val textTitle: TextView = itemView.findViewById(R.id.textTitle)
        private val textDescription: TextView = itemView.findViewById(R.id.textDescription)
        private val textStatus: TextView = itemView.findViewById(R.id.textStatus)
        private val textDeadline: TextView = itemView.findViewById(R.id.textDeadline)


        fun bind(task: Task) {
            textId.text = task.id.toString()
            textUserId.text = task.user_id.toString()
            textTitle.text = task.title
            textDescription.text = task.description
            textStatus.text = task.status
            textDeadline.text = task.deadline
        }

    }

//    class ViewHolder(taskView: View) : RecyclerView.ViewHolder(taskView) {
//        var textId: TextView
//        var textTitle: TextView
//        var textDescription: TextView
//        var textStatus: TextView
//
//        init {
//            textId = taskView.textId
//            textTitle = taskView.textTitle
//            textDescription = taskView.textDescription
//            textStatus = taskView.textStatus
//        }
//    }

//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val task = taskList[position]
//
//        holder.textId.text = task.id.toString()
//        holder.textTitle.text = task.title
//        holder.textDescription.text = task.description
//        holder.textStatus.text = task.status
//    }

    override fun getItemCount() = taskList.size

//
//    override fun getItemCount(): Int {
//        holder.textId.text =taskList[position].textId.toString()
//        holder.textTitle.text =taskList[position].textTitle.toString()
//        holder.textDescription.text =taskList[position].textDescription.toString()
//        holder.textStatus.text =taskList[position].textStatus.toString()
//    }

//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        return taskList.size
//    }
}