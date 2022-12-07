package ucne.edu.Data.Repository

import kotlinx.coroutines.flow.Flow
import ucne.edu.Data.SweetPlansDb
import ucne.edu.model.Agenda
import javax.inject.Inject

class AgendaRepository @Inject constructor(
    val db: SweetPlansDb
) {

    suspend fun Insertar(agenda: Agenda) =
        db.AgendaDao.Insertar(agenda)

    suspend fun Eliminar(agenda: Agenda) = db.AgendaDao.Eliminar(agenda)

    fun getList(): Flow<List<Agenda>> = db.AgendaDao.gesList()

}