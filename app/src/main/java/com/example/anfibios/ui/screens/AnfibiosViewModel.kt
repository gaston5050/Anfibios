package com.example.anfibios.ui.screens

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.anfibios.data.model.Anfibio
import com.example.anfibios.data.repository.AnfibiosRepositorio

sealed interface AnfibiosUiState{
    data class Exito(val anfibios: List<Anfibio>) : AnfibiosUiState
}

class AnfibiosViewModel(private val anfibiosRepositorio: AnfibiosRepositorio) : ViewModel() {

    var anfibiosUiState: AnfibiosUiState by mutableStateOf(AnfibiosUiState.Loading)
    private set
}
