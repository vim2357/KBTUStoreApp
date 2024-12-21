package com.kbtu.dukenapp.data.model.cart

import com.kbtu.dukenapp.data.model.products.Category
import com.kbtu.dukenapp.data.model.products.Product


data class CartItem(
    val product: Product,
    var quantity: Int
)