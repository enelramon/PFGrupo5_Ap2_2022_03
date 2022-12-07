package ucne.edu.Data

import androidx.room.Database
import androidx.room.RoomDatabase
import ucne.edu.Data.Dao.AgendaDao
import ucne.edu.Data.Dao.UsuarioDao
import ucne.edu.model.Usuario

@Database(
    entities = [
        Usuario ::class ,
        //Agenda :: class
               ],
    exportSchema = false,
    version = 1
)
abstract class SweetPlansDb : RoomDatabase() {
    abstract val usuarioDao: UsuarioDao
    abstract val AgendaDao : AgendaDao
}