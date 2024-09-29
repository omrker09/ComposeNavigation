package com.example.bottomnav.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bottomnav.R
import com.example.bottomnav.ui.theme.PurpleTheme
import com.example.bottomnav.ui.theme.fedokaFamily

@Composable
fun PaymentCard(painter: Painter, cardNumber: String, balance: String, expireDate: String, backGroundColor: Color) {
    Box(
        modifier = Modifier
            //.size(45.dp)  // Ensures width and height are equal for a circular shape

            .clip(RoundedCornerShape(20.dp))
            .fillMaxWidth()
            // Increased height to make it more visible
            .background(backGroundColor)  // Ensure background color is visible

            .clickable { },  // Click action
    ) {
        Column(
            modifier = Modifier.padding(15.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painter,
                contentDescription = "image",
                modifier = Modifier.size(60.dp)
            )
            Text(text = cardNumber, color = androidx.compose.ui.graphics.Color.LightGray, fontFamily = fedokaFamily, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = balance, color = androidx.compose.ui.graphics.Color.White, fontSize = 20.sp, fontFamily = fedokaFamily, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = expireDate, color = androidx.compose.ui.graphics.Color.LightGray, fontSize = 14.sp, fontFamily = fedokaFamily, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(7.dp))
        }
    }
}