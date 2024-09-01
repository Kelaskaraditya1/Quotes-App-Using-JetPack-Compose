package com.starkindustries.quotesappusingjetpackcompose.Utility
import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson
import com.starkindustries.quotesappusingjetpackcompose.Data.Quote

object DataManger {
    var data = emptyArray<Quote>()
    val state = mutableStateOf(false)
    fun loadAssetsFromFile(context:Context){
        val inputStream = context.assets.open("quotes.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        // Read the JSON file into the buffer
        inputStream.read(buffer)
        inputStream.close()
        // Convert the buffer into a String
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<Quote>::class.java)
        state.value=true
    }
}