package com.example.anfibios.data.repository

import com.example.anfibios.data.model.Anfibio

interface AnfibiosRepositorio {
    suspend fun getAnfibios(): List<Anfibio>
}