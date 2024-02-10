package com.example.weatherapp

import android.R.attr.value
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

data class WeatherItem(var temperature: String, var day: String, var conditions: String)

@Composable
fun WeatherForecastScreen(navController: NavHostController) {
    val weatherItemList = listOf<WeatherItem>(
        WeatherItem("-2C", "Mon", "clouds"),
        WeatherItem("-12C", "Tue", "sunny"),
        WeatherItem("-7C", "Wed", "clouds"),
        WeatherItem("0C", "Thu", "sunny"),
        WeatherItem("3C", "Fri", "clouds"));
    var isChecked by remember { mutableStateOf(false) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(weatherItemList) {weatherItem ->
            DayForecastComponent(day = weatherItem.day, degrees = weatherItem.temperature, conditions = weatherItem.conditions)
        }
        item {
            Switch(
                checked = isChecked,
                onCheckedChange = { newCheckedState -> isChecked = newCheckedState }
            )

            Text(text = stringResource(R.string.useless_for_now), fontSize = 10.sp)
            Spacer(modifier = Modifier.fillMaxWidth().height(60.dp))
            Button(onClick = {navController.navigate("currentWeatherScreen")  }) {
                Text(text = stringResource(R.string.current_weather))
            }
        }
    }


}

@Composable
fun DayForecastComponent(day: String, degrees: String, conditions: String){
    var imageResourceId = R.drawable.clouds;
    if (conditions=="sunny") {
        imageResourceId = R.drawable.sunny
    }
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
            painter = painterResource( id = imageResourceId ),
            contentDescription = "Sunny icon",
            modifier = Modifier
                .size(100.dp)
                .weight(100f)
        )
    }
}