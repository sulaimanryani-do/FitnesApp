package org.insbaixcamp.myapplication.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen(
    profile: UserProfile,
    onEditClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Perfil", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(24.dp))

        ProfileAvatar()
        Spacer(Modifier.height(12.dp))

        Text(profile.name, style = MaterialTheme.typography.titleLarge)
        Text(
            profile.email,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(Modifier.height(24.dp))
        HorizontalDivider()
        Spacer(Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            InfoCard("Alçada", "${profile.height} cm", Modifier.weight(1f))
            InfoCard("Pes", "${profile.weight} kg", Modifier.weight(1f))
        }
        Spacer(Modifier.height(12.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            InfoCard("Objectiu", profile.goal, Modifier.weight(1f))
            InfoCard("Activitat", profile.activity, Modifier.weight(1f))
        }

        Spacer(Modifier.height(32.dp))
        Button(
            onClick = onEditClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Editar")
        }
    }
}