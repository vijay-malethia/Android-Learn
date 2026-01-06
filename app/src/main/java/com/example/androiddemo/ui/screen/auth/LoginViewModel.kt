package com.example.androiddemo.ui.screen.auth

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {

    val emialController = mutableStateOf(value = "");
    val passWord = mutableStateOf(value = "");

}