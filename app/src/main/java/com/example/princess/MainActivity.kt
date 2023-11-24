package com.example.princess

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btniniciar = findViewById<Button>(R.id.btniniciar)
        val nome = findViewById<TextView>(R.id.nome)


        //Fazer a barra de tarefas não parecer
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        btniniciar.setOnClickListener{
            if (nome.text.toString().isEmpty())
                //se o "nome" estiver vazio
                Toast.makeText(this,"Por favor, insira seu nome.",Toast.LENGTH_SHORT).show()
                //Exiba uma noticação em texto                               ,Por um período curto.Exiba()

            else{
                //Inicializa a inteção (que vai da Pag main,para a página Questao1)
                //A variável intent receb informações extras para a constante nomeUsuário (valor imputado em nome).
                val intent = Intent(this@MainActivity, EscopoPerguntas::class.java)
                intent.putExtra(Constantes.nomeUsuario, nome.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }

}