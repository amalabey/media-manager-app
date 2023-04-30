package com.amalabey.mediamanager.presentation.search_media.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.amalabey.mediamanager.domain.model.Media

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MediaResultItem(
    mediaItem: Media,
    onItemClick: (Media) -> Unit
) {
    ListItem(
        headlineText = { Text(mediaItem.title) },
        supportingText = { Text(mediaItem.description ?: "") }
    )
}