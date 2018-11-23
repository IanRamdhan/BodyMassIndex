package com.fryanramzkhar.bodymassindex

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.fryanramzkhar.bodymassindex.R.id.btnHitung
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.toast
import org.jetbrains.anko.yesButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*operator perbandingan
        ==
         */

        //TODO 1 membuat respon ketika di klik
        //Membuat variabel beratbadan
        btnHitung.setOnClickListener {
            var beratBadan = edtBeratBadan.text.toString()
            var tinggiBadan = edtTinggiBadan.text.toString()
            val kurus = 0.0
            val bataskurus = 18.4
            val normal = 18.5
            val batasnormal = 24.9
            val gemuk = 25.0
            val batasGemuk = 29.9

            //TODO 2 membuat kondisi
            if (beratBadan.toDoubleOrNull() != null && tinggiBadan.toDoubleOrNull() != null) {
                var process = beratBadan.toDouble() / (tinggiBadan.toDouble() * tinggiBadan.toDouble())
                when (process) {
                    in kurus..bataskurus -> {
                        txtHasil.text = "kamu kurus, makan yang banyak ya  $process"
                        alert("kamu kurus"){
                            yesButton {
                            }
                        }.show()
                    }
                    in normal..batasnormal -> {
                        txtHasil.text = "berat badan kamu normal $process"
                        alert("kamu normal"){
                            yesButton {
                            }
                        }.show()
                    }
                    in gemuk..batasGemuk -> {
                        txtHasil.text = "Kamu gemuk $process"
                        alert("kamu gemuk"){
                            yesButton {
                            }
                        }.show()
                    }
                    else -> {
                        txtHasil.text = "kamu obesitas $process"
                        alert("kamu obesitas"){
                            yesButton {
                            }
                        }.show()
                    }
                }
            } else {
                //TODO 3 menampilkan pop up apabila kondisi null
               // Toast.makeText(this, "Silahkan masukan datanya", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
