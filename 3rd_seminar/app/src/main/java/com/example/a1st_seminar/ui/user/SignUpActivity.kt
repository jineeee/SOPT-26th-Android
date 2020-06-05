package com.example.a1st_seminar.ui.user

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.VISIBLE
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.a1st_seminar.R
import com.example.a1st_seminar.data.NetworkServiceImpl
import com.example.a1st_seminar.data.model.SignUpResponse
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.activity_sign_up.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {

    lateinit var signUpButton: TextView
    lateinit var id: EditText
    lateinit var pw: EditText
    lateinit var pwCheck: EditText
    lateinit var name: EditText
    lateinit var email: EditText
    lateinit var phone: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        signUpButton = findViewById(R.id.act_sign_up_tv_sign_up)
        id = findViewById(R.id.act_sign_up_et_id)
        pw = findViewById(R.id.act_sign_up_et_pw)
        pwCheck = findViewById(R.id.act_sign_up_et_pw_check)
        name = findViewById(R.id.act_sign_up_et_name)
        email = findViewById(R.id.act_sign_up_et_email)
        phone = findViewById(R.id.act_sign_up_et_phone)

        signUpButton.setOnClickListener {
            if (pwCheck(pw.text.toString(), pwCheck.text.toString())) {
                postSignUp()
            } else {
                Toast.makeText(this@SignUpActivity, "비밀번호가 일치하지 않습니다", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun pwCheck(pw: String, pwCheck: String): Boolean {
        return pw == pwCheck
    }

    fun postSignUp() {
        val inId = id.text
        val inPw = pw.text
        val inName = name.text
        val inEmail = email.text
        val inPhone = phone.text
        val jsonObject = JSONObject()
        jsonObject.put("id", inId)
        jsonObject.put("password", inPw)
        jsonObject.put("email", inEmail)
        jsonObject.put("name", inName)
        jsonObject.put("phone", inPhone)

        val body = JsonParser().parse(jsonObject.toString()) as JsonObject
        val call: Call<SignUpResponse> = NetworkServiceImpl.SERVICE.postSignUp(body)
        call.enqueue(
            object : Callback<SignUpResponse> {
                override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                    Log.e("실패 ", t.message)
                    Toast.makeText(this@SignUpActivity, "중복된 이메일입니다", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(
                    call: Call<SignUpResponse>,
                    response: Response<SignUpResponse>
                ) {
                    if (response.body() == null)
                        Toast.makeText(this@SignUpActivity, "정보를 입력해주세요", Toast.LENGTH_SHORT).show()
                    else
                        when (response.body()!!.status) {
                            204 -> {
                                val intent = Intent(this@SignUpActivity, SignInActivity::class.java)
                                intent.putExtra("id", id.text.toString())
                                intent.putExtra("pw", pw.text.toString())
                                setResult(Activity.RESULT_OK, intent)
                                finish()
                                Toast.makeText(this@SignUpActivity, "회원가입에 성공했습니다", Toast.LENGTH_SHORT)
                                    .show()
                                Log.e("석세스", response.body().toString())
                            }
                            200 -> {
                                Log.e("낫석세스", response.body().toString())
                                Toast.makeText(this@SignUpActivity, "중복된 ID입니다", Toast.LENGTH_SHORT)
                                    .show()
                                act_sign_up_warn.visibility = VISIBLE
                            }
                            else -> Log.e("낫석세스2222", response.body().toString())
                        }
                }

            }
        )
    }

}
