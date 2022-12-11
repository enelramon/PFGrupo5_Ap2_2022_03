package ucne.edu.ui.Inicio

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ucne.edu.R

@Composable
fun IncioScreen(
    navHostController: NavHostController
){

    val imagen = painterResource(id = R.drawable.sweetplans)

    Scaffold(

        floatingActionButton = {
            FloatingActionButton(onClick = { /* ... */ }) {
                Modifier.background(colorResource(id = R.color.Verde2))
                /* FAB content */
                Icon(
                    Icons.Filled.Add,
                    contentDescription = "Agregar",
                    modifier = Modifier
                        .size(40.dp), tint = Color.White)
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,

        bottomBar = {
            BottomAppBar(

                // Defaults to null, that is, No cutout

                cutoutShape = MaterialTheme.shapes.small.copy(
                    CornerSize(percent = 50)
                )
            ) {

                /* Bottom app bar content */
                Spacer(modifier = Modifier.padding(5.dp))
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        Icons.Filled.Home,
                        contentDescription = "Lista de tarea",
                        modifier = Modifier.size(40 .dp))
                }
                Spacer(modifier = Modifier.padding(13.dp))
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        Icons.Filled.Notifications,
                        contentDescription = "Lista de pendientes",
                        modifier = Modifier.size(40.dp))
                }

                Spacer(modifier = Modifier.padding(53.dp))
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        Icons.Filled.Edit,
                        contentDescription = "Lista de pendientes",
                        modifier = Modifier.size(40.dp))
                }
                Spacer(modifier = Modifier.padding(13.dp))
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        Icons.Filled.Edit,
                        contentDescription = "Lista de pendientes",
                        modifier = Modifier.size(40.dp))
                }
            }
        }
    ) {
        // Screen content
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter){

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White), contentAlignment = Alignment.TopCenter
            ) {

                Image(
                    painter = imagen,
                    contentDescription = null
                )
            }

        }
    }

}
