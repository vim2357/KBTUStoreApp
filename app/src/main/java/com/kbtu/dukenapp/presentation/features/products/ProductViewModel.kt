package com.kbtu.dukenapp.presentation.features.products

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch



class ProductViewModel : ViewModel() {
    private val _uiState = MutableLiveData(ProductContract.UiState(products = listOf(
        "Smartphone", "Laptop", "Headphones", "Coffee Maker", "Fitness Tracker"
    )))
    val uiState: LiveData<ProductContract.UiState> = _uiState

    private val _cartState = MutableLiveData<MutableMap<String, Int>>(mutableMapOf())
    val cartState: MutableLiveData<MutableMap<String, Int>> = _cartState

    fun onEvent(event: ProductContract.Event) {
        when (event) {
            is ProductContract.Event.AddToCart -> addToCart(event.productName)
            is ProductContract.Event.RemoveFromCart -> removeFromCart(event.productName)
        }
    }

    private fun addToCart(productName: String) {
        val cart = _cartState.value ?: mutableMapOf()
        cart[productName] = cart.getOrDefault(productName, 0) + 1
        _cartState.value = cart
    }

    private fun removeFromCart(productName: String) {
        val cart = _cartState.value ?: mutableMapOf()
        if (cart.containsKey(productName)) {
            if (cart[productName]!! > 1) {
                cart[productName] = cart[productName]!! - 1
            } else {
                cart.remove(productName)
            }
        }
        _cartState.value = cart
    }
}
