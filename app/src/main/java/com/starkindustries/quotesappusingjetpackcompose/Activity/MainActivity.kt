package com.starkindustries.quotesappusingjetpackcompose.Activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.starkindustries.quotesappusingjetpackcompose.Compose.LoadingScreenCompose
import com.starkindustries.quotesappusingjetpackcompose.Compose.QuoteListCompose
import com.starkindustries.quotesappusingjetpackcompose.Data.Quote
import com.starkindustries.quotesappusingjetpackcompose.Screens.MainScreenCompose
import com.starkindustries.quotesappusingjetpackcompose.Utility.DataManger
import com.starkindustries.quotesappusingjetpackcompose.ui.theme.QuotesAppUsingJetPackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DataManger.loadAssetsFromFile(this)
            App()
        }
    }
}


@Composable
fun App(){
    if(DataManger.state.value){
        MainScreenCompose(data = DataManger.data)
    }
    else{
        LoadingScreenCompose()
    }
}
