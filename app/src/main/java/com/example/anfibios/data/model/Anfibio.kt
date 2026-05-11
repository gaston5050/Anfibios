package com.example.anfibios.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Anfibio(
    val name: String,
    val type: String,
    val description: String,

    @SerialName("img_src")
    val imgSrc: String
)
