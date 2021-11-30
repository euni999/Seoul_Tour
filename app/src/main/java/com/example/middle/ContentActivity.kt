package com.example.middle

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.middle.data.Seoul
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.content.*

class ContentActivity : AppCompatActivity(){
    lateinit var datas: Seoul
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content)

        datas = intent.getSerializableExtra("data") as Seoul

        Glide.with(this).load(datas.pic).into(icon)
        var title: TextView = findViewById(R.id.title)
        title.text = datas.name
        address.text = datas.address
        desc.text = datas.content

    }
}

