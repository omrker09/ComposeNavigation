package com.example.bottomnav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.bottomnav.ui.theme.BottomNavTheme
import androidx.navigation.compose.composable
import com.example.bottomnav.screens.MainScreen
import com.example.bottomnav.screens.SecondScreen
import com.example.bottomnav.screens.TransferScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BottomNavTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val durationSpec = 450

                    NavHost(navController = navController, startDestination = "MainScreen") {

                        composable(route = "MainScreen",
                            enterTransition = {
                                slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Start, tween(durationSpec))
                            },
                            exitTransition = {
                                slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Start, tween(durationSpec))

                            },
                            popEnterTransition = {
                                // This is where you avoid animation on going back to Posts
                                slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.End, tween(durationSpec))
                            },
                            popExitTransition = {
                                slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.End, tween(durationSpec))
                            }
                        ) {
                            MainScreen(navController)
                        }
                        composable(route = "TransferScreen",
                            enterTransition = {
                                slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Start, tween(durationSpec))
                            },
                            exitTransition = {
                                slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Start, tween(durationSpec))

                            },
                            popEnterTransition = {
                                // This is where you avoid animation on going back to Posts
                                slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.End, tween(durationSpec))
                            },
                            popExitTransition = {
                                slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.End, tween(durationSpec))
                            }
                        ) {
                            TransferScreen(navController)
                        }
                        composable(route = "SecondScreen",
                            enterTransition = {
                                slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Start, tween(durationSpec))
                            },
                            exitTransition = {
                                slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Start, tween(durationSpec))

                            },
                            popEnterTransition = {
                                // This is where you avoid animation on going back to Posts
                                slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.End, tween(durationSpec))
                            },
                            popExitTransition = {
                                slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.End, tween(durationSpec))
                            }
                        ) {
                            SecondScreen()
                        }
                    }
                }
            }
        }
    }
}
