package com.example.anfibios.data.model

import kotlinx.serialization.SerialName

data class Anfibio(
    val name: String,
    val type: String,
    val description: String,

    @SerialName("img_src")
    val imgSrc: String
)
