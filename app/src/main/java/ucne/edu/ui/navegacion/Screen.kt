package ucne.edu.ui.navegacion

sealed class Screen(
    val route: String
){
    object RegistroUsuarios: Screen("RegistroUsuariosScreen")
    object LoginScreen: Screen("LoginScreen")
    object ConsultaAgenda: Screen("ConsultaAgenda")
    object RegistroAgenda: Screen("RegistroAgenda")
}