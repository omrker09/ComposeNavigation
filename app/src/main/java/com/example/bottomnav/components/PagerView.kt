package com.example.bottomnav.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.bottomnav.R
import com.example.bottomnav.ui.theme.BlueTheme
import com.example.bottomnav.ui.theme.PurpleTheme

@Composable
fun PagerView() {
    val pagerState = rememberPagerState(pageCount = {
        2
    })

    Column {
        HorizontalPager(
            state = pagerState,
            pageSpacing = 10.dp
        ) { page ->
            // Our page content
            when (page) {
                0 -> {
                    PaymentCard(
                        painter = painterResource(id = R.drawable.visa),
                        cardNumber = "**** **** **** 0456",
                        balance = "1650$",
                        expireDate = "Exp: 04/26",
                        backGroundColor = PurpleTheme
                    )
                }
                1 -> {
                    PaymentCard(
                        painter = painterResource(id = R.drawable.master_card),
                        cardNumber = "**** **** **** 1646",
                        balance = "4214$",
                        expireDate = "Exp: 11/27",
                        backGroundColor = BlueTheme
                    )
                }
                1 -> {
                    PaymentCard(
                        painter = painterResource(id = R.drawable.master_card),
                        cardNumber = "**** **** **** 1646",
                        balance = "4214$",
                        expireDate = "Exp: 11/27",
                        backGroundColor = BlueTheme
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            for (i in 0 until pagerState.pageCount) {
                Box(modifier = Modifier
                    .height(8.dp)
                    .width(15.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(if (i == pagerState.currentPage) Color.Gray else Color.LightGray)

                )
                Spacer(modifier = Modifier.width(5.dp))
            }
        }
    }
}
