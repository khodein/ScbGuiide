package com.spravochnic.scbguide.status_api.module

import com.spravochnic.scbguide.status_api.repository.StatusRepository

interface StatusModule {
    fun getStatusRepository(): StatusRepository
}