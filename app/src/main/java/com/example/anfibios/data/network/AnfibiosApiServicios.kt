package com.example.anfibios.data.network
import com.example.anfibios.data.model.Anfibio

import retrofit2.http.GET

interface AnfibiosApiServicios {

    @GET("amphibians")
    suspend fun getAnfibios(): List<Anfibio>


}