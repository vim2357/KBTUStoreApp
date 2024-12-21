package com.kbtu.dukenapp.presentation.features.checkout


import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.kbtu.dukenapp.presentation.features.cart.CartViewModel

@Composable
fun CheckoutScreen(navController: NavHostController, cartViewModel: CartViewModel) {
    val subtotal = cartViewModel.subtotal.value
    val tax = cartViewModel.tax.value
    val total = cartViewModel.total.value

    Column(modifier = Modifier.fillMaxSize().padding(56.dp)) {
        Text("Checkout", style = androidx.compose.material3.MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))

        Text("Subtotal: $${"%.2f".format(subtotal)}")
        Text("Tax: $${"%.2f".format(tax)}")
        Text("Total: $${"%.2f".format(total)}")

        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = { /* Add order submission logic here */ }) {
            Text("Place Order")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("products") }) {
            Text("Back to Products")
        }
    }
}
