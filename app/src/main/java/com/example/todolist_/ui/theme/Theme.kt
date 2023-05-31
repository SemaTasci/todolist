package com.example.todolist_.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material3.*

import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.TextStyle
import androidx.core.view.ViewCompat

private val replyDarkColorScheme = darkColorScheme(
    primary = replyDarkPrimary,
    onPrimary = replyDarkOnPrimary,
    primaryContainer = replyDarkPrimaryContainer,
    onPrimaryContainer = replyDarkOnPrimaryContainer,
    inversePrimary = replyDarkPrimaryInverse,
    secondary = replyDarkSecondary,
    onSecondary = replyDarkOnSecondary,
    secondaryContainer = replyDarkSecondaryContainer,
    onSecondaryContainer = replyDarkOnSecondaryContainer,
    tertiary = replyDarkTertiary,
    onTertiary = replyDarkOnTertiary,
    tertiaryContainer = replyDarkTertiaryContainer,
    onTertiaryContainer = replyDarkOnTertiaryContainer,
    error = replyDarkError,
    onError = replyDarkOnError,
    errorContainer = replyDarkErrorContainer,
    onErrorContainer = replyDarkOnErrorContainer,
    background = replyDarkBackground,
    onBackground = replyDarkOnBackground,
    surface = replyDarkSurface,
    onSurface = replyDarkOnSurface,
    inverseSurface = replyDarkInverseSurface,
    inverseOnSurface = replyDarkInverseOnSurface,
    surfaceVariant = replyDarkSurfaceVariant,
    onSurfaceVariant = replyDarkOnSurfaceVariant,
    outline = replyDarkOutline
)

private val replyLightColorScheme = lightColorScheme(
    primary = replyLightPrimary,
    onPrimary = replyLightOnPrimary,
    primaryContainer = replyLightPrimaryContainer,
    onPrimaryContainer = replyLightOnPrimaryContainer,
    inversePrimary = replyLightPrimaryInverse,
    secondary = replyLightSecondary,
    onSecondary = replyLightOnSecondary,
    secondaryContainer = replyLightSecondaryContainer,
    onSecondaryContainer = replyLightOnSecondaryContainer,
    tertiary = replyLightTertiary,
    onTertiary = replyLightOnTertiary,
    tertiaryContainer = replyLightTertiaryContainer,
    onTertiaryContainer = replyLightOnTertiaryContainer,
    error = replyLightError,
    onError = replyLightOnError,
    errorContainer = replyLightErrorContainer,
    onErrorContainer = replyLightOnErrorContainer,
    background = replyLightBackground,
    onBackground = replyLightOnBackground,
    surface = replyLightSurface,
    onSurface = replyLightOnSurface,
    inverseSurface = replyLightInverseSurface,
    inverseOnSurface = replyLightInverseOnSurface,
    surfaceVariant = replyLightSurfaceVariant,
    onSurfaceVariant = replyLightOnSurfaceVariant,
    outline = replyLightOutline
)
@Composable
fun ToDoList_Theme(
    darkTheme: Boolean = false,
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme.not()) dynamicLightColorScheme(context) else dynamicDarkColorScheme(context)
        }
        darkTheme -> replyDarkColorScheme
        else -> replyLightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            (view.context as Activity).window.statusBarColor = colorScheme.primary.toArgb()
            //ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}/*
object NamazvakitleriTheme {
    val colors: NamazvakitleriColors
        @Composable
        get() = LocalNamazvakitleriColors.current

    val typography: NamazVakitleriTypography
        @Composable
        get() = LocalNamazvakitleriTypography.current

    val shapes: NamazVakitleriShapes
        @Composable
        get() = LocalNamazvakitleriShapes.current
}


@Composable
fun ProvideNamazvakitleriTheme(
    colors: NamazvakitleriColors,
    content: @Composable () -> Unit
) {
    val colorPalette = remember {
        colors.copy()
    }

    colorPalette.update(colors)
    CompositionLocalProvider(
        LocalNamazvakitleriTypography provides ,
        LocalNamazvakitleriShapes provides namazVakitleriShapePalette,
        LocalNamazvakitleriColors provides colorPalette, content = content
    )
}

@Immutable
data class NamazVakitleriTypography(
    val vakitInfo: TextStyle,
    val title: TextStyle,
    val ayetHadisTitle: TextStyle,
    val onboardingInfoTextStyle: TextStyle,
    val searchTextStyle: TextStyle
)

@Immutable
data class NamazVakitleriShapes(
    val surface: Shape,
    val small: Shape,
    val circle: Shape,
    val medium: Shape,
    val large: Shape
)

private val LocalNamazvakitleriTypography = staticCompositionLocalOf<NamazVakitleriTypography> {
    error("No Namazvakitleri typo provided")
}

private val LocalNamazvakitleriColors = staticCompositionLocalOf<NamazvakitleriColors> {
    error("No Namazvakitleri provided")
}

