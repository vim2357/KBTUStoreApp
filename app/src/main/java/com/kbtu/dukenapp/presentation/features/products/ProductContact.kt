package com.kbtu.dukenapp.presentation.features.products

sealed class ProductContract {
    data class UiState(val products: List<String>)

    sealed class Event {
        data class AddToCart(val productName: String) : Event()
        data class RemoveFromCart(val productName: String) : Event()
    }
}
