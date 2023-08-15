package com.dogagunes.catchthespongebob

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.dogagunes.catchthespongebob.databinding.ActivityMainBinding
import com.dogagunes.catchthespongebob.databinding.ActivityStartingScreenBinding

class StartingScreen : AppCompatActivity() {
    private lateinit var binding: ActivityStartingScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartingScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



    }

    fun spongebob(view : View){

        val intent = Intent(this@StartingScreen, MainActivity::class.java)
        intent.putExtra("name", binding.editText.text.toString())
        startActivity(intent)
        finish()
    }

    fun patrick(view : View){

        val intent = Intent(this@StartingScreen, MainActivity2::class.java)
        intent.putExtra("name", binding.editText.text.toString())
        startActivity(intent)
        finish()
    }
}