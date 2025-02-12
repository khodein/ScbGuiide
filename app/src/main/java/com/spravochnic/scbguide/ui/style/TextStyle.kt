package com.spravochnic.scbguide.ui.style

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.spravochnic.scbguide.R

object AppFont {
    val Poppins = FontFamily(
        Font(R.font.regular, FontWeight.Normal),
        Font(R.font.bold, FontWeight.Bold),
        Font(R.font.extrabold, FontWeight.ExtraBold)
    )
}

val ExtraBold = TextStyle(
    fontFamily = AppFont.Poppins,
    fontWeight = FontWeight.ExtraBold
)

val Bold = TextStyle(
    fontFamily = AppFont.Poppins,
    fontWeight = FontWeight.Bold
)

val Regular = TextStyle(
    fontFamily = AppFont.Poppins,
    fontWeight = FontWeight.Normal,
)

val Regular_12 = Regular.copy(
    fontSize = 12.sp,
    lineHeight = 18.sp
)

val Regular_13 = Regular.copy(
    fontSize = 13.sp,
    lineHeight = 22.sp
)

val Bold_22 = Bold.copy(
    fontSize = 22.sp,
    lineHeight = 33.sp,
)

val ExtraBold_15 = ExtraBold.copy(
    fontSize = 15.sp,
    lineHeight = 25.sp
)