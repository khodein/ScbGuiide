package com.spravochnic.scbguide.status.api.module

import com.spravochnic.scbguide.status.api.repository.StatusRepository

interface StatusModule {
    fun getStatusRepository(): StatusRepository
}