package com.spravochnic.scbguide.uikit.theme

import android.os.Build
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.spravochnic.scbguide.uikit.theme.color.Primary
import com.spravochnic.scbguide.uikit.theme.color.Secondary
import com.spravochnic.scbguide.uikit.theme.color.Tertiary

private val DarkColorScheme = darkColorScheme(
    primary = Primary,
    secondary = Secondary,
    tertiary = Tertiary,
    background = Primary
)

private val LightColorScheme = lightColorScheme(
    primary = Primary,
    primaryContainer = Primary,
    secondary = Secondary,
    tertiary = Tertiary,
    background = Primary,
    surfaceContainerHighest = Tertiary
)

@Composable
fun ScbGuiideTheme(
    darkTheme: Boolean = false,
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}