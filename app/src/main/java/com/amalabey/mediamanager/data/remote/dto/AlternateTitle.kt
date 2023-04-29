package com.amalabey.mediamanager.data.remote.dto

data class AlternateTitle(
    val language: Language,
    val movieId: Int,
    val sourceId: Int,
    val sourceType: String,
    val title: String,
    val voteCount: Int,
    val votes: Int
)