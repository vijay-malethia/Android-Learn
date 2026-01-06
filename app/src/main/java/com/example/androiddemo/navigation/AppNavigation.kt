package com.example.androiddemo.navigation

import kotlinx.serialization.Serializable

//enum class Screen{
//    SPLASH,
//    HOME
//}
//
//sealed class NavigationItem(val route: String){
//
//}
@Serializable
object Splash
@Serializable
object Login
@Serializable
data class Home(val name: String)