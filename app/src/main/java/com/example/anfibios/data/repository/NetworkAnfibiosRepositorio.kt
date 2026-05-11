package com.example.anfibios.data.repository

import com.example.anfibios.data.model.Anfibio
import com.example.anfibios.data.network.AnfibiosApiServicios

class NetworkAnfibiosRepositorio (private val anfibiosApiServicios: AnfibiosApiServicios) : AnfibiosRepositorio {

    override suspend fun getAnfibios(): List<Anfibio> {
        return anfibiosApiServicios.getAnfibios()
    }
}


