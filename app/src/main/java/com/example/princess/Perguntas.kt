package com.example.princess

data class Perguntas (
    val id: Int,
    val tituloPergunta: String,
    val image: Int,
    val respA: String,
    val respB: String,
    val respC: String,
    val respD: String,
    val respCorreta: Int
)
