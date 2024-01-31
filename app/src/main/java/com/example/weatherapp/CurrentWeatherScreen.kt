package com.example.weatherapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun CurrentWeatherScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp)
            .background(Color.Cyan),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header()
        Row( modifier = Modifier.padding(16.dp) ) {
            Image(
                painter = painterResource( id = R.drawable.sunny ),
                contentDescription = "Sunny icon",
                modifier = Modifier.size(100.dp)
            )
            Spacer(modifier = Modifier.width(100.dp))
            Text(text = "28C", fontSize = 35.sp, textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(Alignment.CenterVertically))
        }
        Text(text = stringResource(R.string.sunny), fontSize = 30.sp)

        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = { navController.navigate("weatherForecastScreen") }) {
            Text(text = stringResource(R.string.forecast))
        }
    }
}