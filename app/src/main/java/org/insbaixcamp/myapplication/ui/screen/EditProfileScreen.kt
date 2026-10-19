package org.insbaixcamp.myapplication.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun EditProfileScreen(
    profile: UserProfile,
    onSave: (UserProfile) -> Unit,
    onCancel: () -> Unit
) {
    // Estat local: només es copia al perfil quan es prem "Guardar canvis"
    var name by remember { mutableStateOf(profile.name) }
    var email by remember { mutableStateOf(profile.email) }
    var height by remember { mutableStateOf(profile.height) }
    var weight by remember { mutableStateOf(profile.weight) }
    var goal by remember { mutableStateOf(profile.goal) }
    var activity by remember { mutableStateOf(profile.activity) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Editar perfil", style = MaterialTheme.typography.headlineMedium)

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nom") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Correu") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = height,
            onValueChange = { height = it },
            label = { Text("Alçada (cm)") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = weight,
            onValueChange = { weight = it },
            label = { Text("Pes (kg)") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        DropdownSelector(
            label = "Objectiu principal",
            options = goalOptions,
            selected = goal,
            onSelected = { goal = it }
        )
        DropdownSelector(
            label = "Nivell d'activitat",
            options = activityOptions,
            selected = activity,
            onSelected = { activity = it }
        )

        Spacer(Modifier.height(8.dp))

        Button(
            onClick = {
                onSave(UserProfile(name, email, height, weight, goal, activity))
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar canvis")
        }
        OutlinedButton(
            onClick = onCancel,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Cancel·lar")
        }
    }
}