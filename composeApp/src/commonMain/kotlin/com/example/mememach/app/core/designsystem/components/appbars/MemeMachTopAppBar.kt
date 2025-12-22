@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.mememach.app.core.designsystem.components.appbars

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mememach.app.core.designsystem.theme.MemeMachTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MemeMachTopAppBar(
    modifier: Modifier = Modifier,
    leftActions: @Composable (() -> Unit) = {},
    rightActions: @Composable (() -> Unit) = {},
    title: @Composable (() -> Unit) = {},
    colors: TopAppBarColors = TopAppBarDefaults.topAppBarColors(
        containerColor = MaterialTheme.colorScheme.background,
        titleContentColor = MaterialTheme.colorScheme.background,
        navigationIconContentColor = MaterialTheme.colorScheme.background,
        actionIconContentColor = MaterialTheme.colorScheme.background
    )
) {
    CenterAlignedTopAppBar(
        title = title,
        modifier = modifier,
        navigationIcon = leftActions,
        actions = {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) { rightActions.invoke() }
        },
        colors = colors
    )
}

@Preview
@Composable
private fun TaskyTopAppBarPreview() {
    MemeMachTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            MemeMachTopAppBar(
                modifier = Modifier
                    .width(300.dp)
                    .padding(horizontal = 16.dp, vertical = 6.dp),
                title = {
                    Text(
                        text = "Edit task",
                        color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            )
        }
    }
}
