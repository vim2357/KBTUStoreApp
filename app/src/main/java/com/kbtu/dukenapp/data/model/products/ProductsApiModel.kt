package com.kbtu.dukenapp.data.model.products

import com.google.gson.annotations.SerializedName


data class ProductsApiModel(
    @SerializedName("products")
    val products: List<ProductItemApiModel>?, // Matches "products" in the JSON response
)