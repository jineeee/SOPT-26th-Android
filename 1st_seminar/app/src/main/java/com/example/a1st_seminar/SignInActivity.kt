package com.example.a1st_seminar

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class SignInActivity : AppCompatActivity() {

    lateinit var signInButton : TextView
    lateinit var email : EditText
    lateinit var pw : EditText
    lateinit var signUpButton : LinearLayout
    private val REQUEST_CODE_SIGNUP_ACTIVITY = 7777

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        signInButton = findViewById(R.id.act_sign_in_tv_sign_in)
        email = findViewById(R.id.act_sign_in_et_email)
        pw = findViewById(R.id.act_sign_in_et_pw)
        signUpButton = findViewById(R.id.act_sign_in_ll_sign_up)

        signInButton.setOnClickListener {
            if(email.text.isEmpty() || pw.text.isEmpty()){
                Toast.makeText(this, "아이디와 비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }

        signUpButton.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE_SIGNUP_ACTIVITY)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQUEST_CODE_SIGNUP_ACTIVITY){
            if(resultCode == Activity.RESULT_OK){
                val signUpEmail = data!!.getStringExtra("email")
                email.setText(signUpEmail)
                val signUpPw = data.getStringExtra("pw")
                pw.setText(signUpPw)
            }
        }

    }
}
