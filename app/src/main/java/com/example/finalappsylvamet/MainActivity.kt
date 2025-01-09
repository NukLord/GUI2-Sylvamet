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
                        Color(0xFFF28627), // Couleur Orange
                        Color(0xFFF2A35E), // Couleur Rouge-orangé
                        Color(0xFFF27127), // Couleur Violet
                        Color(0xFFF2F2F2)  // Couleur Bleu
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        // Logo centré
        Image(
            painter = painterResource(id = R.drawable.icone_sylvamet.png), // Assurez-vous que le fichier logo.png existe dans res/drawable
            contentDescription = "Logo",
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(150.dp) // Ajuste la taille du logo
        )
    }
}