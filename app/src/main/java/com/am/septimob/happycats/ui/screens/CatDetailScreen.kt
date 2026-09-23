package com.am.septimob.happycats.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.am.septimob.happycats.data.CatRepository
import com.am.septimob.happycats.model.Cat
import com.am.septimob.happycats.ui.components.CatDetailCard
import com.am.septimob.happycats.ui.theme.HappyCatsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatDetailScreen(
    cat: Cat,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text(cat.name) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver al catálogo"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        CatDetailCard(
            cat = cat,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CatDetailScreenPreview() {
    HappyCatsTheme {
        CatDetailScreen(
            cat = CatRepository.cats.first(),
            onBackClick = {}
        )
    }
}
