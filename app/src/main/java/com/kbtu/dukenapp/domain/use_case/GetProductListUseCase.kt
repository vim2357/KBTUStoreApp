package com.kbtu.dukenapp.domain.use_case

import com.kbtu.dukenapp.domain.repository.OnlineStoreRepository

class GetProductListUseCase(
    private val repository: OnlineStoreRepository
) {
    suspend operator fun invoke() = repository.getProductList()
}