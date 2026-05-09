package com.example.a211412_danishdanial_nelsonsana_project1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.a211412_danishdanial_nelsonsana_project1.navigation.KasihNavigation
import com.example.a211412_danishdanial_nelsonsana_project1.ui.theme.A211412_NelsonSana_Lab4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            A211412_NelsonSana_Lab4Theme {
                KasihNavigation()
            }
        }
    }
}