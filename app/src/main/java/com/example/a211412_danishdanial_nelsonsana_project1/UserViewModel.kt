package com.example.a211412_danishdanial_nelsonsana_project1

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

// Data Class
data class UserProfile(
    val name: String = "User",
    val rescuedMeals: Int = 5,
    val profileImage: Int = R.drawable.pp,
    val isVerified: Boolean = false
)

data class Booking(val foodName: String, val userName: String, val referenceNumber: String)

// ViewModel
class UserViewModel : ViewModel() {
    var userState by mutableStateOf(UserProfile())
        private set

    var bookingList by mutableStateOf(listOf<Booking>())
        private set

    fun updateName(newName: String) {
        userState = userState.copy(name = newName, isVerified = true)
    }

    fun addBooking(food: String, name: String) {
        val refNum = (100000..999999).random().toString()
        bookingList = bookingList + Booking(food, name, "REF$refNum")
    }
}
