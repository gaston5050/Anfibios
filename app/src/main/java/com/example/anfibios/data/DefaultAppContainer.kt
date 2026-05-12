package com.example.anfibios.data

import com.example.anfibios.data.network.AnfibiosApiServicios
import com.example.anfibios.data.repository.AnfibiosRepositorio
import com.example.anfibios.data.repository.NetworkAnfibiosRepositorio
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer{
    val anfibiosRepositorio: AnfibiosRepositorio
}

class DefaultAppContainer : AppContainer {
    // La URL base de tu API (siempre debe terminar en /)
    private val baseUrl = "https://android-kotlin-fun-mars-server.appspot.com/amphibians"

    // CONFIGURO RETROFIT CON   EL CONVERSOR DE SERIALIZACION JSON -> KOTLIN OBJ

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    // Creacion del servicio de la API
    private val retrofitService: AnfibiosApiServicios by lazy {
        retrofit.create(AnfibiosApiServicios::class.java)
    }






    override val anfibiosRepositorio: AnfibiosRepositorio by lazy {
        NetworkAnfibiosRepositorio(retrofitService)
    }
}

