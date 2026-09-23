package com.am.septimob.happycats.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.unit.dp
import com.am.septimob.happycats.data.CatRepository
import com.am.septimob.happycats.model.Cat
import com.am.septimob.happycats.ui.components.CatItem
import com.am.septimob.happycats.ui.theme.HappyCatsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatCatalogScreen(
    cats: List<Cat>,
    onCatClick: (Cat) -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text("Catálogo de Gatos") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver al inicio"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(cats, key = { it.id }) { cat ->
                CatItem(
                    cat = cat,
                    onClick = { onCatClick(cat) },
                    modifier = Modifier.padding(bottom = 12.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CatCatalogScreenPreview() {
    HappyCatsTheme {
        CatCatalogScreen(
            cats = CatRepository.cats,
            onCatClick = {},
            onBackClick = {}
        )
    }
}
