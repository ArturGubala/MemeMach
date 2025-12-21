package com.example.mememach.app.core.designsystem.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val LocalExtendedColors = staticCompositionLocalOf { LightExtendedColors }

val ColorScheme.extended: ExtendedColors
    @ReadOnlyComposable
    @Composable
    get() = LocalExtendedColors.current

@Immutable
data class ExtendedColors(
    val buttonDefault: List<Color>,
    val buttonPressed : List<Color>
)

val LightExtendedColors = ExtendedColors(
    buttonDefault = ButtonDefaultGradient,
    buttonPressed = ButtonPressedGradient
)

val DarkExtendedColors = ExtendedColors(
    buttonDefault = ButtonDefaultGradient,
    buttonPressed = ButtonPressedGradient
)

val DarkColorScheme = darkColorScheme(
    surfaceContainerLowest = Onyx,
    surfaceContainerLow = Mirage,
    surfaceContainer = Mirage,
    surfaceContainerHigh = BalticSea,
    outline = Boulder,
    primary = ButterflyBush,
    surfaceDim = Lavender,
    onSurface = LavenderPinocchio,
    primaryContainer = LavenderPink,
    surfaceContainerHighest = LavenderMist,
    error = CornellRed,
    onPrimary = CherryPie,
    background = Onyx,
    onPrimaryContainer = Black
)

val LightColorScheme = lightColorScheme(
    surfaceContainerLowest = Onyx,
    surfaceContainerLow = Mirage,
    surfaceContainer = Mirage,
    surfaceContainerHigh = BalticSea,
    outline = Boulder,
    primary = ButterflyBush,
    surfaceDim = Lavender,
    onSurface = LavenderPinocchio,
    primaryContainer = LavenderPink,
    surfaceContainerHighest = LavenderMist,
    error = CornellRed,
    onPrimary = CherryPie,
    background = Onyx,
    onPrimaryContainer = Black
)
