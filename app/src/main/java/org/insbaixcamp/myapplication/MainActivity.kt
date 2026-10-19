package org.insbaixcamp.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import org.insbaixcamp.myapplication.ui.screen.EditProfileScreen
import org.insbaixcamp.myapplication.ui.screen.ProfileScreen
import org.insbaixcamp.myapplication.ui.screen.UserProfile
import org.insbaixcamp.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                FitnessApp()
            }
        }
    }
}

@Composable
fun FitnessApp() {
    // Dades inicials de Laia Soler (en memòria)
    var profile by remember {
        mutableStateOf(
            UserProfile(
                name = "Laia Soler",
                email = "laia@exemple.cat",
                height = "165",
                weight = "60",
                goal = "Guanyar massa muscular",
                activity = "Moderat"
            )
        )
    }
    // Navegació bàsica entre 2 pantalles
    var isEditing by remember { mutableStateOf(false) }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            if (isEditing) {
                EditProfileScreen(
                    profile = profile,
                    onSave = { newProfile ->
                        profile = newProfile
                        isEditing = false
                    },
                    onCancel = { isEditing = false }
                )
            } else {
                ProfileScreen(
                    profile = profile,
                    onEditClick = { isEditing = true }
                )
            }
        }
    }
}