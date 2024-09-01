package com.starkindustries.quotesappusingjetpackcompose.Compose
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.starkindustries.quotesappusingjetpackcompose.Data.Quote
import com.starkindustries.quotesappusingjetpackcompose.Utility.DataManger

@Composable
fun QuotesRowCompose(quote: Quote){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(10.dp)
            .clickable { },
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors()
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            Image(imageVector = Icons.Filled.FormatQuote, contentDescription = "",
                colorFilter = ColorFilter.tint(Color.White),
                modifier = Modifier
                    .size(100.dp)
                    .padding(10.dp, 10.dp, 10.dp, 40.dp)
                    .weight(0.2f)
                    .rotate(180f)
                    .clip(RectangleShape)
                    .border(2.dp, Color.Black, RectangleShape)
                    .background(Color.Black))

            Column(modifier = Modifier
                .fillMaxSize()
                .weight(0.8f)) {
                Text(text = quote.quote,
                    textAlign = TextAlign.Start,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.W500,
                    modifier = Modifier.padding(0.dp,15.dp,0.dp,10.dp))
                Box(modifier = Modifier
                    .height(2.dp)
                    .width(150.dp)
                    .background(Color.LightGray)){
                }
                Text(text = quote.author,
                    modifier = Modifier.padding(0.dp,5.dp,0.dp,0.dp),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W400)
            }
        }
    }
}

@Composable
fun DisplayCardCompose(quote: Quote){
    Box(modifier = Modifier.fillMaxSize()){
        Card(modifier = Modifier
            .size(350.dp)
            .fillMaxSize()
            .align(Alignment.Center),
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(),
            elevation = CardDefaults.cardElevation(12.dp)
        ) {
            Image(imageVector = Icons.Filled.FormatQuote,
                contentDescription = "",
                modifier = Modifier
                    .size(100.dp)
                    .rotate(180f)
                    .padding(0.dp, 10.dp))
            Column(modifier = Modifier
                .fillMaxSize()
                .weight(0.8f)) {
                Text(text = quote.quote,
                    textAlign = TextAlign.Start,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.W500,
                    modifier = Modifier.padding(20.dp,10.dp,0.dp,10.dp))
                Box(modifier = Modifier
                    .height(2.dp)
                    .fillMaxWidth()
                    .padding(20.dp, 0.dp, 220.dp, 0.dp)
                    .width(150.dp)
                    .background(Color.Gray)){
                }
                Text(text = quote.author,
                    modifier = Modifier.padding(20.dp,10.dp,0.dp,0.dp),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W400)
            }
        }
    }
}

@Composable
fun QuoteListCompose(data:Array<Quote>){
        LazyColumn (modifier = Modifier
            .fillMaxSize()
            .padding(0.dp, 20.dp, 0.dp, 0.dp)
            .verticalScroll(rememberScrollState())){
                items(data){
                    QuotesRowCompose(quote = it)
                }
            }
}

@Composable
fun LoadingScreenCompose(){
    Box(modifier = Modifier.fillMaxSize()){
        Text(text = "Loading...",
            modifier = Modifier.align(Alignment.Center),
            fontWeight = FontWeight.W500,
            fontSize = 30.sp)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewFunction(){
    QuoteListCompose(data = DataManger.data)
}