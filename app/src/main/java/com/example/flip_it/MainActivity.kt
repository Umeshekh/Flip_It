package com.example.flip_it

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val coin=findViewById<ImageView>(R.id.iv_coin);
        onCoinTap();
    }


    // To check head or tails
    private fun onCoinTap() {
        val coin=findViewById<ImageView>(R.id.iv_coin);
         coin.setOnClickListener {
             val randomNumber: Int = (1..2).random()

             if (randomNumber == 1) {
                 flipTheCoin(R.drawable.head, "Heads")
             } else {
                 flipTheCoin(R.drawable.tail, "Tails")
             }
         }
    }

    private fun flipTheCoin (imageId: Int,coinSide: String) {
        val coin=findViewById<ImageView>(R.id.iv_coin);
        coin.animate().apply{
            duration=1000
            rotationYBy(1800f)
            coin.isClickable = false
        }.withEndAction {
            coin.setImageResource(imageId)
            Toast.makeText(this,coinSide,Toast.LENGTH_SHORT).show();
            coin.isClickable=true;
        }.start()

    }
}