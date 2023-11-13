 package com.example.basiccodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basiccodelab.ui.theme.BasicCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicCodelabTheme {
                // A surface container using the 'background' color from the theme
                MYApp(modifier = Modifier.fillMaxSize())
            }
            }
        }
    }


// @Composable
// fun Myapp (modifier: Modifier = Modifier) {
//     var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }
//     Surface(modifier) {
//
//         if (shouldShowOnboarding) {
//             Greetings()
//
//         } else {
//
//             OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false })
//         }
//     }

 //}
 @Composable
 fun MYApp(modifier: Modifier = Modifier){

     var shouldShowOnbording by remember { mutableStateOf(true) }
     Surface(modifier) {
         if (shouldShowOnbording){
             OnboardingScreen(onContinueClicked = { shouldShowOnbording= false })
         }else{
             Greetings()
         }

     }
 }

 @Composable
 fun Greetings(modifier :Modifier = Modifier, names:List<String> = List(100){"$it"} ){

         LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
             item { Text("header") }
             items(names) { name ->
                 Greeting(name)
             }


     }

     
 }
 /*
 TODO 2 how to make the button Interactive and make it expandable
  1 - declered a variable
  2 - make alter native of it after clicking the button expanded != expanded
  3  - use the remember to store the previous value while declered teh button
  4 -
*/
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
     var expanded by remember {
         mutableStateOf(false)}

     // create for the expend the screen size after clicked the button
     val extraPadding by animateDpAsState(
         targetValue = if (expanded) 78.dp else 0.dp ,
         animationSpec = tween(durationMillis = 2000)
     )

    Surface(color = MaterialTheme.colorScheme.primary ,
        modifier = Modifier.padding(horizontal = 8.dp , vertical = 4.dp)) {

        Row(modifier = Modifier.padding(16.dp)) {
            // TODO 1 How to create the mutiple line of text in one window

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding)
            ) {
                Text(text = "Hello ")
                Text(text = "$name!")
            }
            ElevatedButton(
                onClick = { expanded = !expanded }
            ) {
                Text(if (expanded) "Show less" else "Show more")
            }

        }

        }


    }
 // TODO OnBoarding screen
 @Composable
 fun OnboardingScreen(
     onContinueClicked: () -> Unit,
     modifier: Modifier = Modifier
 ) {

     Column(
         modifier = modifier.fillMaxSize(),
         verticalArrangement = Arrangement.Center,
         horizontalAlignment = Alignment.CenterHorizontally
     ) {
         Text("Welcome to My App!")
         Button(
             modifier = Modifier.padding(vertical = 24.dp),
             onClick = onContinueClicked
         ) {
             Text("Continue")
         }
     }
 }




 @Preview(showBackground = true , widthDp = 320  , heightDp = 320)
@Composable
fun GreetingPreview() {
    BasicCodelabTheme {
        OnboardingScreen(onContinueClicked = {})
    }
}