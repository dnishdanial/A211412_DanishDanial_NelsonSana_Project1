package com.example.a211412_danishdanial_nelsonsana_project1.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.a211412_danishdanial_nelsonsana_project1.UserViewModel
import com.example.a211412_danishdanial_nelsonsana_project1.ui.theme.A211412_NelsonSana_Lab4Theme

@Composable
fun BookingScreen(
    navController: NavController,
    foodName: String,
    viewModel: UserViewModel,
    innerPadding: PaddingValues
) {
    var name by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(innerPadding).padding(16.dp)) {
        Text("Booking: $foodName", fontSize = 22.sp)
        Text("Please Enter Collector Name")
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Enter Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                viewModel.addBooking(foodName, name)
                navController.navigate("summary")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Confirm Booking")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BookingScreenPreview() {
    A211412_NelsonSana_Lab4Theme {
        BookingScreen(
            navController = rememberNavController(),
            foodName = "Nasi Lemak",
            viewModel = viewModel(),
            innerPadding = PaddingValues(0.dp)
        )
    }
}
