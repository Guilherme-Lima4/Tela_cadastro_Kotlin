package com.example.aluno.cadastro0

import android.os.Bundle
import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.view.View
import android.widget.TextView
import com.example.aluno.cadastro.AppStaticServices
import kotlinx.android.synthetic.main.activity_cadastro.*
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import org.jetbrains.anko.*

//import android.support.design.widget.Snackbar


class Cadastro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_cadastro)

       // val btIncluir: Button = this.findViewById(R.id.btIncluir)

//        btIncluir.setOnClickListener(View.OnClickListener {
//            val textViewLogin: TextView = findViewById<TextView>(R.id.etUserName) as TextView
//            val textViewSenha: TextView = findViewById<TextView>(R.id.epSenha) as TextView
//            val textViewNome: TextView = findViewById<TextView>(R.id.etNome) as TextView
//            val textViewEmail: TextView = findViewById<TextView>(R.id.etEmail) as TextView

            //val loginResult: Boolean = AppStaticServices.login(
                    //textViewLogin.text.toString(),
                    //textViewSenha.text.toString(),
                    //textViewNome.text.toString(),
                   // textViewEmail.text.toString())

            //val btLimpar: Button = findViewById(R.id.btLimpar)

//            btLimpar.setOnClickListener(View.OnClickListener {
//                val epSenha = epSenha.text.clear()
//                val etUserName = etUserName.text.clear()
//                val etNome = etNome.text.clear()
//                val etEmail = etEmail.text.clear()
//
//            })

        lateinit var edId: TextView
        lateinit var edNome: TextView
        lateinit var edEmail: TextView
        lateinit var edPass: TextView
        var bntListar: TextView

        var edCreated: TextView

        verticalLayout {

            padding = dip(100)
            background = ColorDrawable(Color.parseColor("#F8F2F2"))

            edId = editText {
                hint = "Id Hint"
                textSize = 24f
                textColor = Color.GREEN
                //CENTER can be INHERIT GRAVITY TEXT_START TEXT_END VIEW_START VIEW_END
                textAlignment = View.TEXT_ALIGNMENT_CENTER
            }
            edNome = editText {
                hint = "Nome Hint"
                textSize = 24f
                textAlignment = View.TEXT_ALIGNMENT_GRAVITY
            }
            edEmail = editText {
                hint = "email"
                textSize = 24f
            }
            edPass = editText {
                hint = "Pass"
                textSize = 24f
            }
            edCreated = editText {
                hint = "Email Hint"
                textSize = 24f
            }
            var button: Button = button("Incluir") {
                setOnClickListener(View.OnClickListener {
                    var u: Usuario = Usuario(
                            edNome.text.toString(),
                            edEmail.text.toString(),
                            edPass.text.toString()
                    )
                    UsuaryRepository(getApplicationContext()).create(u)

                    alert(
                            "Usuario Cadastrado com Sucesso",
                            "Vc ja conhecia o toast com maior duracao?") {
                        yesButton { longToast("Esse toast dura mais tempo…") }
                        noButton {}
                    }.show()

                    toast("toast normal: Usuario Incluido com sucesso")
                })
            }
            var btnList: Button = button("Listar") {

                toast("Listar Usuarios...")
                var listU: List<Usuario> = UsuaryRepository(getApplicationContext()).findAll()
                for (u:Usuario in listU){
                    toast(u.nome)
                }
            }
        }
    }
}


