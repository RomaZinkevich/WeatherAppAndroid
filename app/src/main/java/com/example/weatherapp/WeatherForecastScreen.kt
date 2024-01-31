package com.example.weatherapp

import android.R.attr.value
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun WeatherForecastScreen(navController: NavHostController) {
    var isChecked by remember { mutableStateOf(false) }
    Column (modifier = Modifier
        .fillMaxSize()
        .padding(0.dp)
        .background(Color(5, 186, 220)),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Header()
        DayForecastComponent(day = stringResource(R.string.mon), degrees = "-2C")
        DayForecastComponent(day = stringResource(R.string.tue), degrees = "-12C")
        DayForecastComponent(day = stringResource(R.string.wed), degrees = "-7C")
        DayForecastComponent(day = stringResource(R.string.thu), degrees = "0C")
        DayForecastComponent(day = stringResource(R.string.fri), degrees = "3C")

        Switch(
            checked = isChecked,
            onCheckedChange = { newCheckedState -> isChecked = newCheckedState }
        )

        Text(text = stringResource(R.string.useless_for_now), fontSize = 10.sp)
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = { navController.navigate("currentWeatherScreen") }) {
            Text(text = stringResource(R.string.current_weather))
        }
    }
}