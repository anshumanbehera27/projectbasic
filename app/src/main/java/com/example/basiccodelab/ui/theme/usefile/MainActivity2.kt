package com.example.basiccodelab.ui.theme.usefile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.basiccodelab.Dasboard
import com.example.basiccodelab.DashBordScreen
import com.example.basiccodelab.Deatails

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           Row ( Modifier.fillMaxWidth(),
               horizontalArrangement = Arrangement.SpaceEvenly
           )
           {
               catagory.forEach{
                   menu(catagory = it)
               }
           }

        }
    }
}
@Composable
fun Mynavagation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Dasboard.route){
        composable(Dasboard.route){
            DashBordScreen(navController)
        }
        composable(Deatails.route){
            DeatilScreen()
        }
    }
}
