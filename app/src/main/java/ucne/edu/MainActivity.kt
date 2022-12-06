package ucne.edu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ucne.edu.ui.Agenda.ConsultaAgenda
import ucne.edu.ui.Login.LoginScreen
import ucne.edu.ui.Login.RegistroUsiario
import ucne.edu.ui.navegacion.Screen
import ucne.edu.ui.theme.ProyectoAplicada2Theme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProyectoAplicada2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp(){
    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = Screen.LoginScreen.route) {
        composable(Screen.LoginScreen.route) {
            LoginScreen(navHostController = navHostController)
        }
        composable(Screen.RegistroUsuarios.route) {
            RegistroUsiario(navHostController = navHostController)
        }
        composable(Screen.ConsultaAgenda.route){
            ConsultaAgenda(navHostController = navHostController)
        }

    }
}