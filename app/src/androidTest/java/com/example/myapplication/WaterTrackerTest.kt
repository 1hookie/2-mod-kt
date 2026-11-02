package com.example.myapplication

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.myapplication.ui.theme.MyApplicationTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

// Задание 9
class WaterTrackerTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            MyApplicationTheme {
                WaterTracker()
            }
        }
    }

    private fun addWater(times: Int) {
        repeat(times) { composeTestRule.onNodeWithText("+250 мл").performClick() }
    }

    // 1) Кнопка добавления жидкости есть и увеличивает счётчик на 250 мл
    @Test
    fun addWaterButton_increasesCount() {
        composeTestRule.onNodeWithText("+250 мл").assertIsDisplayed()
        composeTestRule.onNodeWithText("0 мл").assertIsDisplayed()

        addWater(1)
        composeTestRule.onNodeWithText("250 мл").assertIsDisplayed()

        addWater(2)
        composeTestRule.onNodeWithText("750 мл").assertIsDisplayed()
    }

    // 2) Кнопка «Завершить день» есть и сбрасывает счётчик воды до нуля
    @Test
    fun finishDayButton_resetsWaterCount() {
        composeTestRule.onNodeWithText("Завершить день").assertIsDisplayed()

        addWater(3)
        composeTestRule.onNodeWithText("750 мл").assertIsDisplayed()

        composeTestRule.onNodeWithText("Завершить день").performClick()
        composeTestRule.onNodeWithText("0 мл").assertIsDisplayed()
    }

    // 3) Текст с количеством дней подряд с нормой 1500 мл и больше
    @Test
    fun daysCounter_displaysCorrectValue() {
        composeTestRule.onNodeWithText("Дней подряд (1500 мл и больше): 0").assertIsDisplayed()

        // День с нормой — счётчик увеличивается
        addWater(6)
        composeTestRule.onNodeWithText("Завершить день").performClick()
        composeTestRule.onNodeWithText("Дней подряд (1500 мл и больше): 1").assertIsDisplayed()

        // Ещё один день с нормой
        addWater(7)
        composeTestRule.onNodeWithText("Завершить день").performClick()
        composeTestRule.onNodeWithText("Дней подряд (1500 мл и больше): 2").assertIsDisplayed()

        // День без нормы — счётчик обнуляется
        addWater(2)
        composeTestRule.onNodeWithText("Завершить день").performClick()
        composeTestRule.onNodeWithText("Дней подряд (1500 мл и больше): 0").assertIsDisplayed()
    }
}
