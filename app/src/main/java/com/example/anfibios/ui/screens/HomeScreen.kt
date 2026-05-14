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
@Composable
fun HomeScreen(
    anfibiosUiState: AnfibiosUiState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
){
    // El when mapea el estado de la lógica a la vista
    when (anfibiosUiState) {
     //   is AnfibiosUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())//

        is AnfibiosUiState.Loading -> LoadingScreen(
            anfibios = anfibiosUiState.anfibios

        )

        is AnfibiosUiState.Error -> ErrorScreen(
            retryAction = retryAction,
            modifier = modifier.fillMaxSize()
        )
    }
}


@Composable
fun LoadingScreen(
    anfibios: List<Anfibio>
){
    Column(
        modifier = Modifier
            .fillMaxSize()           // Ocupa toda la pantalla
            .wrapContentSize(Alignment.Center), // Centra el contenido
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "¡Hola! Este texto está centrado",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}



@Preview
@Composable
fun coso() {
    LoadingScreen()
}
