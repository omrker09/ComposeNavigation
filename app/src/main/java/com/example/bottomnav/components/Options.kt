package com.example.bottomnav.components

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.bottomnav.ui.theme.LightGrayTheme
import com.example.bottomnav.R
import com.example.bottomnav.ui.theme.fedokaFamily

@Composable
fun Options(navControllerScreens: NavHostController) {

    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        OptionsCard(painterParam = painterResource(id = R.drawable.transfer),
            title = "Transfer",
            onClick = { ->
                navControllerScreens.navigate("TransferScreen")
            }
            )
        OptionsCard(painterParam = painterResource(id = R.drawable.qr_code_scanner), title = "QR Code")
        OptionsCard(
            painterParam = painterResource(id = R.drawable.credit_card),
            title = "Payment",
            onClick = { ->
                navControllerScreens.navigate("TransferScreen")
            }
            )
        OptionsCard(painterParam = painterResource(id = R.drawable.token_nft), title = "NFT")
    }
}

@Composable
fun OptionsCard(
    painterParam: Painter,
    title: String,
    onClick: () -> Unit = {}
) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .height(55.dp)
                .width(55.dp)
                .shadow(elevation = 2.dp, shape = CircleShape)
                .clip(CircleShape)
                .background(LightGrayTheme)
                .clickable {
                    onClick()
                },

        ) {
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape)
                    .background(LightGrayTheme),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterParam,
                    contentDescription = "Transfer icon",
                    modifier = Modifier.size(35.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = title, fontFamily = fedokaFamily, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
    }
}