package com.example.anfibios.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.anfibios.data.model.Anfibio

@Composable
fun TarjetaAnfibios(anfibio: Anfibio){

    Card

}

@Preview
@Composable
fun TarjetaPreview (){
    var anfibio: Anfibio = Anfibio("Sapon", "Reptil", "Si es uno normal","https://cdn.britannica.com/85/4685-004-093BB6DE/American-toad.jpg")

    TarjetaAnfibios(anfibio)
}