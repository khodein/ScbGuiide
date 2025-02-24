package com.spravochnic.scbguide.root_impl.utils.resmanager

import android.content.Context
import androidx.annotation.StringRes
import com.spravochnic.scbguide.root_api.utils.ResManager

class ResManagerImpl(
    private val context: Context,
) : ResManager {

    override fun getString(@StringRes resId: Int): String {
        return context.getString(resId)
    }
}