package com.example.projectmitrainsyirah

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.projectmitrainsyirah.Model.ApiInterface
import com.example.projectmitrainsyirah.Model.LoginBody
import com.example.projectmitrainsyirah.Model.RetrofitInstance
import com.example.projectmitrainsyirah.Session.SessionManager
import com.example.projectmitrainsyirah.databinding.FragmentHalamanUtamaBinding
import com.example.projectmitrainsyirah.vPagerFragment.screen.HalamanUtamaFragment
import okhttp3.ResponseBody

class LoginAplikasi : AppCompatActivity() {
    lateinit var button: Button
    lateinit var editText1: EditText
    lateinit var editText2: EditText
    lateinit var string1: String
    lateinit var string2: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_aplikasi)
        title = "KotlinApp"
        button = findViewById(R.id.button_masuk)
        editText1 = findViewById(R.id.email)
        editText2 = findViewById(R.id.nama_password)

        button.setOnClickListener() {
            string1 = editText1.text.toString()
            string2 = editText2.text.toString()
            signin(string1, string2)
            Log.i("data : ", string1 + string2)
        }

    }

    private fun signin(email: String, password: String) {
        val retIn = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)
        val signInInfo = LoginBody(email, password)
        retIn.login(signInInfo).enqueue(object : retrofit2.Callback<ResponseBody> {
            override fun onFailure(call: retrofit2.Call<ResponseBody>, t: Throwable) {
                Toast.makeText(
//                    context, untuk fragment
//                    ini untuk activity
                    this@LoginAplikasi,
                    t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onResponse(
                call: retrofit2.Call<ResponseBody>,
                response: retrofit2.Response<ResponseBody>
            ) {
                if (response.code() == 200) {
                    Toast.makeText(
                        this@LoginAplikasi,
                        "Login success!",
                        Toast.LENGTH_SHORT
                    ).show()
                    val sessionManager = SessionManager(this@LoginAplikasi)
                    sessionManager.setLoggin(true)
                    sessionManager.setEmail(email)
//                    findNavController().navigate(R.id.action_loginAcitvity_to_berandaFragment2)
                    val i = Intent(applicationContext, Beranda::class.java)
                    i.putExtra("Value1", "Selamat Datang")
                    startActivity(i)
                } else {
                    Toast.makeText(
                        this@LoginAplikasi,
                        "Login failed!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })
    }
}
