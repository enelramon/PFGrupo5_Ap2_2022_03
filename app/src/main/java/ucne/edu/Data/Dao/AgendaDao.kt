package ucne.edu.Data.Dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import ucne.edu.model.Agenda

@Dao
interface AgendaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun Insertar (agenda: Agenda)

    @Delete
    suspend fun Eliminar(agenda: Agenda)

    @Query("SELECT * FROM Agendas ORDER BY agendaId")
    fun gesList(): Flow<List<Agenda>>

    @Update
    suspend fun Modificar(agenda: Agenda)


}