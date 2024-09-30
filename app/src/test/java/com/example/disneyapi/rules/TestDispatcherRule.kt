package com.example.disneyapi.rules

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class TestDispatcherRule(
    private val testDispatcher: StandardTestDispatcher = StandardTestDispatcher()
) : TestRule {
    override fun apply(base: Statement, description: Description): Statement {
        return object : Statement() {
            override fun evaluate() {
                Dispatchers.setMain(testDispatcher) // Establece el dispatcher de prueba como el principal
                try {
                    base.evaluate() // Ejecuta la prueba
                } finally {
                    Dispatchers.resetMain() // Restablece el dispatcher principal original
                }
            }
        }
    }
}
