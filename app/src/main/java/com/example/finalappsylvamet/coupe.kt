package com.example.finalappsylvamet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NouveauCubageScreen()
        }
    }
}

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun NouveauCubageScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Coupe", fontWeight = FontWeight.Bold, fontSize = 18.sp) },
                navigationIcon = {
                    IconButton(onClick = { /* TODO: Action retour */ }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Retour")
                    }
                }
            )
        },
        bottomBar = {
            BottomNavigation {
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Accueil") },
                    label = { Text("Accueil") },
                    selected = false,
                    onClick = { /* TODO: Naviguer vers Accueil */ }
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Settings, contentDescription = "Paramètres") },
                    label = { Text("Paramètres") },
                    selected = false,
                    onClick = { /* TODO: Naviguer vers Paramètres */ }
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Info, contentDescription = "Info") },
                    label = { Text("Info") },
                    selected = false,
                    onClick = { /* TODO: Naviguer vers Info */ }
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "Nouveau Cubage",
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Zone de texte : Date
            OutlinedTextField(
                value = "",
                onValueChange = { /* TODO: Mettre à jour la date */ },
                label = { Text("Date de cubage") },
                leadingIcon = { Icon(Icons.Default.DateRange, contentDescription = null) },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Zone de texte : Coupe
            OutlinedTextField(
                value = "",
                onValueChange = { /* TODO: Mettre à jour la coupe */ },
                label = { Text("Coupe") },
                leadingIcon = { Icon(
                    Icons.Default.Book,
                    contentDescription = null
                ) },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Zone de texte : Numéro
            OutlinedTextField(
                value = "",
                onValueChange = { /* TODO: Mettre à jour le numéro */ },
                label = { Text("Numéro") },
                leadingIcon = { Icon(Icons.Default.FormatListNumbered, contentDescription = null) },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Zone de texte : Descriptif
            OutlinedTextField(
                value = "",
                onValueChange = { /* TODO: Mettre à jour le descriptif */ },
                label = { Text("Descriptif") },
                leadingIcon = { Icon(Icons.Default.Description, contentDescription = null) },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Boutons Pile / Tige
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(onClick = { /* TODO: Choix Pile */ }) {
                    Icon(Icons.Default.StackedBarChart, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Pile")
                }
                Button(onClick = { /* TODO: Choix Tige */ }) {
                    Icon(Icons.Default.LinearScale, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Tige")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Boutons Ajouter / Supprimer
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { /* TODO: Ajouter */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
                ) {
                    Text("Ajouter", color = Color.White)
                }
                Button(
                    onClick = { /* TODO: Supprimer */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
                ) {
                    Text("Supprimer", color = Color.White)
                }
            }
        }
    }
}

@Composable
fun BottomNavigationItem(
    icon: @Composable () -> Unit,
    label: @Composable () -> Unit,
    selected: Boolean,
    onClick: () -> Unit
) {
    BottomNavigationItem(
        icon = icon,
        label = label,
        selected = selected,
        onClick = onClick,
        alwaysShowLabel = true
    )
}

@Composable
fun BottomNavigation(content: @Composable () -> Unit) {
    androidx.compose.material.BottomNavigation(content = content)
}

@Preview(showBackground = true)
@Composable
fun PreviewNouveauCubageScreen() {
    NouveauCubageScreen()
}