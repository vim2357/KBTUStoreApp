package com.kbtu.dukenapp.presentation.features.main.navigation


import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kbtu.dukenapp.presentation.features.cart.CartScreen
import com.kbtu.dukenapp.presentation.features.cart.CartViewModel
import com.kbtu.dukenapp.presentation.features.checkout.CheckoutScreen
import com.kbtu.dukenapp.presentation.features.home.HomeScreen
import com.kbtu.dukenapp.presentation.features.products.ProductScreen
//import com.kbtu.dukenapp.presentation.products.ProductScreen

//import com.kbtu.dukenapp.presentation.features.products.

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val cartViewModel = CartViewModel()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Shopping App") })
        }
    ) {
        NavHost(navController = navController, startDestination = "products") {
            composable(route = "products") {
                ProductScreen(navController = navController, cartViewModel = cartViewModel)
            }
            composable(route = "cart") {
                CartScreen(navController = navController, cartViewModel = cartViewModel)
            }
            composable(route = "checkout") {
                CheckoutScreen(navController = navController, cartViewModel = cartViewModel)
            }
        }
    }
}
