package com.kata.bowling.kotlin

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {

    @Suppress("unused")
    @get:Rule
    val instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MainViewModel

    @Before
    @Throws(Exception::class)
    fun setup() {
        viewModel = MainViewModel()
    }

    // TODO - Remove
    @Test
    fun `when 9 is pressed, result equals 9`() {
        // Given
        val amount = 9

        // When
        viewModel.addRollToRollLine("9")

        // Then
        assertEquals("$amount", viewModel.getDisplayText().value)
    }
}