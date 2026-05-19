package com.example.anfibios.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.anfibios.data.model.Anfibio


@Composable
fun HomeScreen(
    anfibiosUiState: AnfibiosUiState,
   // retryAction: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
){
    // El when mapea el estado de la lógica a la vista
    when (anfibiosUiState) {
       is AnfibiosUiState.Exito -> ExitoScreen(anfibiosUiState.anfibios,
           modifier = modifier)//

        is AnfibiosUiState.Loading -> LoadingScreen( )

        is AnfibiosUiState.Error -> ErrorScreen( )
    }
}


@Composable
fun ExitoScreen(anfibios: List<Anfibio>, modifier: Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxSize()          , // Ocupa toda la pantalla
            //.wrapContentSize(Alignment.Center), // Centra el contenido
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
    items(anfibios){
        anfibio ->
        TarjetaAnfibios(anfibio = anfibio)

    }
        /*
        Text(
            text = "¡Hola! Este es el primer anfibio: ${anfibios[0].name}",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        AsyncImage(
            model =  "https://cdn.britannica.com/85/4685-004-093BB6DE/American-toad.jpg",//anfibios[0].imgSrc,
            contentDescription =null,
        )*/
    }
}


@Composable
fun ErrorScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()           // Ocupa toda la pantalla
            .wrapContentSize(Alignment.Center), // Centra el contenido
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "¡Hola! Esto es un error!",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun LoadingScreen(){
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
