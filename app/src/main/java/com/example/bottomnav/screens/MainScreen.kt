package com.example.bottomnav.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.example.bottomnav.utils.BottomBarClass
import com.example.bottomnav.BottomNavGraph
import com.example.bottomnav.ui.theme.BottomBarSeparator
import com.example.bottomnav.ui.theme.WhiteTheme
import com.example.bottomnav.ui.theme.fedokaFamily

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(
    navControllerScreens: NavHostController
) {
    val navController = rememberNavController()
    Scaffold (
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) {
        BottomNavGraph(navController = navController, navControllerScreens = navControllerScreens)
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarClass.Home,
        BottomBarClass.Profile,
        BottomBarClass.Settings
    )
    val navBackStack by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStack?.destination

    BottomAppBar (
        modifier = Modifier.clipToBounds()
            .border(
                width = 1.dp,            // Set the border width
                color = BottomBarSeparator,       // Set the border color
                shape = RectangleShape    // Shape of the border (rectangle by default)
            )
        ,
        containerColor = WhiteTheme
    ) {
        screens.forEach { screen ->
            AddItem(screen = screen, currentDestination = currentDestination, navController = navController )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarClass,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    val isSelected = currentDestination?.hierarchy?.any {
        it.route == screen.route
    } == true
    BottomNavigationItem(

        icon = {
               Column (
                   modifier = Modifier.fillMaxSize(),
                   verticalArrangement = Arrangement.Center,
                   horizontalAlignment = Alignment.CenterHorizontally

               ) {

                   Icon(painter = painterResource(id = if (isSelected) screen.resourceIcon else screen.resourceIconUnselected), contentDescription = "icon")
                   Text(text = screen.title, color = if (isSelected) Color.Black else Color.Gray, fontFamily = fedokaFamily, fontWeight = FontWeight.SemiBold)
               }
        },
        selected = isSelected,
        onClick = {
            navController.navigate(screen.route)
        },
        selectedContentColor = Color.Black,
        unselectedContentColor = Color.Gray
    )
}