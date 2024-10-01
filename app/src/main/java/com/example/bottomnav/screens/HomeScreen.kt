package com.example.bottomnav.screens

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowInsetsControllerCompat
import com.example.bottomnav.R
import com.example.bottomnav.components.Header
import com.example.bottomnav.components.PagerView
import com.example.bottomnav.components.PaymentCard
import com.example.bottomnav.ui.theme.AppSizes
import com.example.bottomnav.ui.theme.BlueTheme
import com.example.bottomnav.ui.theme.LightGrayTheme
import com.example.bottomnav.ui.theme.PurpleTheme
import com.example.bottomnav.ui.theme.WhiteTheme
import com.example.bottomnav.ui.theme.fedokaFamily
import androidx.compose.ui.platform.LocalContext
import com.example.bottomnav.components.Options
import com.example.bottomnav.components.Transaction
import com.example.bottomnav.ui.theme.SemiGrayTheme
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navControllerScreens: NavHostController) {
    val activity = LocalContext.current as Activity
    val window = activity.window
    val insetsController = WindowInsetsControllerCompat(window, window.decorView)
    insetsController.isAppearanceLightStatusBars = true // Light or dark status bar content

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(SemiGrayTheme)  // Make sure WhiteTheme is not hiding the text
            .safeDrawingPadding()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Column (
                modifier = Modifier.padding(AppSizes.appPadding)
            ) {
                Header()  // Assuming Header() is displayed correctly
                Spacer(modifier = Modifier.height(30.dp))
                PagerView()
                Spacer(modifier = Modifier.height(45.dp))
                Options(navControllerScreens)
            }
            Spacer(modifier = Modifier.height(25.dp))
            Transaction()
        }
    }
}

