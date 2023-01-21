package com.example.projectmitrainsyirah

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Beranda : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda)
    }
    fun Kedetail1(view: View?){
        val i = Intent(applicationContext, DetailProduk::class.java)
        i.putExtra("Value1", "Sedang berada di halaman Register")
        startActivity(i)
    }
}