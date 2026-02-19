@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.mememach.app.core.designsystem.components.searchbars

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mememach.app.core.designsystem.theme.MemeMachTheme

@Composable
fun MemeMachSearchBar(
title: String,
query: String,
onQueryChange: (String) -> Unit,
onSearchClick: () -> Unit,
onBack: () -> Unit,
onClear: () -> Unit,
isSearchActive: Boolean,
modifier: Modifier = Modifier,
placeholder: String = "Search input",
) {
    val focusRequester = remember { FocusRequester() }
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()

    LaunchedEffect(isSearchActive) {
        if (isSearchActive) focusRequester.requestFocus()
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        // Left icon: back arrow in search mode, nothing in default
        if (isSearchActive) {
            IconButton(onClick = onBack) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White
                )
            }
        }

        // Middle: title or search input
        if (isSearchActive) {
            BasicTextField(
                value = query,
                onValueChange = onQueryChange,
                modifier = Modifier
                    .weight(1f)
                    .focusRequester(focusRequester),
                textStyle = TextStyle(
                    color = Color.White,
                    fontSize = 18.sp
                ),
                singleLine = true,
                cursorBrush = SolidColor(Color.White),
                interactionSource = interactionSource,
                decorationBox = { innerTextField ->
                    if (query.isEmpty()) {
                        Text(
                            text = placeholder,
                            color = if (isFocused) {
                                Color.White.copy(alpha = 0.4f)
                            } else {
                                Color.White.copy(alpha = 0.25f)
                            },
                            fontSize = 18.sp
                        )
                    }
                    innerTextField()
                }
            )
        } else {
            Text(
                text = title,
                modifier = Modifier.weight(1f),
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
            )
        }

        // Right icon: X in search mode (when focused or has text), search icon in default
        if (isSearchActive) {
            if (isFocused || query.isNotEmpty()) {
                IconButton(onClick = onClear) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Clear",
                        tint = Color.White
                    )
                }
            }
        } else {
            IconButton(onClick = onSearchClick) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = Color.White
                )
            }
        }
    }
}


@Preview
@Composable
private fun MemeMachSearchBarPreview() {
    var isSearchActive = remember { true }

    MemeMachTheme {
        MemeMachSearchBar(
            query = "Test",
            onQueryChange = {},
            onBack = {},
            onClear = {},
            isSearchActive = isSearchActive,
            title = "Test",
            onSearchClick = { isSearchActive = !isSearchActive }
        )
    }
}
