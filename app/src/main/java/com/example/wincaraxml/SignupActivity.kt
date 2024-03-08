package com.example.wincaraxml

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlin.math.sign

private lateinit var signupbtn: Button
        private lateinit var username: EditText
        private lateinit var passwrd: EditText
        private lateinit var usergender: EditText
        private lateinit var department: EditText
        private lateinit var db: DBHelper

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        username = findViewById(R.id.username_input)
        passwrd = findViewById(R.id.password_input)
        department = findViewById(R.id.department_id)
        signupbtn = findViewById(R.id.sign_up)
        db = DBHelper(this)


        signupbtn.setOnClickListener{
            val usernametext = username.text.toString()
            val passwordtext = passwrd.text.toString()
            val departmenttxt = department.text.toString()

            if(TextUtils.isEmpty(usernametext) || TextUtils.isEmpty(passwordtext)|| TextUtils.isEmpty(departmenttxt)){
                Toast.makeText(this,"Please add your username, password and department", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this,"Sign up successful", Toast.LENGTH_SHORT).show()
                val intent = Intent(applicationContext,LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }

}