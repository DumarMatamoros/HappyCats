package com.am.septimob.happycats

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.am.septimob.happycats.data.CatRepository
import com.am.septimob.happycats.model.Cat
import com.am.septimob.happycats.ui.CatAppScreen
import com.am.septimob.happycats.ui.screens.CatCatalogScreen
import com.am.septimob.happycats.ui.screens.CatDetailScreen
import com.am.septimob.happycats.ui.screens.CatHomeScreen
import com.am.septimob.happycats.ui.theme.HappyCatsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HappyCatsTheme {
                HappyCatsApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}


//Patrón de elevación de estados:
@Composable
fun HappyCatsApp(modifier: Modifier = Modifier) {
    var currentScreen by remember { mutableStateOf(CatAppScreen.HOME) }
    var selectedCat by remember { mutableStateOf<Cat?>(null) }

    when (currentScreen) {
        CatAppScreen.HOME -> {
            CatHomeScreen(
                onViewCatalogClick = { currentScreen = CatAppScreen.CATALOG },
                modifier = modifier
            )
        }

        CatAppScreen.CATALOG -> {
            CatCatalogScreen(
                cats = CatRepository.cats,
                onCatClick = { cat ->
                    selectedCat = cat
                    currentScreen = CatAppScreen.DETAIL
                },
                onBackClick = { currentScreen = CatAppScreen.HOME },
                modifier = modifier
            )
        }

        CatAppScreen.DETAIL -> {
            selectedCat?.let { cat ->
                CatDetailScreen(
                    cat = cat,
                    onBackClick = { currentScreen = CatAppScreen.CATALOG },
                    modifier = modifier
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HappyCatsAppPreview() {
    HappyCatsTheme {
        HappyCatsApp()
    }
}
