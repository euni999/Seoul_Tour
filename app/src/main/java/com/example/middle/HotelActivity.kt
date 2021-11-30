package com.example.middle

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.middle.adapter.SeoulAdapter
import com.example.middle.data.Seoul
import com.example.middle.data.type3

class HotelActivity : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    private var adapter: SeoulAdapter? = null
    private var hotellist: MutableList<Seoul>? = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.seoul_tour)

        recyclerView = findViewById(R.id.recycler_view)
        adapter = SeoulAdapter(this, hotellist)
        recyclerView?.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView?.adapter = adapter

        adapter!!.setOnItemClickListener(object : SeoulAdapter.OnItemClickListener {
            override fun onItemClick(v: View, seoul: Seoul, pos: Int) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(seoul.content))
                startActivity(intent)
            }
        })

        seoulHotel()
    }

    private fun seoulHotel() {
        val icon = intArrayOf(
            R.drawable.hotel_1,
            R.drawable.hotel_2,
            R.drawable.hotel_3,
            R.drawable.hotel_4,
            R.drawable.hotel_5,
            R.drawable.hotel_6,
            R.drawable.hotel_7,
            R.drawable.hotel_8,
            R.drawable.hotel_9,
            R.drawable.hotel_10)

        var seoul_hotel = Seoul("메이필드 호텔 서울", "서울 강서구 방화대로 94", "https://www.mayfield.co.kr/2017/kor/html/index/", icon[0], type3)
        hotellist!!.add(seoul_hotel)
        seoul_hotel =Seoul("반얀트리 클럽 앤 스파 서울", "서울 중구 장충단", "https://www.banyantreeclub.com/kr/", icon[1],type3)
        hotellist!!.add(seoul_hotel)
        seoul_hotel =Seoul("프레이저 플레이스 센트럴 서울", "서울 중구 통일로 78", "http://www.fraserplace.co.kr/", icon[2],type3)
        hotellist!!.add(seoul_hotel)
        seoul_hotel =Seoul("오라카이 청계산 호텔", "서울 서초구 청계산로9길 1-7", "https://cgs.orakaihotels.com/kr/default.asp", icon[3],type3)
        hotellist!!.add(seoul_hotel)
        seoul_hotel =Seoul("노보텔 앰배서더 서울 용산", "서울 용산구 청파로20길 95", "https://m.ambatel.com/novotel/dongdaemun/ko/index.do", icon[4],type3)
        hotellist!!.add(seoul_hotel)
        seoul_hotel =Seoul("에스알 호텔 사당점", "서울 동작구 동작대로1길 15", "http://hotel-sr.com/", icon[5], type3)
        hotellist!!.add(seoul_hotel)
        seoul_hotel =Seoul("여의도 엠 호텔", "서울 영등포구 국회대로70", "http://www.hotelm.co.kr/", icon[6], type3)
        hotellist!!.add(seoul_hotel)
        seoul_hotel =Seoul("티마크 그랜드 호텔 명동", "서울 중구 퇴계로", "https://tmarkhotels.com/tmarkgrandhotel-myeongdong/ko/", icon[7], type3)
        hotellist!!.add(seoul_hotel)
        seoul_hotel =Seoul("신라스테이 광화문", "서울 종로구 삼봉로 71", "https://m.shillastay.com/gwanghwamun/index.do?lang=ko", icon[8], type3)
        hotellist!!.add(seoul_hotel)
        seoul_hotel =Seoul("글래드 여의도", "서울특별시 영등포구 여의동 의사당대로 14", "https://gladyeouido-hotels.com/", icon[9], type3)
        hotellist!!.add(seoul_hotel)
        adapter!!.notifyDataSetChanged()
    }
}