package com.spravochnic.scbguide.utils.resmanager

import androidx.annotation.StringRes

interface ResManager {
    fun getString(@StringRes resId: Int): String
}