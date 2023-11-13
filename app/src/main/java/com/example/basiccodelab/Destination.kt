package com.example.basiccodelab

interface Destination{
    val route:String
}
object Dasboard:Destination{
    override val route = "Home"
}
object Deatails:Destination{
    override val route = "Deatails"
}