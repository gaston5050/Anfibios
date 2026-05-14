package com.example.anfibios.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.anfibios.AnfibiosApplication
import com.example.anfibios.data.model.Anfibio
import com.example.anfibios.data.repository.AnfibiosRepositorio
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface AnfibiosUiState{
    data class Exito(val anfibios: List<Anfibio>) : AnfibiosUiState
    object Error : AnfibiosUiState
    object Loading : AnfibiosUiState
}

class AnfibiosViewModel(private val anfibiosRepositorio: AnfibiosRepositorio) : ViewModel() {

    var anfibiosUiState: AnfibiosUiState by mutableStateOf(AnfibiosUiState.Loading)
    private set

    init {
        getAnfibios()
    }

    fun getAnfibios(){
        viewModelScope.launch {

            anfibiosUiState = try {
                AnfibiosUiState.Exito(anfibiosRepositorio.getAnfibios())
            } catch (e: IOException) {
                AnfibiosUiState.Error
            }
            catch (e: Exception) { // Te sugiero agregar este por si falla la serialización
                println("DEBUG_ERROR: ${e.message}")
                //marsUiState =
                AnfibiosUiState.Error
            }


        }
    }


    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AnfibiosApplication)
                val anfibiosRepositorio = application.container.anfibiosRepositorio
                AnfibiosViewModel(anfibiosRepositorio = anfibiosRepositorio)
            }
        }
    }


}
