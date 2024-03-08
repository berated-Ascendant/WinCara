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
        private lateinit var password: EditText
        private lateinit var usergender: EditText
        private lateinit var department: EditText
        private lateinit var db: DBHelper

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        username = findViewById(R.id.username_input)
        password = findViewById(R.id.password_input)
        usergender = findViewById(R.id.gender_input)
        department = findViewById(R.id.department_id)
        signupbtn = findViewById(R.id.sign_up)
        db = DBHelper(this)


        signupbtn.setOnClickListener{
            val usernametext = username.text.toString()
            val passwordtext = password.text.toString()
            val gendertext = usergender.text.toString()
            val departmenttext = department.text.toString()
            val savedata = db.addUSer(usernametext,passwordtext,gendertext,departmenttext)


            if(TextUtils.isEmpty(usernametext) || TextUtils.isEmpty(passwordtext)|| TextUtils.isEmpty(departmenttext)){
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