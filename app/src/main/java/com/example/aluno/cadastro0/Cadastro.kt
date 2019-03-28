package com.example.aluno.cadastro0

import android.os.Bundle
import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.view.View
import android.widget.TextView
import com.example.aluno.cadastro.AppStaticServices
import org.jetbrains.anko.toast
import kotlinx.android.synthetic.main.activity_cadastro.*

class Cadastro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val btIncluir: Button = findViewById(R.id.btIncluir)

        btIncluir.setOnClickListener(View.OnClickListener {
            val textViewLogin: TextView = findViewById<TextView>(R.id.etUserName) as TextView
            val textViewSenha: TextView = findViewById<TextView>(R.id.epSenha) as TextView
            val textViewNome: TextView = findViewById<TextView>(R.id.etNome) as TextView
            val textViewEmail: TextView = findViewById<TextView>(R.id.etEmail) as TextView

            //val loginResult: Boolean = AppStaticServices.login(
                    //textViewLogin.text.toString(),
                    //textViewSenha.text.toString(),
                    //textViewNome.text.toString(),
                   // textViewEmail.text.toString())

            val btLimpar: Button = findViewById(R.id.btLimpar)

            btLimpar.setOnClickListener(View.OnClickListener {
                val etUserName = etUserName.text.clear()
                val epSenha = epSenha.text.clear()
                val etNome = etNome.text.clear()
                val etEmail = etEmail.text.clear()

            })



        })
    }
}
