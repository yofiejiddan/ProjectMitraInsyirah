package com.example.projectmitrainsyirah

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Profil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)
    }
    fun keBeranda(view: View?){
        val i = Intent(applicationContext, Beranda::class.java)
        i.putExtra("Value1", "Sedang berada di halaman Register")
        startActivity(i)
    }
    fun keFormTambah(view: View?){
        val i = Intent(applicationContext, FormTambahBarang::class.java)
        i.putExtra("Value1", "Sedang berada di halaman Register")
        startActivity(i)
    }
    fun keProfile(view: View?){
        val i = Intent(applicationContext, Profil::class.java)
        i.putExtra("Value1", "Sedang berada di halaman Register")
        startActivity(i)
    }
}