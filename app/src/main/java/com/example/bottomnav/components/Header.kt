package com.example.bottomnav.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bottomnav.R
import com.example.bottomnav.ui.theme.LightGrayTheme
import com.example.bottomnav.ui.theme.fedokaFamily

@Composable
fun Header() {
    Box(

    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row (
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.user),
                    contentDescription = "image",
                    modifier = Modifier.size(35.dp)
                )
                Spacer(modifier = Modifier.width(14.dp))
                Column {
                    Text(text = "Welcome back", color = Color.Gray, fontSize = 14.sp, fontFamily = fedokaFamily, fontWeight = FontWeight.SemiBold)
                    Text(text = "Darkos", fontFamily = fedokaFamily, fontWeight = FontWeight.SemiBold)
                }
            }
            Column(
                modifier = Modifier
                    .size(45.dp)  // Ensures width and height are equal for a circular shape
                    .shadow(elevation = 6.dp, shape = CircleShape)
                    .clip(CircleShape)  // Apply CircleShape first for a fully rounded shape
                    .background(LightGrayTheme)  // Then apply the background within the clipped shape
                    .clickable { },

                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Icon(imageVector = Icons.Outlined.Notifications, contentDescription = "notification")
            }
        }
    }
}