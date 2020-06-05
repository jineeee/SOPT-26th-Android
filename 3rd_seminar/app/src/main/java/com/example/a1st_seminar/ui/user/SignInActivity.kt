package com.example.a1st_seminar.ui.user

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.a1st_seminar.R
import com.example.a1st_seminar.data.NetworkServiceImpl
import com.example.a1st_seminar.data.model.SignInResponse
import com.example.a1st_seminar.ui.insta.MainActivity
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInActivity : AppCompatActivity() {

    lateinit var signInButton : TextView
    lateinit var id : EditText
    lateinit var pw : EditText
    lateinit var signUpButton : LinearLayout
    private val REQUEST_CODE_SIGNUP_ACTIVITY = 7777
    lateinit var resId : String
    lateinit var resPw : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        signInButton = findViewById(R.id.act_sign_in_tv_sign_in)
        id = findViewById(R.id.act_sign_in_et_id)
        pw = findViewById(R.id.act_sign_in_et_pw)
        signUpButton = findViewById(R.id.act_sign_in_ll_sign_up)

        signInButton.setOnClickListener {
            if(this.id.text.isEmpty() || pw.text.isEmpty()){
                Toast.makeText(this, "아이디와 비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show()
            }
            else{
                postSignIn()
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
                resId = data!!.getStringExtra("id")
                this.id.setText(resId)
                resPw = data.getStringExtra("pw")
                pw.setText(resPw)
            }
        }
    }

    fun postSignIn(){
        resId = id.text.toString()
        resPw = pw.text.toString()
        val jsonObject = JSONObject()
        jsonObject.put("id", resId)
        jsonObject.put("password", resPw)

        val body = JsonParser().parse(jsonObject.toString()) as JsonObject
        val call: Call<SignInResponse> = NetworkServiceImpl.SERVICE.postSignIn(body)
        call.enqueue(
            object : Callback<SignInResponse> {
                override fun onFailure(call: Call<SignInResponse>, t: Throwable) {
                    Log.e("실패 ", t.message)
                    Toast.makeText(this@SignInActivity, "중복된 이메일입니다", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(
                    call: Call<SignInResponse>,
                    response: Response<SignInResponse>
                ) {
                    Log.e("응답성공", response.body().toString())
                    if(response.body()!!.message == "로그인 성공"){
                        Toast.makeText(this@SignInActivity, "로그인에 성공했습니다", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@SignInActivity, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this@SignInActivity, "아이디 또는 비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
                    }

                }

            }
        )
    }
}
