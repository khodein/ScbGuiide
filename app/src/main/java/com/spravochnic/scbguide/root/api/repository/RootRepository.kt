package com.spravochnic.scbguide.root.api.repository

interface RootRepository {
    suspend fun validateStatus()
}