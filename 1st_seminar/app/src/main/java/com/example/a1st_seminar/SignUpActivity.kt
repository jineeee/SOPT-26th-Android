package com.example.a1st_seminar

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class SignUpActivity : AppCompatActivity() {

    lateinit var signUpButton : TextView
    lateinit var email : EditText
    lateinit var pw : EditText
    lateinit var pwCheck : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        signUpButton = findViewById(R.id.act_sign_up_tv_sign_up)
        email = findViewById(R.id.act_sign_up_et_email)
        pw = findViewById(R.id.act_sign_up_et_pw)
        pwCheck = findViewById(R.id.act_sign_up_et_pw_check)


        signUpButton.setOnClickListener {
            if(pwCheck(pw.text.toString(),pwCheck.text.toString())){
                val intent = Intent(this, SignInActivity::class.java)
                intent.putExtra("email", email.text.toString())
                intent.putExtra("pw", pw.text.toString())
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }

    fun pwCheck(pw: String, pwCheck: String) : Boolean{
        return pw == pwCheck
    }

}