val LocalNamazvakitleriShapes = staticCompositionLocalOf<NamazVakitleriShapes> {
    error("No Namazvakitleri shape provided")
}

/**
 * Namazvakitleri custom Color Palette
 */
@Stable
class NamazvakitleriColors(
    gradientCircle: List<Color>,
    vakitInfo: Color,
    kalanSure: Color,
    currentVakit: Color,
    vakitPanelBackground: Color,
    normalVakit: Color,
    ayetHadisInfo: Color,
    ilIlceAd: Color,
    onBoardingBackground: Color,
    contentColor: Color,
    uiBackground: Color,
    welcomeBackground: List<Color>,
    welcomeContinueText: Color,
    searchTextHintColor: Color,
    searchTextColor: Color,
    searchTextBackgroundColor: Color,
    searchTextBorderColor: Color,
    isDark: Boolean,
    districtBackground:List<Color>
) {
    var gradientCircle by mutableStateOf(gradientCircle)
        private set
    var vakitInfo by mutableStateOf(vakitInfo)
        private set
    var kalanSure by mutableStateOf(kalanSure)
        private set
    var currentVakit by mutableStateOf(currentVakit)
        private set
    var vakitPanelBackground by mutableStateOf(vakitPanelBackground)
        private set
    var normalVakit by mutableStateOf(normalVakit)
        private set
    var ayetHadisInfo by mutableStateOf(ayetHadisInfo)
        private set
    var ilIlceAd by mutableStateOf(ilIlceAd)
        private set
    var onBoardingBackground by mutableStateOf(onBoardingBackground)
        private set
    var uiBackground by mutableStateOf(uiBackground)
        private set
    var contentColor by mutableStateOf(contentColor)
        private set
    var isDark by mutableStateOf(isDark)
        private set
    var welcomeBackground by mutableStateOf(welcomeBackground)
        private set
    var welcomeContinueText by mutableStateOf(welcomeContinueText)
        private set
    var searchTextHintColor by mutableStateOf(searchTextHintColor)
        private set
    var searchTextColor by mutableStateOf(searchTextColor)
        private set
    var searchTextBackgroundColor by mutableStateOf(searchTextBackgroundColor)
        private set
    var searchTextBorderColor by mutableStateOf(searchTextBorderColor)
        private set
    var districtBackground by mutableStateOf(districtBackground)
        private set
    fun update(other: NamazvakitleriColors) {
        gradientCircle = other.gradientCircle
        vakitInfo = other.vakitInfo
        kalanSure = other.kalanSure
        currentVakit = other.currentVakit
        normalVakit = other.normalVakit
        ayetHadisInfo = other.ayetHadisInfo
        vakitPanelBackground = other.vakitPanelBackground
        ilIlceAd = other.ilIlceAd
        onBoardingBackground = other.onBoardingBackground
        uiBackground = other.uiBackground
        contentColor = other.contentColor
        welcomeBackground = other.welcomeBackground
        welcomeContinueText = other.welcomeContinueText
        searchTextHintColor = other.searchTextHintColor
        searchTextColor = other.searchTextColor
        searchTextBackgroundColor = other.searchTextBackgroundColor
        searchTextBorderColor = other.searchTextBorderColor
        isDark = other.isDark
        districtBackground=other.districtBackground
    }

    fun copy(): NamazvakitleriColors = NamazvakitleriColors(
        gradientCircle = gradientCircle,
        vakitInfo = vakitInfo,
        kalanSure = kalanSure,
        currentVakit = currentVakit,
        normalVakit = normalVakit,
        ayetHadisInfo = ayetHadisInfo,
        vakitPanelBackground = vakitPanelBackground,
        ilIlceAd = ilIlceAd,
        onBoardingBackground = onBoardingBackground,
        uiBackground = uiBackground,
        contentColor = contentColor,
        welcomeBackground = welcomeBackground,
        welcomeContinueText = welcomeContinueText,
        searchTextHintColor = searchTextHintColor,
        searchTextColor = searchTextColor,
        searchTextBackgroundColor = searchTextBackgroundColor,
        searchTextBorderColor = searchTextBorderColor,
        isDark = isDark,
        districtBackground = districtBackground
    )
}

/**
 * A Material [Colors] implementation which sets all colors to [debugColor] to discourage usage of
 * [MaterialTheme.colors] in preference to [Namazvakitleri.colors].
 */
fun debugColors(
    darkTheme: Boolean,
    debugColor: Color = Color.Magenta
) = Colors(
    primary = debugColor,
    primaryVariant = debugColor,
    secondary = debugColor,
    secondaryVariant = debugColor,
    background = debugColor,
    surface = debugColor,
    error = debugColor,
    onPrimary = debugColor,
    onSecondary = debugColor,
    onBackground = debugColor,
    onSurface = debugColor,
    onError = debugColor,
    isLight = !darkTheme
)
*/
