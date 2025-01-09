package com.example.gradientlogo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GradientBackgroundWithLogo()
        }
    }
}

@Composable
fun GradientBackgroundWithLogo() {
    // Crée un fond avec un dégradé de 4 couleurs
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFFA726), // Orange
                        Color(0xFFFF7043), // Rouge-orangé
                        Color(0xFFAB47BC), // Violet
                        Color(0xFF42A5F5)  // Bleu
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        // Logo centré
        Image(
            painter = painterResource(id = R.drawable.logo), // Place ton logo dans res/drawable sous le nom logo.png
            contentDescription = "Logo",
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(150.dp) // Ajuste la taille du logo
        )
    }
}
