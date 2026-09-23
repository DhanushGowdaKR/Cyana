package dev.dhanushgowda.cyana.presentation.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class ColorScheme(
    val drumPad: Color,
    val background: Color
)

val localColorScheme = staticCompositionLocalOf {
    ColorScheme(
        drumPad = Color.Unspecified,
        background = Color.Unspecified
    )
}

val colorScheme = ColorScheme(
    drumPad = Color(0xFFFBFEFB),
    background = Color(0xFFFBFEFB)
//    0xFFBD2708
)
