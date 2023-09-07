package com.kapucu.kullaniciarayuzdeneme

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.kapucu.kullaniciarayuzdeneme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var preferences:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        preferences =getSharedPreferences("kullanicilar", MODE_PRIVATE)


        binding.girisyapbutton.setOnClickListener {

            var kayitlikullaniciadi = preferences.getString("kullanici","")
            var kayitliparola = preferences.getString("parola","")


            var girisKullanici = binding.girisKullaniciAdiText.text.toString()
            var girisParola = binding.girisParolaText.text.toString()

            if(TextUtils.isEmpty(girisKullanici)){
                binding.girisKullaniciAdiText.error ="Lütfen Kullanıcı Adı Giriniz"
                return@setOnClickListener
            }
            else  if(TextUtils.isEmpty(girisParola)){
                binding.girisParolaText.error ="Lütfen Parola Giriniz"
                return@setOnClickListener
            }


            if((kayitlikullaniciadi==girisKullanici)&&(kayitliparola==girisParola)){

                intent = Intent(applicationContext,Profilsayfasi::class.java)
                startActivity(intent)

            } else {
                Toast.makeText(applicationContext,"Giriş Bilgileriniz Hatalı Tekrar Deneyin", Toast.LENGTH_LONG).show()
            }


        }

        binding.girisbtnkayitol.setOnClickListener {
            intent= Intent(applicationContext,Kayitolsayfasi:: class.java)
            startActivity(intent)
            onPause()
        }
    }

}