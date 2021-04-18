package com.example.dsgc

import android.app.Application

class DsgcApp : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: DsgcApp
    }
}