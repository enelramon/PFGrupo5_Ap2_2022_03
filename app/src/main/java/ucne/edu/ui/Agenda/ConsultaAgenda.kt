package ucne.edu.ui.Agenda

import android.widget.CalendarView
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import ucne.edu.R
import ucne.edu.ui.navegacion.Screen

@Composable
fun ConsultaAgenda(
    navHostController: NavHostController,
    agendaViewModel: AgendaViewModel = hiltViewModel()
) {
    Scaffold(

        bottomBar = {
            BottomAppBar(

                // Defaults to null, that is, No cutout
                backgroundColor = colorResource(id = R.color.Verde4),
                cutoutShape = MaterialTheme.shapes.small.copy(
                    CornerSize(percent = 50)
                )
            ) {

                /* Bottom app bar content */
                Spacer(modifier = Modifier.padding(15.dp))
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        Icons.Filled.Home,
                        contentDescription = "Inicio",
                        modifier = Modifier
                            .clickable(onClick = {navHostController.navigate(Screen.InicioScreen.route)})
                            .size(40 .dp)
                    )
                }
                Spacer(modifier = Modifier.padding(47.dp))
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        Icons.Filled.Notifications,
                        contentDescription = "Lista de pendientes",
                        modifier = Modifier
                            .clickable(onClick = {navHostController.navigate(Screen.ConsultaAgenda.route)})
                            .size(40.dp)
                    )
                }

                Spacer(modifier = Modifier.padding(50.dp))
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painterResource(id = R.drawable.calendario),
                        contentDescription = "Calendario",
                        modifier = Modifier
                            .clickable(onClick = {navHostController.navigate(Screen.ConsultaAgenda.route)})
                            .size(40.dp)
                    )
                }

            }
        }
    )
    {
        var viewModel: AgendaViewModel = hiltViewModel()
        val ConsultaAgenda = viewModel.agenda.collectAsState(initial = emptyList())
        var date by remember { mutableStateOf("") }

        Scaffold(
            topBar = {
                TopAppBar(title = {
                    Text(text = "Calendario")
                },
                    backgroundColor = colorResource(id = R.color.Verde2)
                )
            },
        ) {
            it

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                AndroidView(factory = { CalendarView(it) }, update = {
                    it.setOnDateChangeListener { calendarView, year, month, day ->
                        date = "$day - ${month + 1} - $year"
                    }
                }
                )
                //Text(text = date)
                LazyColumn(
                    modifier = Modifier.fillMaxWidth()
                ){
                    items(ConsultaAgenda.value){
                            agenda ->
                        Card(
                            backgroundColor = Color.LightGray,
                            elevation = (10.dp),
                            modifier = Modifier.padding(all = 16.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(all = 8.dp)
                            ) {
                                Text(text = "Tarea: ${agenda.nombreAgenda}")
                                Text(text = "Descripcion: ${agenda.descripcion}")
                                Text(text = "Fecha:  ${agenda.fecha}")
                                IconButton(onClick = { viewModel.Eliminar(agenda) })
                                {
                                    Icon(imageVector = Icons.Filled.Clear,
                                        contentDescription = "Listo",
                                        tint = Color.Red, modifier = Modifier.size(10.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }

        }

    }
}