package com.am.septimob.happycats.data

import com.am.septimob.happycats.model.Cat

object CatRepository {
    val cats = listOf(
        Cat(
            id = 1,
            name = "Milo",
            breed = "Siamés",
            age = 2,
            weightKg = 4.1,
            description = "Milo es un gato curioso al que le encanta observar por la ventana " +
                "y perseguir juguetes de plumas.",
            imageUrl = "https://placecats.com/millie/400/300"
        ),
        Cat(
            id = 2,
            name = "Luna",
            breed = "Persa",
            age = 3,
            weightKg = 3.8,
            description = "Luna es tranquila y cariñosa, disfruta de largas siestas sobre " +
                "mantas suaves.",
            imageUrl = "https://placecats.com/neo/400/300"
        ),
        Cat(
            id = 3,
            name = "Simba",
            breed = "Maine Coon",
            age = 4,
            weightKg = 6.5,
            description = "Simba es grande y juguetón, le encanta trepar y vigilar la casa " +
                "desde lugares altos.",
            imageUrl = "https://placecats.com/bella/400/300"
        ),
        Cat(
            id = 4,
            name = "Nala",
            breed = "Angora",
            age = 1,
            weightKg = 2.9,
            description = "Nala es la más joven de la casa, muy activa y siempre lista para " +
                "jugar con una pelota.",
            imageUrl = "https://placecats.com/400/300"
        ),
        Cat(
            id = 5,
            name = "Tom",
            breed = "Británico de pelo corto",
            age = 5,
            weightKg = 5.2,
            description = "Tom es tranquilo y sociable, se lleva bien con los demás gatos y " +
                "con los niños.",
            imageUrl = "https://placecats.com/g/400/300"
        ),
        Cat(
            id = 6,
            name = "Coco",
            breed = "Bengalí",
            age = 2,
            weightKg = 4.4,
            description = "Coco tiene un pelaje moteado muy llamativo y una energía " +
                "inagotable durante el día.",
            imageUrl = "https://placecats.com/millie/400/301"
        ),
        Cat(
            id = 7,
            name = "Misu",
            breed = "Común Europeo",
            age = 6,
            weightKg = 4.8,
            description = "Misu es el más experimentado del grupo, disfruta observar el " +
                "jardín desde el balcón.",
            imageUrl = "https://placecats.com/neo/401/300"
        ),
        Cat(
            id = 8,
            name = "Kiara",
            breed = "Ragdoll",
            age = 3,
            weightKg = 4.6,
            description = "Kiara es extremadamente dócil, le encanta que la carguen y " +
                "ronronea con facilidad.",
            imageUrl = "https://placecats.com/bella/401/300"
        )
    )
}
