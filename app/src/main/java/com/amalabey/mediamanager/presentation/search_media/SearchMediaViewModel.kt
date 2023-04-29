package com.amalabey.mediamanager.presentation.search_media

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amalabey.mediamanager.common.Resource
import com.amalabey.mediamanager.domain.use_case.search_media.SearchMediaUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SearchMediaViewModel @Inject constructor(
    private val searchMediaUseCase: SearchMediaUseCase
): ViewModel() {
    private val _state = mutableStateOf(SearchMediaState())
    val state: State<SearchMediaState> = _state

    fun invokeSearch() {
        searchMediaUseCase(_state.value.keyword).onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = SearchMediaState(keyword = _state.value.keyword,
                        results = result.data ?: emptyList()
                    )
                }
                is Resource.Error -> {
                    _state.value = SearchMediaState(keyword =  _state.value.keyword,
                        error =  result.message ?: "Unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _state.value = SearchMediaState(keyword = _state.value.keyword,
                        isLoading = true
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}