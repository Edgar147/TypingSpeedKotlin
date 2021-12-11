package com.example.typingspeedkotlin


import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import com.example.typingspeedkotlin.databinding.ActivityMainBinding


import android.content.res.Resources


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



        var textIntegral: String= "are you sure you want to type hello some sun house give that is another wine for football "
        var strs = textIntegral.split(" ").toMutableList()
        binding.tvText.text=strs[0]
        val x=binding.tvText.text
        val nextButton=binding.bNext
        var score=0

        //val fileContent = MySpec::class.java.getResource("/html/file.html").readText()

        binding.bNext.setOnClickListener {

            if(binding.tvText.text.toString().equals(binding.edTyping.text.toString())){
                strs.removeAt(0)
                binding.tvText.text=strs[0]
                binding.edTyping.setText("")
                binding.edTyping.setBackgroundColor(Color.WHITE)
                score++

            }
            else{
                binding.edTyping.setBackgroundColor(Color.RED)

            }
            var y =binding.edTyping.text
            Log.i("first","$x")
            Log.i("second","$y")

        }




        val timer = object: CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.tvTimer.text=(millisUntilFinished / 1000).toString()
            }


            override fun onFinish() {
                binding.tvFinal.visibility=View.GONE
                binding.edTyping.visibility=View.GONE
                binding.tvText.visibility=View.GONE
                binding.tvTimer.visibility=View.GONE
                binding.tvScore.visibility=View.VISIBLE
                binding.bNext.visibility=View.GONE
                binding.tvScore.text="Your score: "+score



            }
        }
        timer.start()
    }




}