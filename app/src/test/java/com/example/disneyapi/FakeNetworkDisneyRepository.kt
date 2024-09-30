package com.example.disneyapi
import DisneyCharacter
import com.example.disneyapi.data.DisneyRepository

class FakeNetworkDisneyRepository : DisneyRepository {
    override suspend fun getDisneyCharacters(): List<DisneyCharacter> {
        return FakeDataSource.characterList
    }
}
