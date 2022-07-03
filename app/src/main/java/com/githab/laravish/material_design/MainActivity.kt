package com.githab.laravish.material_design

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.githab.laravish.material_design.databinding.ActivityMainBinding
import com.githab.laravish.material_design.ui.main.PictureOfTheDayFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.MyThemeBrown)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, PictureOfTheDayFragment.newInstance())
                .commitNow()
        }
    }
}