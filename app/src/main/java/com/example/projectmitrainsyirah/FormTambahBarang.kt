package com.example.projectmitrainsyirah

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class FormTambahBarang : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_tambah_barang)
    }
    fun keAbout(view: View?){
        val i = Intent(applicationContext, About::class.java)
        i.putExtra("Value1", "Sedang berada di halaman Register")
        startActivity(i)
    }
}