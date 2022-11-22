package ucne.edu.Data.Dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import ucne.edu.model.Usuario

@Dao
interface UsuarioDao  {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun Insertar(usuario: Usuario)

    @Delete
    suspend fun Eliminar(usuario: Usuario)

    @Query(
        "SELECT * FROM usuario ORDER BY nombre"
    )
    fun Lista(): Flow<List<Usuario>>
}