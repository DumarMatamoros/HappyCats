package com.am.septimob.happycats.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cake
import androidx.compose.material.icons.filled.MonitorWeight
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.am.septimob.happycats.model.Cat
import com.am.septimob.happycats.ui.theme.HappyCatsTheme

@Composable
fun CatDetailCard(
    cat: Cat,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(16.dp)) {
        AsyncImage(
            model = cat.imageUrl,
            contentDescription = "Foto de ${cat.name}",
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )
        Text(
            text = cat.name,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = cat.breed,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )
        HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp))
        Card(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.padding(16.dp)) {
                DetailAttribute(
                    icon = Icons.Filled.Cake,
                    label = "Edad",
                    value = "${cat.age} años",
                    modifier = Modifier.weight(1f)
                )
                DetailAttribute(
                    icon = Icons.Filled.MonitorWeight,
                    label = "Peso",
                    value = "${cat.weightKg} kg",
                    modifier = Modifier.weight(1f)
                )
            }
        }
        Text(
            text = "Sobre ${cat.name}",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 16.dp, bottom = 4.dp)
        )
        Text(
            text = cat.description,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
private fun DetailAttribute(
    icon: ImageVector,
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(28.dp),
            tint = MaterialTheme.colorScheme.primary
        )
        Column(modifier = Modifier.padding(start = 8.dp)) {
            Text(text = label, style = MaterialTheme.typography.labelMedium)
            Text(text = value, style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.SemiBold)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CatDetailCardPreview() {
    HappyCatsTheme {
        CatDetailCard(
            cat = Cat(
                id = 1,
                name = "Milo",
                breed = "Siamés",
                age = 2,
                weightKg = 4.1,
                description = "Milo es un gato curioso al que le encanta observar por la " +
                    "ventana y perseguir juguetes de plumas.",
                imageUrl = "https://placecats.com/millie/400/300"
            )
        )
    }
}
