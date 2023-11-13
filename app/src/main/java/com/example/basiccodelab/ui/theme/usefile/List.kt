package com.example.basiccodelab.ui.theme.usefile

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun menu(catagory:String){
    Button(onClick = { /*TODO*/ },
        colors =  ButtonDefaults.buttonColors(Color.LightGray) ,
        shape =  RoundedCornerShape(40),
        modifier =  Modifier.padding(5.dp)
    ){
        Text(text = catagory )
    }
}
val catagory = listOf<String>(
    "Lunch",
    "Dessert",
    "Mains"
)