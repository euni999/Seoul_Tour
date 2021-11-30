package com.example.middle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    private lateinit var launcher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                result: ActivityResult -> if (result.resultCode == RESULT_OK)  {}
        }

        val tour_btn: Button = findViewById(R.id.tour_btn)
        tour_btn.setOnClickListener {
            val intent = Intent(this, TourActivity::class.java)
            launcher.launch(intent)
        }

        val food_btn: Button = findViewById(R.id.food_btn)
        food_btn.setOnClickListener {
            val intent = Intent(this, FoodActivity::class.java)
            launcher.launch(intent)
        }

        val hotel_btn: Button = findViewById(R.id.hotel_btn)
        hotel_btn.setOnClickListener {
            val intent = Intent(this, HotelActivity::class.java)
            launcher.launch(intent)
        }
    }



}