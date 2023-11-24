package com.example.princess

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

@Suppress("DEPRECATION")
class EscopoPerguntas : AppCompatActivity(), View.OnClickListener{

    //Criação de variáveis globais, pra ser visto no projeto e não apenas nessa ACTIVITY
    //Variável lista recebe os dados da classe Perguntas
    private var vPosicaoAtual: Int = 1
    private var vListaPerguntas: ArrayList<Perguntas>? = null
    private var vRespSelecionada: Int = 0
    private var vPerguntasCorretas: Int = 0
    private var vnomeUsuario: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_escopo_perguntas)

        vnomeUsuario = intent.getStringExtra(Constantes.nomeUsuario)


        val resp1= findViewById<TextView>(R.id.resp1)
        val resp2 = findViewById<TextView>(R.id.resp2)
        val resp3 = findViewById<TextView>(R.id.resp3)
        val resp4 = findViewById<TextView>(R.id.resp4)
        val btn_conferir = findViewById<Button>(R.id.btn_conferir)

        //Fazer a barra de tarefas não parecer
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        //Variavel global da lista de perguntas, recebe a função(questoes) do objeto CONSTANTES
        vListaPerguntas = Constantes.questoes()

        dadosPrimeiraPergunta()

        //Fazer o botão ser Clicável
        resp1.setOnClickListener(this)
        resp2.setOnClickListener(this)
        resp3.setOnClickListener(this)
        resp4.setOnClickListener(this)
        btn_conferir.setOnClickListener(this)
    }


    //Implemento de menbros da classe OnClikListener
    override fun onClick(v: View?) {
        val resp1= findViewById<TextView>(R.id.resp1)
        val resp2 = findViewById<TextView>(R.id.resp2)
        val resp3 = findViewById<TextView>(R.id.resp3)
        val resp4 = findViewById<TextView>(R.id.resp4)
        val btn_conferir = findViewById<Button>(R.id.btn_conferir)

        //v é um parâmetro de view que refencia o botão clicado
        //Quanto o v de view selecionar a resposta passe a função com os parâmetros
        when(v?.id){
            R.id.resp1 -> {
                estiloSelecionarResposta(resp1, 1)
            }
            R.id.resp2 -> {
                estiloSelecionarResposta(resp2, 2)
            }
            R.id.resp3 -> {
                estiloSelecionarResposta(resp3, 3)
            }
            R.id.resp4 -> {
                estiloSelecionarResposta(resp4, 4)
            }
            R.id.btn_conferir ->{
                //aumenta posição pro botão ir para próxima posição
                if(vRespSelecionada == 0){
                    vPosicaoAtual ++

                    //Enquanto a posição atual for menor que a lista , "reseta" os dados pra próxima pergunta
                    //Caso não vai pra tela resultados
                    when{
                        vPosicaoAtual <= vListaPerguntas!!.size ->{
                            dadosPrimeiraPergunta()
                        }
                        else -> {
                            val intent = Intent(this@EscopoPerguntas, Resultado::class.java)
                            intent.putExtra(Constantes.nomeUsuario, vnomeUsuario)
                            startActivity(intent)
                        }
                    }
                }else{
                    //variável pergunta, recebe a lista de pergunta na posição atual
                    //se tiver a resposta selecionada estiver errado recebe cor
                    //se não a varável perguntasCorretas conta +1
                    //A resposta correta recebe cor, mesmo não sendo selecionada
                    val pergunta = vListaPerguntas?.get(vPosicaoAtual -1)

                    if(pergunta!!.respCorreta != vRespSelecionada){
                        conferirResposta(vRespSelecionada, R.drawable.borda_botao_errado)
                    }else{
                        vPerguntasCorretas++
                    }

                    conferirResposta(pergunta.respCorreta, R.drawable.borda_botao_correto)

                    //mudar o ultimo botão para finalizar o quiz
                    //mudar o botão para próximo
                    if(vPosicaoAtual == vListaPerguntas!!.size){
                        btn_conferir.text = "CONCLUIR"
                    }else{
                        btn_conferir.text = "Próxima Pergunta"
                    }
                    vRespSelecionada = 0
                }
            }
        }
    }


    private fun dadosPrimeiraPergunta(){

        val barraProgresso = findViewById<ProgressBar>(R.id.barraProgresso)
        val contagemProgresso = findViewById<TextView>(R.id.contagemProgresso)
        val pergunta1 = findViewById<TextView>(R.id.pergunta1)
        val imagCinderela = findViewById<ImageView>(R.id.imagCinderela)
        val resp1= findViewById<TextView>(R.id.resp1)
        val resp2 = findViewById<TextView>(R.id.resp2)
        val resp3 = findViewById<TextView>(R.id.resp3)
        val resp4 = findViewById<TextView>(R.id.resp4)
        val btn_conferir = findViewById<Button>(R.id.btn_conferir)


        //? (significa que pode receber qualquer valor, até nulo)
        //cria variavel pergunta que recebe as informações da variavel global e atribui na lista na posição 1
        val pergunta = vListaPerguntas!![vPosicaoAtual -1]

        estiloPadraoResposta()

        if(vPosicaoAtual == vListaPerguntas!!.size){
            btn_conferir.text = "CONCLUIR"
        }else{
            btn_conferir.text = "Verificar"
        }

        //barra de progresso do tipo progresso recebe a posição atual
        //Contagem de progresso do tipo texto = recebe o ($número) da posição atual e o valor máximo definido no xml
        barraProgresso.progress = vPosicaoAtual
        contagemProgresso.text = "$vPosicaoAtual" + "/" + barraProgresso.max

        // !! (Retorna o valor opcional de uma variavel mesmo que ela seja nula)
        // A pergunta1 no xml, recebe a variável pergunta, que chama o dado (título da pergunta) lá na classe de dados
        // A mesma coisa é feito pra imagem e respostas
        pergunta1.text = pergunta!!.tituloPergunta
        imagCinderela.setImageResource(pergunta.image)
        resp1.text = pergunta.respA
        resp2.text = pergunta.respB
        resp3.text = pergunta.respC
        resp4.text = pergunta.respD
    }

    private fun estiloSelecionarResposta(resp: TextView, opcao: Int ){

        //Chama função padrão para que sempre que o mouse fique em cima ele permaneça padrao até clicar
        estiloPadraoResposta()

        //variavel global recebe referencia como int
        //E o texto recebe cor e estilo de borda
        vRespSelecionada = opcao
        resp.setTextColor(Color.parseColor("#F294AD"))
        resp.background = ContextCompat.getDrawable(this, R.drawable.selecao_aparencia_botao)
    }


    private fun estiloPadraoResposta(){

        val resp1= findViewById<TextView>(R.id.resp1)
        val resp2 = findViewById<TextView>(R.id.resp2)
        val resp3 = findViewById<TextView>(R.id.resp3)
        val resp4 = findViewById<TextView>(R.id.resp4)

        //cria uma variavel que recebe um array de texto e adiciona todas as respostas
        val respostas = ArrayList<TextView>()
        respostas.add(0,resp1)
        respostas.add(1,resp2)
        respostas.add(2,resp3)
        respostas.add(3,resp4)

        //Loop para sempre ter a cor e estilo de botao assim que sair o mouse da resposta
        for (resposta in respostas){
            resposta.setTextColor(Color.parseColor("#7A8089"))
            resposta.background = ContextCompat.getDrawable(this, R.drawable.borda_aparencia_botao)
        }
    }


    private fun conferirResposta(respt: Int, respostaCorreta:Int){
        val resp1= findViewById<TextView>(R.id.resp1)
        val resp2 = findViewById<TextView>(R.id.resp2)
        val resp3 = findViewById<TextView>(R.id.resp3)
        val resp4 = findViewById<TextView>(R.id.resp4)

        //Quanto a resposta selecionada for a correta, obtenha como respostaCorreta
        when(respt){
            1 -> {
                resp1.background = ContextCompat.getDrawable(this,respostaCorreta)
            }
            2 -> {
                resp2.background = ContextCompat.getDrawable(this,respostaCorreta)
            }
            3 -> {
                resp3.background = ContextCompat.getDrawable(this,respostaCorreta)
            }
            4 -> {
                resp4.background = ContextCompat.getDrawable(this,respostaCorreta)
            }
        }
    }





}