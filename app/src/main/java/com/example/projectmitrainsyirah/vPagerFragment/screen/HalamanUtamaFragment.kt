package com.example.projectmitrainsyirah.vPagerFragment.screen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.projectmitrainsyirah.LoginAplikasi
import com.example.projectmitrainsyirah.Model.ApiInterface
import com.example.projectmitrainsyirah.Model.RegisterBody
import com.example.projectmitrainsyirah.Model.RetrofitInstance
import com.example.projectmitrainsyirah.R
import com.example.projectmitrainsyirah.databinding.FragmentHalamanUtamaBinding
import okhttp3.Response
import okhttp3.ResponseBody


class HalamanUtamaFragment : Fragment() {
    private lateinit var binding: FragmentHalamanUtamaBinding
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
        setContentView(R.layout.fragment_halaman_utama)
        title = "KotlinApp"
        button = findViewById(R.id.btn_daft)
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
            singup(string1, string2, string3)
            Log.i("data : ", string1 + string2 + string3 + string4 + string5)
        }
    }

    fun keLogin(view: View?){
        val i = Intent(applicationContext, LoginAplikasi::class.java)
        i.putExtra("Value1", "Sedang berada di halaman Register")
        startActivity(i)
    }

    private fun singup(nama_lengkap: String, email: String, password: String){
        val retIn = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)
        val registerInfo = RegisterBody(nama_lengkap, email, password)

        retIn.registerUser(registerInfo).enqueue(object :
            retrofit2.Callback<ResponseBody> {
            override fun onFailure(call: retrofit2.Call<ResponseBody>, t: Throwable) {
                Toast.makeText(
                    context,
                    t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onResponse(
                call: retrofit2.Call<ResponseBody>,
                response: Response<ResponseBody>
            ) {
                if(response.code() == 201){
                    Toast.makeText(context,  "Registrasi "+et_nama.text.toString()+" Berhasil!", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.action_registerFragment_to_loginAcitvity)
                    })
        }
}


    private fun onBoardingFinished(){
        val sharedPref = requireActivity()
            .getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Selesai", true)
        editor.apply()

    }    }
