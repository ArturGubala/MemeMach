@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.mememach.app.core.designsystem.components.appbars

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.mememach.app.core.designsystem.theme.MemeMachTheme

@Composable
fun MemeMachTopAppBar(
    modifier: Modifier = Modifier,
    leadingContent: @Composable (RowScope.() -> Unit) = {},  // Left section
    trailingContent: @Composable (RowScope.() -> Unit) = {},  // Right section
    centerContent: @Composable (() -> Unit) = {},  // Center section
    colors: TopAppBarColors = TopAppBarDefaults.topAppBarColors(
        containerColor = MaterialTheme.colorScheme.background,
        titleContentColor = MaterialTheme.colorScheme.background,
        navigationIconContentColor = MaterialTheme.colorScheme.background,
        actionIconContentColor = MaterialTheme.colorScheme.background
    )
) {
    CenterAlignedTopAppBar(
        title = centerContent,
        modifier = modifier,
        navigationIcon = {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) { leadingContent() }
        },
        actions = {
            Row(
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) { trailingContent() }
        },
        colors = colors
    )
}

@Preview
@Composable
private fun MemeMachTopAppBarPreview() {
    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Variation 1: List Screen
            MemeMachTopAppBar(
                leadingContent = {
                    Text(
                        text = "New meme",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                },
                trailingContent = {
                    Text(
                        text = "Favourites first",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Sort options",
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
            )

            // Variation 2: Detail Screen with centered title
            MemeMachTopAppBar(
                leadingContent = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Navigate back",
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    }
                },
                centerContent = {
                    Text(
                        text = "New meme",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            )

            // Variation 3: Selection Mode
            MemeMachTopAppBar(
                leadingContent = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Clear selection",
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    }
                    Text(
                        text = "2",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                },
                trailingContent = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.Share,
                            contentDescription = "Share",
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    }
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "Delete",
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    }
                }
            )
        }
    }
}
