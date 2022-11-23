package ucne.edu.ui.navegacion

sealed class Screen(
    val route: String
){
    object RegistroUsuarios: Screen("RegistroUsuariosScreen")
    object LoginScreen: Screen("LoginScreen")

}