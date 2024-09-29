package com.example.bottomnav.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import com.example.bottomnav.R
import com.example.bottomnav.components.Header
import com.example.bottomnav.components.PaymentCard
import com.example.bottomnav.ui.theme.AppSizes
import com.example.bottomnav.ui.theme.BlueTheme
import com.example.bottomnav.ui.theme.LightGrayTheme
import com.example.bottomnav.ui.theme.PurpleTheme
import com.example.bottomnav.ui.theme.WhiteTheme
import com.example.bottomnav.ui.theme.fedokaFamily

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(AppSizes.appPadding)
            .background(WhiteTheme)  // Make sure WhiteTheme is not hiding the text
            .safeDrawingPadding()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Header()  // Assuming Header() is displayed correctly
            Spacer(modifier = Modifier.height(30.dp))
            PaymentCard(
                painterResource(id = R.drawable.visa),
                cardNumber = "**** **** **** 0456",
                balance = "1650$",
                expireDate = "Exp: 04/26",
                backGroundColor = PurpleTheme
            )
            Spacer(modifier = Modifier.height(20.dp))
            PaymentCard(
                painterResource(id = R.drawable.master_card),
                cardNumber = "**** **** **** 1646",
                balance = "4214$",
                expireDate = "Exp: 11/27",
                backGroundColor = BlueTheme
            )
        }
    }
}

