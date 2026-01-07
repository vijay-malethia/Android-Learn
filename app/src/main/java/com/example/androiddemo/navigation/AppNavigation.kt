package com.example.androiddemo.navigation

import kotlinx.serialization.Serializable

@Serializable
object Splash
@Serializable
object Login
@Serializable
object Profile

@Serializable
object RootManager

@Serializable
data class Home(val name: String)