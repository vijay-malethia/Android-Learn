package com.example.androiddemo.ui.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.androiddemo.R
import com.example.androiddemo.navigation.Login
import com.example.androiddemo.navigation.RootManager
import com.example.androiddemo.ui.screen.auth.LoginView
import com.example.androiddemo.ui.theme.BgGradient
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController, viewModel: SplashViewModel = viewModel()) {
    LaunchedEffect(key1 = Unit) {
        delay(2000)
        navController.navigate(Login)
    }
    Image(
        modifier = Modifier.background(
            brush = BgGradient
        ).fillMaxSize(),
        painter = painterResource(R.drawable.applogo),
        contentDescription = null,
        alpha = 0.8f,
    )
}

