package com.example.mememach.app.core.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import mememach.composeapp.generated.resources.Res
import mememach.composeapp.generated.resources.manrope_bold
import mememach.composeapp.generated.resources.manrope_medium
import mememach.composeapp.generated.resources.manrope_regular
import mememach.composeapp.generated.resources.manrope_semibold
import org.jetbrains.compose.resources.Font

val Manrope @Composable get() = FontFamily(
    Font(
        resource = Res.font.manrope_regular,
        weight = FontWeight.Normal
    ),
    Font(
        resource = Res.font.manrope_medium,
        weight = FontWeight.Medium
    ),
    Font(
        resource = Res.font.manrope_semibold,
        weight = FontWeight.SemiBold
    ),
    Font(
        resource = Res.font.manrope_bold,
        weight = FontWeight.Bold
    ),
)

val Typography @Composable get() = Typography(
    bodyLarge = TextStyle(
        fontFamily = Manrope,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = Manrope,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    bodySmall = TextStyle(
        fontFamily = Manrope,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    labelLarge = TextStyle(
        fontFamily = Manrope,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = Manrope,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        lineHeight = 28.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = Manrope,
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = Manrope,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp
    ),
)
