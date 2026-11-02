package com.example.myapplication

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.random.Random

// Задание 10
data class Cart(
    val products: List<Product>
)

data class Product(
    val id: Int,
    val name: String,
    val price: Int
)

@Composable
fun ShoppingCartScreen() {
    val context = LocalContext.current
    var products by remember {
        mutableStateOf(
            listOf(
                Product(0, "Товар #1", 100),
                Product(1, "Товар #2", 150),
                Product(2, "Товар #3", 56)
            )
        )
    }
    // исправлено
    val totalSum = products.sumOf { it.price }

    Column {
        for (product in products) {
            Text(text = product.name + " - " + product.price + " рублей")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Товаров на сумму: $totalSum рублей")
        AddProductSection {
            products = products + Product(
                id = products.size,
                name = "Товар #${products.size + 1}",
                price = Random.nextInt(0, 100)
            )
            if (products.sumOf { it.price } > 500) {
                Toast.makeText(context, "Доставка бесплатная!", Toast.LENGTH_SHORT).show()
            }
        }
        RemoveProductSection(productSize = products.size) {
            products = products.dropLast(1)
        }
    }
}

@Composable
fun AddProductSection(
    onAdd: () -> Unit
) {
    Button(onClick = onAdd) {
        Text(text = "Добавить товар")
    }
}

@Composable
fun RemoveProductSection(
    productSize: Int,
    onRemove: () -> Unit
) {
    if (productSize > 0) {
        Button(onClick = onRemove) {
            Text(text = "Удалить товар")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ShoppingCartPreview() {
    ShoppingCartScreen()
}
