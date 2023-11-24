package com.example.princess


import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

@Suppress("DEPRECATION")
class Resultado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        //Fazer a barra de tarefas não parecer
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN


        //variavel recebe o nome do usuário
        //O nome tipo texto no xml , recebe esse dado
        val nome = findViewById<TextView>(R.id.nome)
        val nomeUsuario = intent.getStringExtra(Constantes.nomeUsuario)

        nome.text = nomeUsuario


        val finalBotao = findViewById<Button>(R.id.finalBotao)
        finalBotao.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }

        val github = findViewById<ImageButton>(R.id.gitHub)
        github.setOnClickListener{
            val portifolio = Uri.parse("https://github.com/AmandaSenra/Princess")
            val intent = Intent(Intent.ACTION_VIEW,portifolio)
            startActivity(intent)
        }

    }
}