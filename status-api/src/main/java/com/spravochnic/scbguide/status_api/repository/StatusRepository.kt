package com.spravochnic.scbguide.status_api.repository

interface StatusRepository {
    suspend fun validateStatus()
}