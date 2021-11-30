package com.example.middle.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.middle.R
import com.example.middle.data.Seoul
import com.example.middle.data.type1
import com.example.middle.data.type2

class SeoulAdapter(val context: Context, private val seoulList: MutableList<Seoul>?=null)
    : RecyclerView.Adapter<SeoulAdapter.MyViewHolder>() {

    // 리사이클러뷰 클릭 이벤트
    interface OnItemClickListener{
        fun onItemClick(v:View, data: Seoul, pos: Int)
    }
    private var listener : OnItemClickListener? = null
    fun setOnItemClickListener(listener : OnItemClickListener) {
        this.listener = listener
    }

   inner class MyViewHolder(View: View) : RecyclerView.ViewHolder(View) {
       private var title: TextView = itemView.findViewById(R.id.title)
       private var address: TextView = itemView.findViewById(R.id.address)
       private var content: TextView = itemView.findViewById(R.id.desc)
       private var pic: ImageView = itemView.findViewById(R.id.icon)

       fun bind(seoul:Seoul) {
           title.text=seoul.name
           address.text=seoul.address
           content.text=seoul.content
           Glide.with(itemView).load(seoul.pic).into(pic)

           val pos = adapterPosition
           if(pos != RecyclerView.NO_POSITION)
           {
               itemView.setOnClickListener{
                   listener?.onItemClick(itemView,seoul,pos)
               }
           }
       }
   }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // 멀티뷰 구현
        val view:View?
        return when(viewType) {
            type1 -> {  // 여행지 뷰
                view = LayoutInflater.from(parent.context).inflate(R.layout.tour_main, parent, false)
                MyViewHolder(view)
            }
            type2 -> {  // 맛집 뷰
                view = LayoutInflater.from(parent.context).inflate(R.layout.food_main, parent, false)
                MyViewHolder(view)
            }
            else -> {  // 호텔 뷰
                view = LayoutInflater.from(parent.context).inflate(R.layout.hotel_main, parent, false)
                MyViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(seoulList!![position])
    }

    override fun getItemCount(): Int = seoulList!!.size

    override fun getItemViewType(position: Int): Int {  // 멀티뷰 type 가지고옴
        return seoulList!![position].type
    }

}