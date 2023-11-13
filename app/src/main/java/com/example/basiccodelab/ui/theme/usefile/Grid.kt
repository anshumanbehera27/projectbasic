package com.example.basiccodelab.ui.theme.usefile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.basiccodelab.R

@Composable
fun gridCell(){
    Card(

        modifier = Modifier.padding(8.dp)


    ) {
        Box(modifier = Modifier
            .requiredSize(180.dp, 180.dp)
            .padding(8.dp)){

            Image(painter = painterResource(R.drawable.register_page), contentDescription = null)
        }
        Text(text = "welcome to the page ")

    }
}