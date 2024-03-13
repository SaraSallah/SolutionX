package com.example.solutionx.utils

import android.os.Environment
import android.util.Log
import com.example.solutionx.BuildConfig
import java.io.File
import java.io.FileWriter
import java.io.IOException

// Logger.kt
object Logger {
    fun log(message: String) {
        when (BuildConfig.FLAVOR) {
            "logCat" -> logCat(message)
            "logWriter" -> logWriter(message)
            else -> {} // Do nothing for "production" flavor
        }
    }

    private fun logCat(message: String) {
        Log.d("Sara", message)
    }

    private fun logWriter(message: String) {
        val directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
        val file = File(directory, "log.txt")
        try {
            val writer = FileWriter(file, true)
            writer.append(message)
            writer.append("\n")
            writer.flush()
            writer.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}