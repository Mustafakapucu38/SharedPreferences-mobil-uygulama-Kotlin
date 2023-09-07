package com.kapucu.kullaniciarayuzdeneme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.kapucu.kullaniciarayuzdeneme.databinding.ActivityKayitolsayfasiBinding

class Kayitolsayfasi : AppCompatActivity() {
    lateinit var binding: ActivityKayitolsayfasiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKayitolsayfasiBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //kaydet butonuna basınca kayıt almak için
        binding.Kayitsayfasikaydet.setOnClickListener {

            var kullaniciAdi = binding.kayitKullaniciAditext.text.toString()
            var kullanicisifre = binding.kayitParolatext.text.toString()


            if (TextUtils.isEmpty(kullaniciAdi)) {

                binding.kayitKullaniciAditext.error = "Lütfen Kullanıcı Adınızı Giriniz"
                return@setOnClickListener

            } else if (TextUtils.isEmpty(kullanicisifre)) {

                binding.kayitParolatext.error = "Lütfen parolanızı giriniz"
                return@setOnClickListener
            }


            var SharedPreferences = this.getSharedPreferences("kullanicilar", MODE_PRIVATE)
            //verileri eklemek ve  güncellemek için kullandım
            var editor = SharedPreferences.edit()

            // veri ekleme
            editor.putString("kullanici","$kullaniciAdi").apply()
            editor.putString("parola","$kullanicisifre").apply()
            Toast.makeText(applicationContext,"Kayıtınız  Başarılı ile oluşturuldu",Toast.LENGTH_LONG).show()
            binding.kayitKullaniciAditext.text.clear()
            binding.kayitParolatext.text.clear()

        }



        // girişe dönmek için
        binding.KayitSayfasiGiriseDon.setOnClickListener {
            intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)

        }
    }
}