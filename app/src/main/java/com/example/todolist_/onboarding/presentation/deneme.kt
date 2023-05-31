@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.todolist_.onboarding.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource
@Composable
fun den() {
   Card(modifier = Modifier.padding(all = 30.dp)
          ,
       colors = CardDefaults.cardColors(
           containerColor = MaterialTheme.colorScheme.primary,
       ),
       shape = MaterialTheme.shapes.large,) {
       Column(horizontalAlignment = Alignment.CenterHorizontally) {
       Text(
           text = "Title",
           style = MaterialTheme.typography.titleLarge,
           color = MaterialTheme.colorScheme.onSurface
       )
           Column(modifier = Modifier.padding(16.dp)) {
               Text(
                   text = "",
                   style = MaterialTheme.typography.bodyLarge,
                   color = MaterialTheme.colorScheme.primary
               )
           }

   }
       
   }
}
@Preview
@Composable
fun CardElevation() {
 
    Surface(
        shape = RoundedCornerShape(16.dp),
        color = Color(0xFFDAE1E7),
        modifier = Modifier
            .height(210.dp)
            .padding(10.dp),
        shadowElevation = 10.dp
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(2f),
                verticalArrangement = Arrangement.Center
            ) {
                Surface(
                    shape = RoundedCornerShape(24.dp),
                    modifier = Modifier.wrapContentSize(),
                    color = Color(0xFFD1D5E1)
                ) {
                    Text(
                        text = "New release",
                        fontSize =  12.sp,
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Gift Plant",
                    fontSize =  24.sp,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text(text = "Price : 300$")

                Spacer(modifier = Modifier.height(2.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "4.0",
                        fontSize =  14.sp,
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.titleLarge
                    )
                    Spacer(modifier = Modifier.width(4.dp))


                }

                Spacer(modifier = Modifier.height(4.dp))

                OutlinedButton(
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Black,
                        containerColor = Color.White
                    ),
                    onClick = { /*TODO*/ }
                ) {
                    Text(
                        text = "Read More",
                        fontSize =  11.sp,
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }

            Surface(
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.size(width = 100.dp, height = 140.dp)
            ) {
                //image
            }
        }
    }
}
/*

Column(
modifier = Modifier
.padding(16.dp)
.fillMaxWidth()
) {
    OutlinedTextField(modifier = Modifier.padding(20.dp),
        value = title,
        onValueChange = { title = it },
        label = { Text("Konu", color = Color.DarkGray) })
    OutlinedTextField(modifier = Modifier.padding(20.dp),
        value = content,
        onValueChange = { content = it },
        label = { Text(text = "İçerik", color = Color.DarkGray) })
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 30.dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Bottom,
        ) {

            FloatingActionButton(modifier = Modifier
                .size(width = 110.dp, height = 110.dp),
                onClick = {

                }) {
                Image(
                    modifier = Modifier.size(110.dp, 110.dp),
                    painter = painterResource(id = com.example.todolist_.R.drawable.rese),
                    contentDescription = ""
                )
            }
        }
    }
}
} */