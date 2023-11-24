package com.example.princess

object Constantes{

    const val nomeUsuario: String = "nomeUsuario"

    fun questoes():ArrayList<Perguntas>{
        val listaPerguntas = ArrayList<Perguntas>()

        val que1 = Perguntas(
            1,
            "Qual princesa perdeu o sapatinho de cristal?",
            R.drawable.sapatinho,
            "Bela",
            "Aurora",
            "Cinderela",
            "Moana",
            3
        )
        listaPerguntas.add(que1)


        val que2 = Perguntas(
            2,
            "Qual princesa acaba perdendo a voz, para se tornar humana?",
            R.drawable.ariel,
            "Branca de neve",
            "Ariel",
            "Pocahontas",
            "Merida",
            2
        )
        listaPerguntas.add(que2)


        val que3 = Perguntas(
            3,
            "Qual princesa se vestiu de soldado, para salvar a vida do imperador?",
            R.drawable.mulan,
            "Mulan",
            "Tiana",
            "Anna",
            "Jasmine",
            1
        )
        listaPerguntas.add(que3)


        val que4 = Perguntas(
            4,
            "Qual princesa tem um tigre de estimção?",
            R.drawable.jasmine,
            "Alice",
            "Jasmine",
            "Rapunzel",
            "Elsa",
            2
        )
        listaPerguntas.add(que4)


        val que5 = Perguntas(
            5,
            "Qual princesa se apaixona por uma fera?",
            R.drawable.bela,
            "Vanellope",
            "Merida",
            "Sininho",
            "Bela",
            4
        )
        listaPerguntas.add(que5)


        val que6 = Perguntas(
            6,
            "Qual é o nome da princesa do gelo?",
            R.drawable.elsa,
            "Frozen",
            "Branca de neve",
            "Elsa",
            "Anna",
            3
        )
        listaPerguntas.add(que6)


        val que7 = Perguntas(
            7,
            "Qual princesa tem o poder de curar e rejuvenescer as pessoas?",
            R.drawable.rapunzel,
            "Aurora",
            "Rapunzel",
            "Ariel",
            "Mulan",
            2
        )
        listaPerguntas.add(que7)


        val que8 = Perguntas(
            8,
            "Qual princesa é apaixonada por carros de corrida?",
            R.drawable.vanellope,
            "Sininho",
            "Pocahontas",
            "Vanellope",
            "Cinderela",
            3
        )
        listaPerguntas.add(que8)


        val que9 = Perguntas(
            9,
            "Qual princesa descobre o País das Maravilhas?",
            R.drawable.alice,
            "Ariel",
            "Jasmine",
            "Tiana",
            "Alice",
            4
        )
        listaPerguntas.add(que9)


        val que10 = Perguntas(
            10,
            "Qual princesa foge da rainha má e acaba adormecendo em uma cabana de anões?",
            R.drawable.branca,
            "Branca de neve",
            "Alice",
            "Anna",
            "Pocahontas",
            1
        )
        listaPerguntas.add(que10)


        return listaPerguntas

    }
}