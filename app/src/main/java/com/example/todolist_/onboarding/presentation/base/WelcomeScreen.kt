package com.example.todolist_.onboarding.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition


@Composable
fun Welcome_Screen(navController:NavController) {
rememberNavController()
    Column(
        modifier = Modifier
            .fillMaxSize(),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

        ) {
        Text(
            text = "todo|list",
            fontWeight = FontWeight.ExtraBold,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.End,

            )
        val composition by rememberLottieComposition(spec = LottieCompositionSpec.Url("https://assets5.lottiefiles.com/packages/lf20_z4cshyhf.json"))
        LottieAnimation(composition = composition, iterations = LottieConstants.IterateForever)



            Button(onClick = { navController.navigate("add_card_screen") }) {


                Icon(
                    modifier = Modifier.size(50.dp),
                    imageVector = Icons.Default.Home,
                    contentDescription = "",


                    )
            }


    }


}




