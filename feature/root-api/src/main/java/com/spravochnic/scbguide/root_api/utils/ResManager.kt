package com.spravochnic.scbguide.root_api.utils

import androidx.annotation.StringRes

interface ResManager {
    fun getString(@StringRes resId: Int): String
}