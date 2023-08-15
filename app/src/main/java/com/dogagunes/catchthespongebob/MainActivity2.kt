package com.dogagunes.catchthespongebob

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.dogagunes.catchthespongebob.databinding.ActivityMain2Binding
import com.dogagunes.catchthespongebob.databinding.ActivityMainBinding
import java.util.ArrayList
import java.util.Random

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    private var score : Int = 0
    private var isContinue : Boolean = true
    private var isClicked : Boolean = true
    private var isAnimate : Boolean = true
    private var list = ArrayList<ImageView>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        list.add(binding.imageView13)
        list.add(binding.imageView14)
        list.add(binding.imageView15)
        list.add(binding.imageView16)
        list.add(binding.imageView17)
        list.add(binding.imageView18)
        list.add(binding.imageView19)
        list.add(binding.imageView20)
        list.add(binding.imageView21)

        hideImage()
        //Todo : Make High-Score List!!!

        if(isContinue){
            object : CountDownTimer(15500, 500){
                override fun onTick(p0: Long) {

                    binding.textView.text = "Left ${p0 / 1000}"
                    hideImage()
                }
                override fun onFinish() {
                    val alert = AlertDialog.Builder(this@MainActivity2)
                    var intentFromStart = intent
                    var name = intentFromStart.getStringExtra("name")
                    alert.setTitle("${name}'s Score = ${score}")
                    alert.setMessage("Do You Want To Continue?")
                    alert.setPositiveButton("Yes", object : DialogInterface.OnClickListener{
                        override fun onClick(p0: DialogInterface?, p1: Int) {
                            isContinue = true
                            isAnimate = true
                            score = 0
                            binding.textView2.text = "Score : 0"
                            start()
                        }
                    })
                    alert.setNegativeButton("No"){ p0, p1 ->
                        isContinue = false
                        isClicked = false
                        isAnimate = false
                        score = 0
                        Toast.makeText(this@MainActivity2, "Game Finished!", Toast.LENGTH_LONG).show()
                        val intent = Intent(this@MainActivity2, StartingScreen::class.java)
                        startActivity(intent)
                        finish()

                    }
                    alert.show()
                }

            }.start()
        }

    }

    fun click(view : View){

        if(isClicked){
            score++
            binding.textView2.text = "Score : ${score}"
        }
    }

    fun hideImage(){

        var r = Random()

        for(i in list){
            i.visibility = View.INVISIBLE
        }
        list[r.nextInt(list.size -1)].visibility = View.VISIBLE

    }
}