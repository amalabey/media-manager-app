package com.amalabey.mediamanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.amalabey.mediamanager.presentation.Screen
import com.amalabey.mediamanager.presentation.search_media.MediaSearchScreen
import com.amalabey.mediamanager.ui.theme.MediaManagerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MediaManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.MediaSearchScreen.route
                    ) {
                        composable(
                            route = Screen.MediaSearchScreen.route
                        ){
                            MediaSearchScreen(navController = navController)
                        }                        
                    }
                }
            }
        }
    }
}