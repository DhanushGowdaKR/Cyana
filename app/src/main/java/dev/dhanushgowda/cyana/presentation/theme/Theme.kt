package dev.dhanushgowda.cyana.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider


@Composable
fun CyanaTheme(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        localColorScheme provides colorScheme
    ) {
        MaterialTheme(
            typography = Typography,
            content = content
        )
    }
}

object CyanaTheme {
    val colorScheme: ColorScheme
        @Composable
        get() = localColorScheme.current
}