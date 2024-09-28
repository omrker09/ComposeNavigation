package com.example.bottomnav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen (
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomBarScreen (
        route = "Home",
        title = "Home",
        icon = Icons.Default.Home
    )

    object Profile : BottomBarScreen (
        route = "Profile",
        title = "Profile",
        icon = Icons.Default.AccountCircle
    )

    object Settings : BottomBarScreen (
        route = "Settings",
        title = "Settings",
        icon = Icons.Default.Settings
    )
}