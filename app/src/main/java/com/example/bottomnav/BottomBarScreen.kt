package com.example.bottomnav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector,
    val iconUnselected: ImageVector,
    val resourceIcon: Int,
    val resourceIconUnselected: Int
) {
    object Home : BottomBarScreen (
        route = "Home",
        title = "Home",
        icon = Icons.Default.Home,
        iconUnselected = Icons.Outlined.Home,
        resourceIcon = R.drawable.home_fill,
        resourceIconUnselected = R.drawable.home_outlined,
    )

    object Profile : BottomBarScreen (
        route = "Payment",
        title = "Payment",
        icon = Icons.Default.AccountCircle,
        iconUnselected = Icons.Outlined.AccountCircle,
        resourceIcon = R.drawable.payment_fill,
        resourceIconUnselected = R.drawable.payment_outlined,
    )

    object Settings : BottomBarScreen (
        route = "Profile",
        title = "Profile",
        icon = Icons.Default.Settings,
        iconUnselected = Icons.Outlined.Settings,
        resourceIcon = R.drawable.person_fill,
        resourceIconUnselected = R.drawable.person_outlined,
    )
}