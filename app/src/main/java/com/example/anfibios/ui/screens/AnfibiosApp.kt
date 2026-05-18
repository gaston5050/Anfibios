package com.example.anfibios.ui.screens

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun InicioApp(){

    val viewmodel: AnfibiosViewModel = viewModel(factory = AnfibiosViewModel.Factory)

    HomeScreen(viewmodel.anfibiosUiState)
}
