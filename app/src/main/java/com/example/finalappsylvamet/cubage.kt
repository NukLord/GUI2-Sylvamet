package com.example.finalappsylvamet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) {
        NavigationGraph(navController = navController)
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    BottomNavigation(
        backgroundColor = Color(0xFFF28627),
        contentColor = Color.White
    ) {
        BottomNavigationItem(
            icon = {
                Icon(painter = painterResource(id = R.drawable.ic_documents), contentDescription = "Documents")
            },
            label = { Text("Documents") },
            selected = false,
            onClick = { navController.navigate("documents") }
        )
        BottomNavigationItem(
            icon = {
                Icon(painter = painterResource(id = R.drawable.ic_measure), contentDescription = "Mesures")
            },
            label = { Text("Mesures") },
            selected = false,
            onClick = { navController.navigate("mesures") }
        )
        BottomNavigationItem(
            icon = {
                Icon(painter = painterResource(id = R.drawable.ic_tools), contentDescription = "Outils")
            },
            label = { Text("Outils") },
            selected = false,
            onClick = { navController.navigate("outils") }
        )
    }
}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = "documents") {
        composable("documents") { DocumentsScreen() }
        composable("mesures") { MesuresScreen() }
        composable("outils") { OutilsScreen() }
    }
}

@Composable
fun NavHost(
    x0: NavHostController,
    startDestination: String,
    content: @Composable () -> composable
) {
    TODO("Not yet implemented")
}

@Composable
fun DocumentsScreen() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Text("Cubages", style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(sampleData.size) { index ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .background(Color(0xFFF2F2F2))
                        .padding(8.dp)
                ) {
                    Text(sampleData[index].coupe, modifier = Modifier.weight(1f))
                    Text(sampleData[index].date, modifier = Modifier.weight(1f))
                    Text(sampleData[index].numero.toString(), modifier = Modifier.weight(1f))
                    Icon(
                        painter = painterResource(id = sampleData[index].typeIcon),
                        contentDescription = "Type",
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun MesuresScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Page Mesures")
    }
}

@Composable
fun OutilsScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Page Outils")
    }
}

data class CubageData(
    val coupe: String,
    val date: String,
    val numero: Int,
    val typeIcon: Int
)

val sampleData = listOf(
    CubageData("AUG 144", "11.02.24", 1300, R.drawable.ic_type1),
    CubageData("NEJ 134", "19.01.24", 3203, R.drawable.ic_type2),
    CubageData("LAK 234", "10.12.23", 4839, R.drawable.ic_type1),
    CubageData("POW 493", "17.10.23", 8930, R.drawable.ic_type1),
    CubageData("LOQ 530", "15.08.23", 3245, R.drawable.ic_type2),
    CubageData("OLW 156", "25.06.23", 5432, R.drawable.ic_type2),
    CubageData("JFR 308", "02.05.23", 4829, R.drawable.ic_type1),
    CubageData("KSM 679", "09.03.22", 1400, R.drawable.ic_type2),
    CubageData("TSR 796", "21.01.22", 1450, R.drawable.ic_type1)
)
