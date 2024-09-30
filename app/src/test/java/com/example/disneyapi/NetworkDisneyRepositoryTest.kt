package com.example.disneyapi

import DisneyApiService
import DisneyCharacter
import androidx.media3.test.utils.FakeDataSource
import com.example.disneyapi.data.NetworkDisneyRepository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test


class NetworkDisneyRepositoryTest {

    @Test
    fun networkDisneyRepository_getCharacters_verifyCharacterList() = runBlocking {
        val repository = NetworkDisneyRepository(FakeDisneyApiService())
        assertEquals(FakeDataSource, repository.getDisneyCharacters())
    }
}
