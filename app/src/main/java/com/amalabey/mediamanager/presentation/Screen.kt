package com.amalabey.mediamanager.presentation

sealed class Screen(val route: String) {
    object MediaSearchScreen: Screen(route = "media_search_screen")
}