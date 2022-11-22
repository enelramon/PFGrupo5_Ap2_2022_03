package ucne.edu.Data.Repository

import ucne.edu.Data.SweetPlansDb
import ucne.edu.model.Usuario
import javax.inject.Inject

class UsuarioRepository @Inject constructor(
    val db: SweetPlansDb
) {
    suspend fun Insertar(usuario: Usuario)=db.usuarioDao.Insertar(usuario)

    fun Lista()= db.usuarioDao.Lista()

}