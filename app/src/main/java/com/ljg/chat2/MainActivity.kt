package com.ljg.chat2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var messageRv:RecyclerView
    lateinit var messageEt:EditText
    lateinit var sendBtn:Button
    lateinit var messageAdapter:MessageAdapter
    lateinit var messageList:ArrayList<Message>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        messageRv=findViewById(R.id.message_rv)
        messageEt=findViewById(R.id.message_et)
        sendBtn=findViewById(R.id.send_btn)

        messageList= ArrayList()
        messageAdapter= MessageAdapter(this,messageList)

        messageRv.adapter=messageAdapter
        messageRv.layoutManager=LinearLayoutManager(this)

        sendBtn.setOnClickListener { sendMessage() }

    }
    fun sendMessage(){
        if (messageEt.text.equals("")){
            return
        }
        var message=Message(messageEt.text.toString())
        messageList.add(message)
        messageAdapter.notifyDataSetChanged()
        messageEt.setText("")
    }
}
