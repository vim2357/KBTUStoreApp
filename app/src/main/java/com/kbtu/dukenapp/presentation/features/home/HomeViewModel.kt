package com.kbtu.dukenapp.presentation.features.home

import androidx.lifecycle.viewModelScope
import com.kbtu.dukenapp.domain.network.toResourceUiState
import com.kbtu.dukenapp.domain.use_case.GetProductListUseCase
import com.kbtu.dukenapp.presentation.model.ResourceUiState
import com.kbtu.dukenapp.presentation.mvi.BaseViewModel
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getProductListUseCase: GetProductListUseCase
) :
    BaseViewModel<HomeContract.State, HomeContract.Event, HomeContract.Effect>() {

    init {
        getProducts()
    }

    override fun createInitialState(): HomeContract.State =
        HomeContract.State(
            productList = ResourceUiState.Idle
        )

    override fun handleEvent(event: HomeContract.Event) {}


    private fun getProducts() {
        setState { copy(productList = ResourceUiState.Loading) }
        viewModelScope.launch {
            val result = getProductListUseCase()
            setState {
                copy(
                    productList = result.toResourceUiState()
                )
            }
        }
    }
}