![Imagem logo Welcome Day](https://github.com/AmandaSenra/Ap2_Mobile/assets/94198321/d0fbcb85-6e4b-4f9f-aee8-38862a0e908c)
# Atividade prática Welcome Day Ibmec - 2024.1

<p align="center">
  <img loading="badges" src="https://img.shields.io/badge/2022.3.1_Patch%203-version?style=plastic&logo=androidstudio&logoColor=%23ffff&label=Giraffe&color=%23000080"/> &nbsp
  <img loading="badges" src="https://img.shields.io/badge/Realizado-Status?style=social&logo=android&logoColor=%23000080&label=Status&labelColor=%23FFFFFF&color=%23000080"/>
</p>


# Índice 

* [Descrição do Projeto](#descrição-do-projeto)
* [Funcionalidades e Demonstração da Aplicação](#funcionalidades-e-demonstração-da-aplicação)
* [Explicação da Aplicação](#explicação-da-aplicação)
* [Vez dos alunos](#vez-dos-alunos)
* [Conclusão](#conclusão)


# Descrição do Projeto
<p>No Welcome Day, alguns alunos são selecionados a dar uma atividade prática para os calouros no seu primeiro dia de faculdade. Sendo a segunda vez selecionada, decidi fazer um aplicativo mobile simples em kotlin. Um app que sorteia números aleatórios.</p>
 

# Funcionalidades e Demonstração da Aplicação
<p>Essa aplicação tem a função de gerar números aleatórios após clique em botão.</p>
<br>
<p align="center">
  <img loading="gif" src="https://github.com/AmandaSenra/Ap2_Mobile/assets/94198321/f818a102-adeb-4a7f-a331-1fc7511b4165"/>
</p>


# Explicação da Aplicação
<p>O objetivo no primeiro dia de aula dos calouros é fazer com que o código seja divertido e não gere medo, pois para muitos alunos esse é o primeiro contato com um código em definitivo. Então expliquei como montar um design basíco como backgroud e após montamos a lógica da aplicação.</p>

<p>Aqui deixo a lógica em JBSJBJ, como uma forma de explicação.</p>

>
>fun sortear(view: View) {
> 
>>val textoResultado = findViewById<TextView>(R.id.resultado)
>>
>>val numero = Random().nextInt(101) //0...99
>>
>>textoResultado.setText("$numero")}



# Vez dos alunos

# Conclusão
