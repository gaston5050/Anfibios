package com.example.anfibios.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.anfibios.data.model.Anfibio

@Composable
fun TarjetaAnfibios(anfibio: Anfibio){


        OutlinedCard(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface,
            ),
            modifier =  Modifier
                .padding(15.dp)
                .wrapContentHeight(),
            border = BorderStroke(1.dp, Color.Black),

        ) {
            Column( modifier = Modifier
                .wrapContentHeight()
                .padding(15.dp)) {
                Text(
                    text = anfibio.name,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.size(5.dp))
                Text(
                    text = anfibio.type,
                    fontStyle = FontStyle.Italic,
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.size(5.dp))
                AsyncImage(
                    anfibio.imgSrc,
                    null,
                    modifier = Modifier
                        .padding(0.dp),
                        contentScale = androidx.compose.ui.layout.ContentScale.FillWidth // <-- ESTO la obliga a estirarse horizontalmente

                )
                Text(
                    text = anfibio.description,
                    modifier = Modifier
                        .padding(10.dp),
                    textAlign = TextAlign.Left,
                )
            }
        }


}

@Preview
@Composable
fun TarjetaPreview (){
    var anfibio: Anfibio = Anfibio("Sapo", "Reptil", "Si es uno normal","https://cdn.britannica.com/85/4685-004-093BB6DE/American-toad.jpg")

    TarjetaAnfibios(anfibio)
}