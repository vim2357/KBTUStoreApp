package com.kbtu.dukenapp.presentation.features.cart

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.kbtu.dukenapp.data.model.cart.CartItem
import com.kbtu.dukenapp.data.model.products.Product

class CartViewModel : ViewModel() {
    private val _cartItems = mutableStateListOf<CartItem>()
    val cartItems: List<CartItem> get() = _cartItems

    val subtotal = mutableStateOf(0.0)
    val tax = mutableStateOf(0.0)
    val total = mutableStateOf(0.0)

    fun addToCart(product: Product) {
        val existingItem = _cartItems.find { it.product.productId == product.productId }
        if (existingItem != null) {
            existingItem.quantity++
        } else {
            _cartItems.add(CartItem(product, 1))
        }
        calculateTotals()
    }

    fun updateQuantity(productId: String, quantity: Int) {
        _cartItems.find { it.product.productId == productId }?.let {
            if (quantity > 0) {
                it.quantity = quantity
            } else {
                _cartItems.remove(it)
            }
        }
        calculateTotals()
    }

    fun clearCart() {
        _cartItems.clear()
        calculateTotals()
    }

    private fun calculateTotals() {
        subtotal.value = _cartItems.sumOf { it.product.price * it.quantity }
        tax.value = subtotal.value * 0.1 // Assuming a 10% tax rate
        total.value = subtotal.value + tax.value
    }

    fun removeFromCart(product: Product) {

    }
}
