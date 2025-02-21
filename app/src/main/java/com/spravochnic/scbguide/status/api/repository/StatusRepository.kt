package com.spravochnic.scbguide.status.api.repository

interface StatusRepository {
    suspend fun validateStatus()
}