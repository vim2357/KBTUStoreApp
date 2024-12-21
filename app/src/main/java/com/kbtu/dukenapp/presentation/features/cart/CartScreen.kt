package com.kbtu.dukenapp.presentation.features.cart

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.kbtu.dukenapp.presentation.features.products.ProductViewModel

@Composable
fun CartScreen(navController: NavHostController, cartViewModel: CartViewModel) {
    val cartItems = cartViewModel.cartItems
    val subtotal = cartViewModel.subtotal.value
    val tax = cartViewModel.tax.value
    val total = cartViewModel.total.value

    Column(modifier = Modifier.fillMaxSize().padding(56.dp)) {
        Text("Cart", style = androidx.compose.material3.MaterialTheme.typography.headlineSmall)

        if (cartItems.isEmpty()) {
            Text("Your cart is empty")
        } else {
            cartItems.forEach { item ->
                Row(modifier = Modifier.padding(8.dp)) {
                    Text("${item.product.name} x${item.quantity}", modifier = Modifier.weight(1f))
                    Button(onClick = { cartViewModel.removeFromCart(item.product) }) {
                        Text("Remove")
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text("Subtotal: $${"%.2f".format(subtotal)}")
            Text("Tax: $${"%.2f".format(tax)}")
            Text("Total: $${"%.2f".format(total)}")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("checkout") }) {
            Text("Proceed to Checkout")
        }
    }
}
