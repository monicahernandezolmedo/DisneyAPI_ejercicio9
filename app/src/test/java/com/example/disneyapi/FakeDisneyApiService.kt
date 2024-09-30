package com.example.disneyapi

import DisneyApiService
import DisneyCharacterResponseList
import Info
import androidx.media3.test.utils.FakeDataSource


class FakeDisneyApiService : DisneyApiService {
    override suspend fun getAllCharacters(page: Int): DisneyCharacterResponseList {
        return DisneyCharacterResponseList(
            info = Info(count = FakeDataSource.characterList.size),
            data = FakeDataSource.characterList // Aquí se debe acceder a characterList
        )
    }
}
