package com.example.wincaraxml

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import kotlin.math.sign

        private lateinit var signupbtn: Button
        private lateinit var username: EditText
        private lateinit var password: EditText
        private lateinit var gendergroup: RadioGroup
        private lateinit var btnMale: RadioButton
        private lateinit var btnFemale: RadioButton
        private lateinit var department: EditText
        private lateinit var db: DBHelper

class SignupActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        username = findViewById(R.id.username_input)
        password = findViewById(R.id.password_input)
        gendergroup = findViewById(R.id.radiogroupgender)
        btnMale = findViewById(R.id.radiobtnmale)
        btnFemale = findViewById(R.id.radiobtnfemale)
        department = findViewById(R.id.department_id)
        signupbtn = findViewById(R.id.sign_up)
        db = DBHelper(this)


        signupbtn.setOnClickListener{
            val usernametext = username.text.toString()
            val passwordtext = password.text.toString()
            val selectedGender = when(gendergroup.checkedRadioButtonId){
                R.id.radiobtnmale -> "Male"
                R.id.radiobtnfemale -> "Female"
                else -> ""
            }
            val departmenttext = department.text.toString()
            val savedata = db.addUSer(usernametext,passwordtext,selectedGender,departmenttext)


            if(TextUtils.isEmpty(usernametext) || TextUtils.isEmpty(passwordtext)|| TextUtils.isEmpty(departmenttext)|| selectedGender.isEmpty()){
                Toast.makeText(this,"Please add your username, password and department and select your gender", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this,"Sign up successful", Toast.LENGTH_SHORT).show()
                val intent = Intent(applicationContext,LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }

}