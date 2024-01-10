package com.harunaltun.RGBSnackbar

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*

val path="com.harunaltun.rgb-snackbar"
var keyname="name"
var keypass="şifre"
var tick =false

class MainActivity2 : AppCompatActivity(), TextWatcher {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val preferences=getSharedPreferences(path,Context.MODE_PRIVATE)

        setContentView(R.layout.activity_main2)

        Toast.makeText(applicationContext,"Kaydedilmiş\r\n İsim: ${preferences.getString(keyname, "Değer Yok")}" +
                "\r\nŞifre:${preferences.getString(keypass,"Değer Yok")}" +
                "\r\nUnutma:${preferences.getBoolean(tick.toString(),false)}",Toast.LENGTH_LONG).show()

        switch1.setChecked(preferences.getBoolean(tick.toString(),false))
        name.setText(preferences.getString(keyname,""))
        pass.setText(preferences.getString(keypass,""))
        if(name.text.toString()=="Harun Altun"&&pass.text.toString()=="02200201057"){
            progressBar2.visibility=View.VISIBLE
            val gecis=Intent(this,FragmentActivity::class.java)
            Handler().postDelayed({
                startActivity(gecis)
                finish()
            },3000)
        }
        name.addTextChangedListener(this)
        pass.addTextChangedListener(this)

    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        if(name.text.toString()=="Harun Altun"&& pass.text.toString()=="02200201057"){
        progressBar2.visibility=View.VISIBLE
        if(switch1.isChecked==true){
            val preferences=getSharedPreferences(path,Context.MODE_PRIVATE)
            val editor=preferences.edit()
            editor.putString(keyname,name.text.toString())
            editor.putString(keypass,pass.text.toString())
            switch1.isChecked=true
            editor.putBoolean(tick.toString(),switch1.isChecked)
            editor.apply()
        } else{
            keyname="Değer Yok"
            keypass="Değer Yok"
        }
        val gecis=Intent(this,FragmentActivity::class.java)
        Handler().postDelayed({
            startActivity(gecis)
            finish()
        },3000)
    }
    }

    override fun afterTextChanged(p0: Editable?) {

    }


}


