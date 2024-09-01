package com.starkindustries.quotesappusingjetpackcompose.Screens
import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.starkindustries.quotesappusingjetpackcompose.Compose.QuoteListCompose
import com.starkindustries.quotesappusingjetpackcompose.Data.Quote
import com.starkindustries.quotesappusingjetpackcompose.Utility.DataManger

@Composable
fun MainScreenCompose(data:Array<Quote>){
    Column(){
        QuoteListCompose(data = data)
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun PreviewFunctions(){
    MainScreenCompose(data = DataManger.data)
}