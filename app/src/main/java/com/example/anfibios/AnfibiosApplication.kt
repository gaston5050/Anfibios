package com.example.anfibios

import android.app.Application
import com.example.anfibios.data.AppContainer
import com.example.anfibios.data.DefaultAppContainer

class AnfibiosApplication: Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
    }