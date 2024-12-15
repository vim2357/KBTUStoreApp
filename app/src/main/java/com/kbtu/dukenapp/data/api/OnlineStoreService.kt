package com.kbtu.dukenapp.data.api

import com.kbtu.dukenapp.data.model.products.ProductsApiModel
import retrofit2.http.GET

interface OnlineStoreService {

    @GET("6719602b-11ae-43ae-bc30-78cd1d930714")
    suspend fun getProductList(): ProductsApiModel
}