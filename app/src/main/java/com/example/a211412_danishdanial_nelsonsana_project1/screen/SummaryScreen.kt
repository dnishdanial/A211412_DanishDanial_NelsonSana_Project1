package com.example.a211412_danishdanial_nelsonsana_project1.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.a211412_danishdanial_nelsonsana_project1.UserViewModel
import com.example.a211412_danishdanial_nelsonsana_project1.ui.theme.A211412_NelsonSana_Lab4Theme

@Composable
fun SummaryScreen(navController: NavController, viewModel: UserViewModel, innerPadding: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text("Booking Summary", fontSize = 24.sp)
        }
        
        Spacer(modifier = Modifier.height(16.dp))

        if (viewModel.bookingList.isEmpty()) {
            Text("No bookings yet.")
        } else {
            LazyColumn {
                items(viewModel.bookingList) { booking ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(text = "Food: ${booking.foodName}", style = MaterialTheme.typography.bodyLarge)
                            Text(text = "Name: ${booking.userName}", style = MaterialTheme.typography.bodyMedium)
                            Text(text = "Ref: ${booking.referenceNumber}", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.primary)
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SummaryScreenPreview() {
    A211412_NelsonSana_Lab4Theme {
        SummaryScreen(
            navController = rememberNavController(),
            viewModel = UserViewModel(),
            innerPadding = PaddingValues(0.dp)
        )
    }
}
