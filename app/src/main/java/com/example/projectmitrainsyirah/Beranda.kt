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
    fun gambardetail(view: View?){
        val i = Intent(applicationContext, DetailProduk::class.java)
        i.putExtra("Value1", "Sedang berada di halaman Register")
        startActivity(i)
    }
    fun gambardetail3(view: View?){
        val i = Intent(applicationContext, DetailProduk3::class.java)
        i.putExtra("Value1", "Sedang berada di halaman Register")
        startActivity(i)
    }
    fun gambardetail2(view: View?){
        val i = Intent(applicationContext, DetailProduk2::class.java)
        i.putExtra("Value1", "Sedang berada di halaman Register")
        startActivity(i)
    }
    fun gambardetail4(view: View?){
        val i = Intent(applicationContext, DetailProduk4::class.java)
        i.putExtra("Value1", "Sedang berada di halaman Register")
        startActivity(i)
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