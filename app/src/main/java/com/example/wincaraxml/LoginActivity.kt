package com.example.wincaraxml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import android.content.Intent
import android.text.TextUtils
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    private lateinit var loginbtn:Button
    private lateinit var loginuser: EditText
    private lateinit var loginpasswrd: EditText
    private lateinit var dbh:DBHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_login)

        loginbtn = findViewById(R.id.login_btn)
        loginuser = findViewById(R.id.login_username_input)
        loginpasswrd = findViewById(R.id.login_password_input)
        dbh = DBHelper(this)

        loginbtn.setOnClickListener{
            val userlogin = loginuser.text.toString()
            val passwrdlogin = loginpasswrd.text.toString()

            if(TextUtils.isEmpty(userlogin)|| TextUtils.isEmpty(passwrdlogin)){
                Toast.makeText(this,"Please add your username and password", Toast.LENGTH_SHORT).show()
            }
            else{
                val checkuser = dbh.checkuserpass(userlogin, passwrdlogin)
                if(checkuser == true) {
                    Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this,"Wrong username and password", Toast.LENGTH_SHORT).show()
                }
            }
        }

        val signupBtn = findViewById<Button>(R.id.to_sign_up)
        signupBtn.setOnClickListener(){
            val intent = Intent(this,SignupActivity:: class.java)
            startActivity(intent)
        }
    }
}