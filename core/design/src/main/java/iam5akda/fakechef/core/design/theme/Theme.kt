package iam5akda.fakechef.core.design.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val darkColorPalette = darkColorScheme(
    primary = Orange200,
    secondary = Orange700,
    tertiary = Green,
    tertiaryContainer = DarkGreen,
    background = Hair,
    surface = Hair,
    onPrimary = Hair,
    onSurface = Cream,
)

private val lightColorPalette = lightColorScheme(
    primary = Orange500,
    secondary = Orange700,
    tertiary = Green,
    tertiaryContainer = LightGreen,
    background = Cream,
    surface = Cream,
    onPrimary = Cream,
    onSurface = Hair
)

@Composable
fun FakeChefTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        darkColorPalette
    } else {
        lightColorPalette
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}