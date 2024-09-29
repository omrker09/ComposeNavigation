package com.example.bottomnav.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bottomnav.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)

object AppSizes {
    val appPadding = 20.dp
}

val fedokaFamily = FontFamily(
    Font(R.font.fredoka_bold, FontWeight.Bold),
    Font(R.font.fredoka_light, FontWeight.Light),
    Font(R.font.fredoka_medium, FontWeight.Medium),
    Font(R.font.fredoka_regular, FontWeight.Normal),
    Font(R.font.fredoka_semi_bold, FontWeight.SemiBold),
)