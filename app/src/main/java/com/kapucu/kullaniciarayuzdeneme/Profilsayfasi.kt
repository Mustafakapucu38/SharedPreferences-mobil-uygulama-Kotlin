package com.kapucu.kullaniciarayuzdeneme

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kapucu.kullaniciarayuzdeneme.databinding.ActivityProfilsayfasiBinding

class Profilsayfasi : AppCompatActivity() {
    lateinit var binding: ActivityProfilsayfasiBinding
    lateinit var preference:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfilsayfasiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preference = getSharedPreferences("kullanicilar", MODE_PRIVATE)
        var kayitolankullanici = preference.getString("kullanici","")
        var kayitolanparola = preference.getString("parola","")

        binding.profiladsoyad.text ="Kullanıcı Adınız :"+ kayitolankullanici.toString()
        binding.profilparola.text ="Kullanıcı Parolanız :"+ kayitolanparola.toString()

        binding.profilkamerabtn.setOnClickListener {
            startActivity(Intent(this@Profilsayfasi,CameraSayfasi::class.java))
            onPause()
        }



        binding.profilcikisyap.setOnClickListener {
            intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)


        }
    }
}