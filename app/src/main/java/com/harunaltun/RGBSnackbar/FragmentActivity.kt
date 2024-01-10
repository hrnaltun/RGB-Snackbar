package com.harunaltun.RGBSnackbar

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.PopupMenu
import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main3.button


class FragmentActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)



        val view=layoutInflater.inflate(R.layout.logout,null)
        val logout=AlertDialog.Builder(this)
        logout.setView(view)
        val namee2=view.findViewById<EditText>(R.id.name2)
        val passs2=view.findViewById<EditText>(R.id.pass2)
        val progressBar3=view.findViewById<ProgressBar>(R.id.progressBar3)
        val preferences=getSharedPreferences(path, Context.MODE_PRIVATE)
        val editor=preferences.edit()

        button.setOnClickListener {
            val acilirmenu=PopupMenu(this,button)
            acilirmenu.menuInflater.inflate(R.menu.popupmenu,acilirmenu.menu)
            acilirmenu.setOnMenuItemClickListener { i->
                when(i.itemId){
                    R.id.rgb->{
                            fragmentcagir(RGBFragment())
                    true}
                    R.id.snack->{
                        fragmentcagir(SnackbarFragment())

                        true}
                    R.id.çıkış->{
                        logout.create().show()

                   true}
                    else->false

                    }

            }
            acilirmenu.show()

        }

            passs2.addTextChangedListener(object :TextWatcher{
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    if(namee2.text.toString()=="Harun Altun"&& passs2.text.toString()=="02200201057"){
                        progressBar3.visibility=View.VISIBLE
                        editor.remove(keyname)
                        editor.remove(keypass)
                        editor.remove(tick.toString())
                        editor.apply()
                        val intent=Intent(this@FragmentActivity,MainActivity2::class.java)
                        Handler().postDelayed({
                            startActivity(intent)
                            finish()
                        },3000)
                    }
                }

                override fun afterTextChanged(p0: Editable?) {
                }

            })
        namee2.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(namee2.text.toString()=="Harun Altun"&& passs2.text.toString()=="02200201057"){
                    progressBar3.visibility=View.VISIBLE
                    editor.remove(keyname)
                    editor.remove(keypass)
                    editor.remove(tick.toString())
                    editor.apply()
                    val intent=Intent(this@FragmentActivity,MainActivity2::class.java)
                    Handler().postDelayed({
                        startActivity(intent)
                        finish()
                    },3000)
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })



}

    fun fragmentcagir(cagrilanfragment :Fragment){
        val gecis =supportFragmentManager.beginTransaction()
        gecis.replace(R.id.fragmentContainerView,cagrilanfragment)
        gecis.commit()
    }



}


