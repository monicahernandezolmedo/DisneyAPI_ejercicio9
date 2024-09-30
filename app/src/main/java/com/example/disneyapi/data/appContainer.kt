package com.example.disneyapi.data



interface AppContainer {
    val disneyRepository: DisneyRepository
}

class DefaultAppContainer : AppContainer {
    private val disneyApiService by lazy {
        DisneyApiService.create()
    }

    override val disneyRepository: DisneyRepository by lazy {
        NetworkDisneyRepository(disneyApiService)
    }
}
