package com.ljg.chat2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class MessageAdapter(val context:Context,val messageList:ArrayList<Message>):RecyclerView.Adapter<MessageAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView=LayoutInflater.from(context).inflate(R.layout.item_message,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return messageList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(messageList[position])
    }

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var messageTv: TextView=itemView.findViewById(R.id.message_tv)
        var timeTv:TextView=itemView.findViewById(R.id.time_tv)

        fun bind(message:Message){
            messageTv.text=message.message
            timeTv.text=String.format("%02d:%02d",message.date.hours,message.date.minutes)
        }

    }
}