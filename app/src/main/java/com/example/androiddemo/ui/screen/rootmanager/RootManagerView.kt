package com.example.androiddemo.ui.screen.rootmanager

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.androiddemo.ui.screen.home.HomeScreen
import com.example.androiddemo.ui.screen.profile.ProfileView

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RootManagerView(
    navController: NavHostController
) {
    val viewModel: RootManagerViewModel = viewModel()
    Scaffold(
        bottomBar = {
            NavigationBar(
                tonalElevation = NavigationBarDefaults.Elevation
            ) {
                navController.currentBackStackEntry?.destination?.route
                viewModel.bottomTabs.forEachIndexed { index, item ->
                    NavigationBarItem(viewModel.selectedIndex.value == index, onClick = {
                        viewModel.onTabChange(index = index)
                    }, label = {
                        Text(item.label)
                    }, icon = {
                        Icon(
                            imageVector = item.icon, contentDescription = null
                        )
                    })
                }
            }
        }) { padding ->
            when (viewModel.selectedIndex.value) {
                0 -> HomeScreen(navController)
                1 -> ProfileView()
            }
    }
}
