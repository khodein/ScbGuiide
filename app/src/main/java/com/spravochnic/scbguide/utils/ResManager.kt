package com.spravochnic.scbguide.utils

import androidx.annotation.StringRes

interface ResManager {

    fun getString(@StringRes resId: Int): String
}