package com.kbtu.dukenapp.data.api

import com.kbtu.dukenapp.data.model.products.ProductsApiModel
import retrofit2.http.GET

interface OnlineStoreService {

    @GET("69252c19-0085-4a44-87a5-85b073f15aef")
    suspend fun getProductList(): ProductsApiModel
}
