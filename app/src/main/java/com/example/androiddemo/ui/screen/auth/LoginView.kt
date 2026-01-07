package com.example.androiddemo.ui.screen.auth

import AppTextField
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.androiddemo.navigation.Home
import com.example.androiddemo.navigation.RootManager
import com.example.androiddemo.ui.common.CustomButton
import com.example.androiddemo.ui.screen.home.HomeScreen
import com.example.androiddemo.ui.theme.BgGradient
import com.example.androiddemo.ui.theme.white


@Composable
fun LoginView(
    viewModel: LoginViewModel= viewModel(),
    navController: NavHostController
) {
    Column(
        modifier = Modifier.background(
            brush = BgGradient
        ).fillMaxSize().padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome back to Mashimofu", color = white, fontSize =24.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(10.dp))
        Text("Login to start playing and traking your bets.", color = white, fontSize =16.sp)
        Spacer(Modifier.height(20.dp))
        AppTextField(
            value = viewModel.emialController.value,
            onValueChange = { viewModel.emialController.value = it },
            label = "App Name",
            hint = "Enter app name",
//            isError = viewModel.emialController.value.length < 6,
            errorText = "Minimum 6 characters"
        )
        Spacer(Modifier.height(15.dp))
        AppTextField(
            value = viewModel.passWord.value,
            onValueChange = { viewModel.passWord.value = it },
            label = "Password",
            hint = "Enter password",
//            isError = viewModel.emialController.value.length < 6,
            errorText = "Minimum 6 characters"
        )
        Spacer(Modifier.height(20.dp))
        CustomButton({
           navController.navigate(RootManager)
        },"Login")
    }}

