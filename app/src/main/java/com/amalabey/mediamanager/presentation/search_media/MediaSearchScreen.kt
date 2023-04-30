package com.amalabey.mediamanager.presentation.search_media

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.amalabey.mediamanager.presentation.faker.FakeViewModelProvider
import com.amalabey.mediamanager.presentation.search_media.components.MediaResultItem
import com.amalabey.mediamanager.ui.theme.MediaManagerTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MediaSearchScreen(
    navController: NavController,
    viewModel: SearchMediaViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Row(modifier = Modifier
        .fillMaxWidth()
    ) {
        TextField(
            value = viewModel.state.value.keyword,
            onValueChange = { it ->
                viewModel.onKeywordTextChanged(it)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
                .border(width = 1.dp, color = Color.Blue),
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon"
                )
            }
        )
    }
    LazyColumn(modifier = Modifier
        .fillMaxHeight()
    ){
        items(state.results){ result ->
            MediaResultItem(mediaItem = result, onItemClick = {})
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun MediaSearchScreenPreviewLight() {
    MediaManagerTheme {
        MediaSearchScreen(rememberNavController(), FakeViewModelProvider.provideSearchMediaViewModel())
    }
}