# Fitness App: Pàgina de perfil

Aplicació Android feta amb **Kotlin** i **Jetpack Compose** que permet consultar i editar el perfil d'un usuari. Les dades es guarden només en memòria (sense Firebase).

## Pantalles

- **ProfileScreen**: mostra nom, correu, alçada, pes, objectiu i activitat.
- **EditProfileScreen**: permet modificar les dades i desar o cancel·lar els canvis.

## Estructura

- `MainActivity.kt`: `FitnessApp()`, estat i navegació.
- `ui/screen/ProfileScreen.kt`: pantalla de consulta.
- `ui/screen/EditProfileScreen.kt`: pantalla d'edició.
- `ui/screen/ComponentsPerfil.kt`: `UserProfile`, `ProfileAvatar`, `InfoCard` i `DropdownSelector`.

## Com executar-la

1. Obre el projecte amb Android Studio.
2. Sincronitza Gradle.
3. Prem **Run ▶** amb un emulador o dispositiu.

## Comprovacions

- [x] Es veuen les dades inicials de Laia Soler.
- [x] Editar i **Guardar canvis** actualitza el perfil.
- [x] **Cancel·lar** manté el valor anterior.
