package com.ahmedalamin.controlroom.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ahmedalamin.controlroom.R


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val tv = findViewById<View>(R.id.loloText) as TextView
        val i = Intent(this, WelcomeActivity::class.java)

        Handler(Looper.getMainLooper()).postDelayed({ // Your Code
            startActivity(i)
            finish()
        }, 1500)
    }
}