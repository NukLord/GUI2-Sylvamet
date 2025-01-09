package com.example.finalappsylvamet

// Ajoutons un bouton central dans MainActivity.kt qui redirige vers Martellage.kt

import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import com.example.yourappname.ui.theme.YourAppNameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YourAppNameTheme {
                Box(modifier = Modifier.fillMaxSize()) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_sylvamet),
                        contentDescription = "Bouton vers Martellage",
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(100.dp)
                            .clickable {
                                val intent = Intent(this@MainActivity, Martellage::class.java)
                                startActivity(intent)
                            }
                    )
                }
            }
        }
    }
}

// Assurez-vous que le fichier icon_arbre.png est ajouté dans le dossier res/drawable.
