package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rollDice()

        val rollButton: Button= findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
            val toast= Toast.makeText(this, "Dice Rolled!!!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun rollDice() {
            val dice=Dice(6)
            val rolledValue=dice.roll()
            val resultText: TextView = findViewById(R.id.textView)
            val resultImage: ImageView = findViewById(R.id.imageView)
            resultText.text = rolledValue.toString()

            val drawableResource=when(rolledValue){
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
            resultImage.setImageResource(drawableResource)
            resultImage.contentDescription = rolledValue.toString()
    }
}

class Dice(private val sides: Int)
{
    fun roll(): Int = (1..sides).random()
}