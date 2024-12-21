package com.kbtu.dukenapp.data.model.products

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Product(
    @PrimaryKey val productId: String,
    val name: String,
    val description: String,
    val price: Double,
    val category: String
)

@Entity(tableName = "category")
data class Category(
    @PrimaryKey val categoryId: String,
    val categoryName: String
)


