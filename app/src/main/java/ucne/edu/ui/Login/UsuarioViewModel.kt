package ucne.edu.ui.Login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ucne.edu.Data.Repository.UsuarioRepository
import ucne.edu.model.Usuario
import javax.inject.Inject

data class UsuarioListUiState(
    val lista: List<Usuario> = emptyList()
)
@HiltViewModel
class UsuarioViewModel  @Inject constructor (
    val usuarioRepository: UsuarioRepository
): ViewModel(){

    var nombre by mutableStateOf("")
    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var usuario = usuarioRepository.Lista()
        private set


    var uiState by mutableStateOf(UsuarioListUiState())
        private set

    init{
        viewModelScope.launch {
            usuarioRepository.Lista().collect(){ list->
                uiState = uiState.copy(list)
            }
        }
    }
    fun Guardar(){
        viewModelScope.launch {
            usuarioRepository.Insertar(
                Usuario(
                    nombre = nombre,
                    email = email,
                    password = password
                )
            )
        }
    }
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
}