package com.spravochnic.scbguide.utils.colormatrix

import androidx.compose.ui.graphics.ColorMatrix

object CustomColorMatrix {
    private val orangeFloatArray = floatArrayOf(
        0.6f, 0.4f, 0.0f, 0.0f, 0.1f,
        0.4f, 0.3f, 0.0f, 0.0f, 0.1f,
        0.0f, 0.0f, 0.1f, 0.0f, 0.0f,
        0.0f, 0.0f, 0.0f, 1.0f, 0.0f
    )

    private val blueFloatArray = floatArrayOf(
        1f, 0f, 0f, 0f, 0f,
        0f, 1f, 0f, 0f, 0f,
        0f, 0f, 2f, 0f, 0f,
        0f, 0f, 0f, 1f, 0f
    )

    fun getOrangeMatrix(): ColorMatrix {
        return ColorMatrix(orangeFloatArray)
    }

    fun getBlueMatrix(): ColorMatrix {
        return ColorMatrix(blueFloatArray)
    }
}