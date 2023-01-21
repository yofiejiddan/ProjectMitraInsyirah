package com.example.projectmitrainsyirah

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.projectmitrainsyirah.Model.ApiInterface
import com.example.projectmitrainsyirah.Model.RegisterBody
import com.example.projectmitrainsyirah.Model.RetrofitInstance
import okhttp3.ResponseBody

class RegisterActivity : AppCompatActivity() {
    lateinit var button: Button
    lateinit var editText1: EditText
    lateinit var editText2: EditText
    lateinit var editText3: EditText
    lateinit var editText4: EditText
    lateinit var editText5: EditText
    lateinit var string1: String
    lateinit var string2: String
    lateinit var string3: String
    lateinit var string4: String
    lateinit var string5: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        title = "Mitra Insyirah"
        button = findViewById(R.id.button_daft)
        editText1 = findViewById(R.id.nama)
        editText2 = findViewById(R.id.alamat)
        editText3 = findViewById(R.id.email)
        editText4 = findViewById(R.id.nama_usaha)
        editText5 = findViewById(R.id.nama_password)

        button.setOnClickListener(){
            string1 = editText1.text.toString()
            string2 = editText2.text.toString()
            string3 = editText3.text.toString()
            string4 = editText4.text.toString()
            string5 = editText5.text.toString()
            singup(string1, string2, string3, string4, string5)
            Log.i("data : ", string1 + string2 + string3 + string4 + string5)
        }
    }

    fun keLogin(view: View?){
        val i = Intent(applicationContext, LoginAplikasi::class.java)
        i.putExtra("Value1", "Sedang berada di halaman Register")
        startActivity(i)
    }

    private fun singup(nama_pengguna: String, alamat_pengguna: String, email: String, nama_usaha: String, password: String){
        val retIn = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)
        val registerInfo = RegisterBody(nama_pengguna, alamat_pengguna, email, nama_usaha, password)

        retIn.registerUser(registerInfo).enqueue(object :
            retrofit2.Callback<ResponseBody> {
            override fun onFailure(call: retrofit2.Call<ResponseBody>, t: Throwable) {
                Toast.makeText(
                    this@RegisterActivity,
                    t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onResponse(
                call: retrofit2.Call<ResponseBody>,
                response: retrofit2.Response<ResponseBody>
            ) {
                if(response.code() == 201){
                    Toast.makeText(this@RegisterActivity,  "Registrasi "+editText1.text.toString()+" Berhasil!", Toast.LENGTH_SHORT).show()
                    val i = Intent(applicationContext, Beranda::class.java)
                    i.putExtra("Value1", "Terimakasih, kamu berhasil terdaftar")
                    startActivity(i)
                }
            }
            })
    }
}


