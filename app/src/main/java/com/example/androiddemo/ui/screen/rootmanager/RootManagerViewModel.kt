package com.example.androiddemo.ui.screen.rootmanager

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.ViewModel

class RootManagerViewModel : ViewModel() {
    var selectedIndex= mutableIntStateOf(0);

    val bottomTabs = listOf(
        BottomDestination.Home,
        BottomDestination.Profile
    )

    fun onTabChange(index:Int){
        selectedIndex.value=index;
    }
}

sealed class BottomDestination(
    val label: String,
    val icon: ImageVector
) {
    object Home : BottomDestination(
        label = "Home",
        icon = Icons.Outlined.Home
    )

    object Profile : BottomDestination(
        label = "Profile",
        icon = Icons.Outlined.Person
    )
}