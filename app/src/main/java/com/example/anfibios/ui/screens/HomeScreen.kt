package com.example.anfibios.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.anfibios.data.model.Anfibio


@Composable
fun HomeScreen(
    anfibiosUiState: AnfibiosUiState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
){
    // El when mapea el estado de la lógica a la vista
    when (anfibiosUiState) {
        is AnfibiosUiState.Loading -> LoadingScreen()
        is AnfibiosUiState.Exito -> Text(text="Acá van a ir los datos despues")
        is AnfibiosUiState.Error -> Text(text = "¡Acá va a ir el error después!", modifier = modifier)
    }
}


@Composable
fun LoadingScreen(
    //anfibios: List<Anfibio>
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Cargando anfibios...",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
    }
}



@Preview
@Composable
fun coso() {
    LoadingScreen()
}
