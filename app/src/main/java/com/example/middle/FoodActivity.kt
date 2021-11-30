package com.example.middle

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.middle.adapter.SeoulAdapter
import com.example.middle.data.Seoul
import com.example.middle.data.type2

class FoodActivity : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    private var adapter: SeoulAdapter? = null
    private var foodlist: MutableList<Seoul>? = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.seoul_tour)

        recyclerView = findViewById(R.id.recycler_view)
        adapter = SeoulAdapter(this, foodlist)
        recyclerView?.layoutManager = GridLayoutManager(this, 2)
        recyclerView?.adapter = adapter

        adapter!!.setOnItemClickListener(object : SeoulAdapter.OnItemClickListener {
            override fun onItemClick(v: View, seoul: Seoul, pos: Int) {
                val intent = Intent(this@FoodActivity, ContentActivity::class.java)
                intent.putExtra("data", seoul)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }
        })

        seoulFood()
    }

    private fun seoulFood() {
        val icon = intArrayOf(
            R.drawable.food1,
            R.drawable.food2,
            R.drawable.food3,
            R.drawable.food4,
            R.drawable.food5,
            R.drawable.food6)

        var seoul_food = Seoul("미라이", "서울특별시 강남구 논현로 153길 24 끌레르빌 1F",
            "이자카야 / 오뎅 / 꼬치\n" +
                    "영업시간\t18:00 - 01:00\n" +
                    "휴일\t일\n\n" +
                    "메뉴\n"+
                    "사시미8종 (2인) - 41,000원\n" +
                    "마구로치즈아에 - 19,000원\n" +
                    "양갈비 스미비 야끼 - 23,000원\n" +
                    "노도구로 시오 야끼 - 35,000원\n" +
                    "규 스테이크 - 41,000원", icon[0], type2)
        foodlist!!.add(seoul_food)
        seoul_food = Seoul("시라카와", "서울특별시 강남구 선릉로 161길 7 1F",
            "이자카야 / 오뎅 / 꼬치\n" +
                    "영업시간\t18:00 - 24:00\n" +
                    "휴일\t일, 둘째/넷째 월\n\n" +
                    "메뉴\n" +
                    "덴푸라 5종모듬 - 10,900원\n" +
                    "특제소스에 조린 소고기 - 15,000원\n" +
                    "숙성도미회와 흑임자 소스 -14,000원\n" +
                    "문어숙회와 다시마 - 12,000원\n" +
                    "도미 머리 조림 - 17,000원",icon[1], type2)
        foodlist!!.add(seoul_food)
        seoul_food = Seoul("바위파스타바", "서울특별시 성동구 뚝섬로 15길 27 1F",
            "이탈리안\n" +
                    "영업시간\t17:00 - 24:00\n" +
                    "휴일\t일, 월\n\n" +
                    "메뉴\n" +
                    "파스타 테이스팅 코스 - 75,000원",icon[2], type2)
        foodlist!!.add(seoul_food)
        seoul_food = Seoul("타쿠미곤", "서울특별시 서초구 사평대로 18길 10 부림빌딩 2F",
            "정통 일식 / 일반 일식\n"+
                    "영업시간\t12:00 - 22:00\n" +
                    "쉬는시간\t15:00 - 18:00\n" +
                    "마지막주문\t13:30, 20:30\n" +
                    "런치 - 150,000원\n" +
                    "디너 - 260,000원",icon[3], type2)
        foodlist!!.add(seoul_food)
        seoul_food = Seoul("알라프리마", "서울특별시 강남구 학동로17길 13 1F",
            "이탈리안\n" +
                    "영업시간\t12:00 - 22:00\n" +
                    "쉬는시간\t15:00 - 18:00\n" +
                    "마지막주문\t13:30, 20:30\n" +
                    "영업시간\t12:00 - 21:00\n" +
                    "쉬는시간\t14:30 - 18:00\n" +
                    "휴일\t일\n\n" +
                    "메뉴\t\n" +
                    "런치 - 88,000원\n" +
                    "디너 - 178,000원", icon[4], type2)
        foodlist!!.add(seoul_food)
        seoul_food = Seoul("쿠나", "서울특별시 성동구 연무장 5길 9-16 105호",
            "\t이탈리안\n" +
                    "영업시간\t화-토: 12:00 - 22:00\n" +
                    "일: 12:00 - 20:00\n" +
                    "쉬는시간\t15:00 - 17:00\n" +
                    "휴일\t월\n\n" +
                    "메뉴\t\n" +
                    "바질부라타 - 16,000원\n" +
                    "가지튀김 - 12,000원\n" +
                    "전복리소토 - 23,000원\n" +
                    "포르치니버섯베이컨크림뇨끼 - 19,000원\n" +
                    "오리가슴살스테이크 - 30,000원", icon[5], type2)
        foodlist!!.add(seoul_food)
        adapter!!.notifyDataSetChanged()
    }
}
