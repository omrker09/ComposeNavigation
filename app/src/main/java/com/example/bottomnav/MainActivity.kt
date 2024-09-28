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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.bottomnav.screens.HomeScreen
import com.example.bottomnav.ui.theme.BottomNavTheme
import androidx.navigation.compose.composable

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
                    val durationSpec = 350

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
