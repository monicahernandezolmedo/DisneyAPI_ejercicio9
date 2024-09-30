package com.example.disneyapi
import com.example.disneyapi.rules.TestDispatcherRule
import com.example.disneyapi.viewmodel.DisneyUiState
import com.example.disneyapi.viewmodel.DisneyViewModel
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.*

@OptIn(ExperimentalCoroutinesApi::class)
class DisneyViewModelTest {

    @get:Rule
    val testDispatcher = TestDispatcherRule()

    private val fakeRepository = FakeNetworkDisneyRepository()

    @Test
    fun disneyViewModel_getDisneyCharacters_verifySuccess() = runBlockingTest {
        val viewModel = DisneyViewModel(disneyRepository = fakeRepository)
        viewModel.getAllCharacters()

        assertEquals(
            DisneyUiState.Success(FakeDataSource.characterList),
            viewModel.uiState.value
        )
    }
}
