package com.example.weatherapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DayForecastComponent(day: String, degrees: String){
    Row(modifier = Modifier
        .fillMaxWidth()){
        Text(text = day, fontSize = 35.sp, textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.CenterVertically))
        Spacer(modifier = Modifier.width(70.dp))
        Text(text = degrees, fontSize = 35.sp, textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.CenterVertically))
        Spacer(modifier = Modifier.width(70.dp))
        Image(
            painter = painterResource( id = R.drawable.sunny ),
            contentDescription = "Sunny icon",
            modifier = Modifier.size(100.dp)
                .weight(100f)
        )
    }
}