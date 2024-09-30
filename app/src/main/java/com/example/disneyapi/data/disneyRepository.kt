package com.example.disneyapi.data

import DisneyApiService
import DisneyCharacter

interface DisneyRepository {
    suspend fun getDisneyCharacters(): List<DisneyCharacter>
}

class NetworkDisneyRepository(private val disneyApiService: DisneyApiService) : DisneyRepository {
    override suspend fun getDisneyCharacters(): List<DisneyCharacter> {
        val response = disneyApiService.getAllCharacters()
        return response.data
    }
}
