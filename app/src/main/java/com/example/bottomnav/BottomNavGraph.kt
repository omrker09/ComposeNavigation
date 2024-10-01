package com.example.bottomnav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.bottomnav.screens.HomeScreen
import com.example.bottomnav.screens.ProfileScreen
import com.example.bottomnav.screens.SettingsScreen
import com.example.bottomnav.utils.BottomBarClass

@Composable
fun BottomNavGraph(navController: NavHostController, navControllerScreens: NavHostController) {
    NavHost(
        navController = navController ,
        startDestination = BottomBarClass.Home.route
    )
    {
        composable(route = BottomBarClass.Home.route) {
            HomeScreen(navControllerScreens)
        }
        composable(route = BottomBarClass.Profile.route) {
            ProfileScreen()
        }
        composable(route = BottomBarClass.Settings.route) {
            SettingsScreen(navControllerScreens)
        }
    }
}