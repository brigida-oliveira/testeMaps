package com.example.testedogooglemaps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testedogooglemaps.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMapsYourLocation.setOnClickListener { startActivity(Intent(this, MapsActivity::class.java)) }
        binding.btnMapsOtherLocations.setOnClickListener { startActivity(Intent(this, NewMapsActivity::class.java)) }
    }

}