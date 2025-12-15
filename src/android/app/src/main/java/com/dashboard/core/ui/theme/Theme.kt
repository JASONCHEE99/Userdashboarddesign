package com.dashboard.core.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColorScheme = lightColorScheme(
    primary = Primary,
    onPrimary = OnPrimary,
    primaryContainer = InfoLight,
    onPrimaryContainer = OnInfo,
    
    secondary = Secondary,
    onSecondary = OnSecondary,
    secondaryContainer = WarningLight,
    onSecondaryContainer = OnWarning,
    
    tertiary = Success,
    onTertiary = OnSuccess,
    tertiaryContainer = SuccessLight,
    onTertiaryContainer = OnSuccess,
    
    error = Error,
    onError = OnError,
    errorContainer = ErrorLight,
    onErrorContainer = OnError,
    
    background = Background,
    onBackground = OnBackground,
    surface = Surface,
    onSurface = OnSurface,
    
    surfaceVariant = Gray100,
    onSurfaceVariant = Gray700,
    outline = Gray300,
    outlineVariant = Gray200,
)

@Composable
fun DashboardTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = LightColorScheme

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.surface.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = true
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
