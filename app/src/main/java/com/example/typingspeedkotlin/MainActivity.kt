package com.example.typingspeedkotlin

import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.typingspeedkotlin.databinding.ActivityMainBinding
import java.io.BufferedInputStream

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var dictos = R.raw.dictos
        var ag = BufferedInputStream(getResources().openRawResource(dictos))
        var inputAsString =
            ag.bufferedReader().use { it.readLines() } // from input file to List of String

        var textIntegral: String = ""

        for (i in 1..200) {
            var myRandom = (0..998).random()
            textIntegral = textIntegral + inputAsString.elementAt(myRandom) + " "
        }

        var strs = textIntegral.split(" ").toMutableList()
        binding.tvText.text = strs[0]
        val x = binding.tvText.text
        val nextButton = binding.bNext
        var score = 0


        binding.bNext.setOnClickListener {
            if (binding.tvText.text.toString().equals(binding.edTyping.text.toString())) {
                strs.removeAt(0)
                binding.tvText.text = strs[0]
                binding.edTyping.setText("")
                binding.edTyping.setBackgroundColor(Color.WHITE)
                score++
            } else {
                binding.edTyping.setBackgroundColor(Color.RED)
            }
            var y = binding.edTyping.text

        }

        val timer =
            object : CountDownTimer(60000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    binding.tvTimer.text = (millisUntilFinished / 1000).toString()
                }

                override fun onFinish() {
                    binding.tvFinal.visibility = View.GONE
                    binding.edTyping.visibility = View.GONE
                    binding.tvText.visibility = View.GONE
                    binding.tvTimer.visibility = View.GONE
                    binding.tvScore.visibility = View.VISIBLE
                    binding.bNext.visibility = View.GONE
                    binding.tvScore.text = "Your score: " + score
                }
            }
        timer.start()
    }
}
