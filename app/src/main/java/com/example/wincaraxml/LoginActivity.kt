package com.example.wincaraxml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import android.content.Intent

class LoginActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_login)



       val signupBtn = findViewById<Button>(R.id.to_sign_up)
        signupBtn.setOnClickListener(){
            val intent = Intent(this,SignupActivity:: class.java)
            startActivity(intent)
        }
    }
}