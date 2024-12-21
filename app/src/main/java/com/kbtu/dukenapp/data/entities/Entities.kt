package com.kbtu.dukenapp.data.entities


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey val userId: String,
    val username: String,
    val email: String,
    val passwordHash: String
)

@Entity(tableName = "products")
data class Product(
    @PrimaryKey val productId: String,
    val name: String,
    val description: String,
    val price: Double,
    val imageUrl: String,
    val category: String
)

@Entity(tableName = "categories")
data class Category(
    @PrimaryKey val categoryId: String,
    val categoryName: String
)

@Entity(tableName = "orders")
data class Order(
    @PrimaryKey val orderId: String,
    val userId: String,
    val orderDate: String,
    val totalAmount: Double,
    val status: String
)

@Entity(tableName = "order_items")
data class OrderItem(
    @PrimaryKey val orderItemId: String,
    val orderId: String,
    val productId: String,
    val quantity: Int,
    val price: Double,
)

@Entity(tableName = "shopping_cart")
data class ShoppingCart(
    @PrimaryKey val cartId: String,
    val userId: String,
    val createdAt: String
)

@Entity(tableName = "cart_items")
data class CartItem(
    @PrimaryKey val cartItemId: String,
    val cartId: String,
    val productId: String,
    val quantity: Int
)

@Entity(tableName = "reviews")
data class Review(
    @PrimaryKey val reviewId: String,
    val productId: String,
    val userId: String,
    val rating: Float,
    val comment: String,
)

@Entity(tableName = "user_addresses")
data class UserAddress(
    @PrimaryKey val addressId: String,
    val userId: String,
    val street: String,
    val city: String,
    val state: String,
    val zipCode: String
)

@Entity(tableName = "payments")
data class Payment(
    @PrimaryKey val paymentId: String,
    val orderId: String,
    val amount: Double,
    val paymentDate: String,
    val paymentMethod: String
)
