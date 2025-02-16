package com.spravochnic.scbguide.utils.resmanager

import android.content.Context
import androidx.annotation.StringRes

class ResManagerImpl(
    private val context: Context,
) : ResManager {

    override fun getString(@StringRes resId: Int): String {
        return context.getString(resId)
    }
}