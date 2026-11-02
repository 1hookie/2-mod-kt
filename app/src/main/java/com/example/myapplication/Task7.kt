package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class Contact(
    val name: String,
    val patronymic: String,
    val surname: String,
    val phone: String?,
    val address: String
)

val contacts = listOf(
    Contact("Евгений", "Андреевич", "Лукашин", "+7 495 495 95 95", "г. Москва, 3-я улица Строителей, д. 25, кв. 12"),
    Contact("Василий", "Егорович", "Кузякин", null, "Ивановская область, дер. Крутово, д. 4"),
    Contact("Людмила", "Прокофьевна", "Калугина", "+7 495 788 78 78", "Москва, Большая Никитская, д. 43, кв. 290")
)

// Задание 7, Column — первое изображение
@Composable
fun ContactColumn(contact: Contact, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text("Имя: ${contact.name}")
        Text("Отчество: ${contact.patronymic}")
        Text("Фамилия: ${contact.surname}")
        Text("Мобильный телефон: ${contact.phone ?: "---"}")
        Text("Адрес: ${contact.address}")
    }
}

// список карточек
@Composable
fun ContactCard(contact: Contact) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.LightGray)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Имя: ${contact.name}")
        Text("Отчество: ${contact.patronymic}")
        Text("Фамилия: ${contact.surname}")
        Text("Мобильный телефон: ${contact.phone ?: "---"}")
        Text("Адрес: ${contact.address}")
    }
}

@Composable
fun ContactList() {
    Column(modifier = Modifier.padding(8.dp)) {
        contacts.forEach { ContactCard(it) }
    }
}

// row - карточка с изображением справа
@Composable
fun ContactRow(contact: Contact) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.LightGray)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Имя: ${contact.name}")
            Text("Отчество: ${contact.patronymic}")
            Text("Фамилия: ${contact.surname}")
            Text("Мобильный телефон: ${contact.phone ?: "---"}")
            Text("Адрес: ${contact.address}")
        }
        Image(
            painter = painterResource(android.R.drawable.btn_star_big_on),
            contentDescription = null
        )
    }
}

@Preview(name = "portrait", showSystemUi = true)
@Composable
fun ContactColumnPreview() {
    ContactColumn(contacts[0])
}

@Preview(name = "portrait", showSystemUi = true)
@Composable
fun ListPreview() {
    ContactList()
}

@Preview(name = "portrait", showSystemUi = true)
@Composable
fun ContactRowPreview() {
    ContactRow(contacts[0])
}
