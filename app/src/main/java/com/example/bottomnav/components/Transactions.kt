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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bottomnav.ui.theme.AppSizes
import com.example.bottomnav.ui.theme.BlueTheme
import com.example.bottomnav.ui.theme.LightGrayTheme
import com.example.bottomnav.ui.theme.WhiteTheme
import com.example.bottomnav.ui.theme.fedokaFamily
import com.example.bottomnav.R
import com.example.bottomnav.ui.theme.DarkGreen

@Composable
fun Transaction() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
            .background(WhiteTheme)
            .padding(vertical = AppSizes.appPadding)

    ) {
        Column {
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .height(5.dp)
                        .width(40.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.Gray)
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Column {
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = AppSizes.appPadding)
                    ,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Transactions", fontFamily = fedokaFamily, fontWeight = FontWeight.SemiBold, fontSize = 17.sp)
                    Box(
                        modifier = Modifier.clickable {  }
                    ) {
                        Text(text = "See all", color = BlueTheme, fontFamily = fedokaFamily, fontWeight = FontWeight.SemiBold)
                    }

                }
                Spacer(modifier = Modifier.height(15.dp))

                LazyColumn (
                    modifier = Modifier.weight(1f) // Allow LazyColumn to take the remaining space

                ) {
                    items(4) {index ->
                        TransactionItem(
                            painterResource(id = R.drawable.netflix),
                            "Netflix 30 Days",
                            "Yesterday, 1:35 PM",
                            "-$30.00"
                        )
                        TransactionItem(
                            painterResource(id = R.drawable.spotify),
                            "Spotify",
                            "Today, 5:01 PM",
                            "+$123.00"
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun TransactionItem(
    painter: Painter,
    transactionTitle: String,
    transactionDate: String,
    amount: String,
) {
    var isMinus by remember { mutableStateOf(false)}

    LaunchedEffect(Unit) {
        if (amount.contains("-")) {
            isMinus = true
        } else {
            isMinus = false
        }
    }

    Box(
        modifier = Modifier
            .clickable { }
            .padding(horizontal = AppSizes.appPadding, vertical = 10.dp)
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row (
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painter,
                    contentDescription = "image icon",
                    modifier = Modifier.size(40.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(text = transactionTitle, fontSize = 15.sp, fontFamily = fedokaFamily, fontWeight = FontWeight.SemiBold)
                    Text(text = transactionDate , color = Color.Gray, fontSize = 13.sp, fontFamily = fedokaFamily, fontWeight = FontWeight.SemiBold)
                }
            }
            Text(text = amount, color = if (isMinus) Color.Red else DarkGreen, fontSize = 15.sp, fontFamily = fedokaFamily, fontWeight = FontWeight.SemiBold)
        }
    }
}