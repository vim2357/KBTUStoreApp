package com.kbtu.dukenapp.presentation.features.products

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.kbtu.dukenapp.data.model.products.Product
import com.kbtu.dukenapp.presentation.features.cart.CartViewModel

//
// rt com.kbtu.dukenapp.presentation.features.products.model.Product

//@Composable
//fun ProductScreen(navController: NavHostController, viewModel: ProductViewModel = viewModel()) {
//    val products = listOf(
//        Product(1, "Smartphone", "Latest model smartphone with advanced features", 699.99, "https://example.com/images/smartphone.png", "Electronics"),
//        Product(2, "Laptop", "High-performance laptop for gaming and work", 1299.99, "https://example.com/images/laptop.png", "Electronics"),
//        Product(3, "Headphones", "Noise-cancelling over-ear headphones", 199.99, "https://example.com/images/headphones.png", "Accessories"),
//        Product(4, "Coffee Maker", "Automatic coffee maker with timer", 89.99, "https://example.com/images/coffeemaker.png", "Home Appliances"),
//        Product(5, "Fitness Tracker", "Waterproof fitness tracker with heart rate monitor", 49.99, "https://example.com/images/fitnesstracker.png", "Wearables")
//    )
//
//    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
//        Text(
//            "Shopping App",
//            style = MaterialTheme.typography.headlineSmall,
//            modifier = Modifier.padding(bottom = 16.dp)
//        )
//
//        products.forEach { product ->
//            ProductCard(product = product, onAddToCart = {
//                viewModel.onEvent(ProductContract.Event.AddToCart(product.name))
//            })
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//        Button(onClick = { navController.navigate("cart") }) {
//            Text("Go to Cart")
//        }
//    }
//}

@Composable
fun ProductScreen(navController: NavHostController, cartViewModel: CartViewModel) {

    val products = listOf(
        Product("1", "Smartphone", "Latest model smartphone with advanced features", 699.99, "Electronics"),
        Product("2", "Laptop", "High-performance laptop for gaming and work", 1299.99,  "Electronics"),
        Product("3", "Headphones", "Noise-cancelling over-ear headphones", 199.99,  "Accessories"),
        Product("4", "Coffee Maker", "Automatic coffee maker with timer", 89.99,  "Home Appliances"),
        Product("5", "Fitness Tracker", "Waterproof fitness tracker with heart rate monitor", 49.99, "Wearables")
    )

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Products", style = MaterialTheme.typography.headlineSmall)

        products.forEach { product ->
            ProductCard(product = product, onAddToCart = {
                cartViewModel.addToCart(product)
            })
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("cart") }) {
            Text("Go to Cart")
        }
    }
}


@Composable
fun ProductCard(product: Product, onAddToCart: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(8.dp),
//        elevation = 4.dp // Изменённый параметр
    ) {
        Row(modifier = Modifier.padding(20.dp)) {
//            Image(
//                painter = rememberAsyncImagePainter(product.imageUrl),
//                contentDescription = product.name,
//                modifier = Modifier
//                    .size(64.dp)
//                    .padding(end = 16.dp),
//                contentScale = ContentScale.Crop
//            )


            Column(modifier = Modifier.weight(1f)) {
                Text(text = product.name, style = MaterialTheme.typography.bodyLarge)
                Text(text = product.description, style = MaterialTheme.typography.bodySmall)
                Text(text = "$${product.price}", style = MaterialTheme.typography.bodyMedium)
            }

            Button(onClick = onAddToCart) {
                Text("Add to Cart")
            }
        }
    }
}