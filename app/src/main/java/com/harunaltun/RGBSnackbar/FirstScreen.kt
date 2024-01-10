package com.harunaltun.RGBSnackbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import kotlinx.android.synthetic.main.activity_main.*

class FirstScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        seekBar5.setOnSeekBarChangeListener(object:OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                if(seekBar5.progress==100){
                    val intent=Intent(this@FirstScreen,MainActivity2::class.java)
                    progressBar.visibility= View.VISIBLE
                    object :CountDownTimer(700,10){
                        override fun onTick(p0: Long) {
                            if (seekBar5.progress>4){
                                seekBar5.progress=seekBar5.progress-4
                            }else{
                                seekBar5.progress=4
                            }
                        }

                        override fun onFinish() {
                            seekBar5.progress=4
                        }

                    }.start()
                    Handler().postDelayed({
                        startActivity(intent)
                        finish()
                    },3000)}
                else{
                    seekBar5.progress=4
                }
            }

        })
    }
}