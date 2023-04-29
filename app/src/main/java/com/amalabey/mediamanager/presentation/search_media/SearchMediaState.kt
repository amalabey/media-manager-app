package com.amalabey.mediamanager.presentation.search_media

import com.amalabey.mediamanager.domain.model.Media

data class SearchMediaState(
    val isLoading: Boolean = false,
    val keyword: String = "",
    val results: List<Media> = emptyList(),
    val error: String = ""
)
