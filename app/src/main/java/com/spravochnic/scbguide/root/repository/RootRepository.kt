package com.spravochnic.scbguide.root.repository

interface RootRepository {
    suspend fun validateStatus()
}