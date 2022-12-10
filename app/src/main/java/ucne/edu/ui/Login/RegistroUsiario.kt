package ucne.edu.ui.Login

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import ucne.edu.R
import ucne.edu.ui.navegacion.Screen

@OptIn(ExperimentalUnitApi::class)
@Composable
fun RegistroUsiario(
    navHostController: NavHostController,
    usuarioViewModel: UsuarioViewModel = hiltViewModel()
) {

    val context = LocalContext.current

    val image = painterResource(id = R.drawable.registro)

    val nameValue = remember { mutableStateOf("") }
    val emailValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }
    val confirmPasswordValue = remember { mutableStateOf("") }

    val passwordVisibility = remember { mutableStateOf(false) }
    val confirmPasswordVisibility = remember { mutableStateOf(false) }

    fun validateName(evaluacion: String) : Boolean{
        return evaluacion.isNotEmpty() && evaluacion.length > 2
    }
    fun validateEmail(email: String): Boolean {
        var patron = "([a-z0-9]+@[a-z]+\\.[a-z]{2,3})".toRegex()
        return patron.containsMatchIn(email)
    }

    fun validatePassword(password: String): Boolean {
        var valido = "([A-Z0-9a-z])".toRegex()
        return valido.containsMatchIn(password)
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            contentAlignment = Alignment.TopCenter
        ) {
            Image(
                painter = image,
                contentDescription = null
            )
        }


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.70f)
                .clip(RoundedCornerShape(30.dp, 30.dp))
                .background(Color.White)
                .verticalScroll(rememberScrollState())
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Registrate", fontSize = TextUnit(30F, TextUnitType.Sp),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    letterSpacing = TextUnit(2F, TextUnitType.Sp)
                )
            )
            Spacer(modifier = Modifier.padding(20.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                OutlinedTextField(
                    value = nameValue.value,
                    onValueChange = { nameValue.value = it },
                    label = { Text(text = "Nombre") },
                    placeholder = { Text(text = "Nombre") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(0.8f)
                )

                OutlinedTextField(
                    value = emailValue.value,
                    onValueChange = { emailValue.value = it },
                    label = { Text(text = "Email") },
                    placeholder = { Text(text = "Email") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(0.8f)
                )

                OutlinedTextField(
                    value = passwordValue.value,
                    onValueChange = { passwordValue.value = it },
                    label = { Text(text = "Contraseña") },
                    placeholder = { Text(text = "Contraseña") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(0.8f),
                    trailingIcon = {
                        IconButton(onClick = {
                            passwordVisibility.value = !passwordVisibility.value
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.password_eye), contentDescription = null,
                                tint = if (passwordVisibility.value) colorResource(id = R.color.Verde2) else Color.Gray
                            )
                        }
                    },
                    visualTransformation = if (passwordVisibility.value) VisualTransformation.None
                    else PasswordVisualTransformation()
                )

                OutlinedTextField(
                    value = confirmPasswordValue.value,
                    onValueChange = { confirmPasswordValue.value = it },
                    label = { Text(text = "Confirmar Contraseña") },
                    placeholder = { Text(text = "Confirmar Contraseña") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(0.8f),
                    trailingIcon = {
                        IconButton(onClick = {
                            confirmPasswordVisibility.value = !confirmPasswordVisibility.value
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.password_eye), contentDescription = null,
                                tint = if (confirmPasswordVisibility.value) colorResource(id = R.color.Verde2) else Color.Gray
                            )
                        }
                    },
                    visualTransformation = if (confirmPasswordVisibility.value) VisualTransformation.None
                    else PasswordVisualTransformation()
                )
                Spacer(modifier = Modifier.padding(10.dp))
                androidx.compose.material3.OutlinedButton(
                    onClick = {}
                ) {
                    Button(
                        onClick = {
                            if (validateEmail(usuarioViewModel.email)) {
                                Toast.makeText(
                                    context,
                                    "Revise el formato del Email",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else if (validateName(usuarioViewModel.nombre)) {
                                Toast.makeText(
                                    context,
                                    "Por favor revise el Nombre",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else if (validatePassword(usuarioViewModel.password)) {
                                Toast.makeText(
                                    context,
                                    "Contraseña incorrecta",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else if (!validateEmail(usuarioViewModel.email) && !validatePassword(
                                    usuarioViewModel.password
                                ) && !validateName(usuarioViewModel.nombre)
                            ) {
                                usuarioViewModel.Guardar()
                                navHostController.navigate(Screen.LoginScreen.route)
                            }
                        }, modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.Verde3))
                    ) {
                        Text(text = "Registrar", fontSize = TextUnit(20F, TextUnitType.Sp))
                    }
                }

                Text(
                    text = "Login",
                    modifier = Modifier.clickable(onClick = {
                        navHostController.navigate(Screen.LoginScreen.route)
                    })
                )
                Spacer(modifier = Modifier.padding(20.dp))



            }
        }
    }
}