package com.githab.laravish.material_design

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.githab.laravish.material_design.databinding.ActivityMainBinding
import com.githab.laravish.material_design.ui.main.navigation.NavigateFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(initThemeStyle(getCurrentTheme()))
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, NavigateFragment.newInstance())
                .commitNow()
        }
    }

    fun setCurrentTheme(currentTheme: Int) {
        getSharedPreferences(KEY_THEME, MODE_PRIVATE)
            .edit()
            .putInt(CURRENT_THEME, currentTheme)
            .apply()
    }

    fun getCurrentTheme(): Int {
        return getSharedPreferences(KEY_THEME, MODE_PRIVATE).getInt(CURRENT_THEME, -1)
    }

    private fun initThemeStyle(currentTheme: Int): Int {
        return when (currentTheme) {
            THEME_DEFAULT -> R.style.Theme_Material_design
            THEME_GREEN -> R.style.MyThemeGreen
            THEME_BROWN -> R.style.MyThemeBrown
            else -> {
                0
            }
        }
    }
}