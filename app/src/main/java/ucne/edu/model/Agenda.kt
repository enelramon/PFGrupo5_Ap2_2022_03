package ucne.edu.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Agendas")
data class Agenda(
    @PrimaryKey(autoGenerate = true)
    val agendaId : Int? = null,
    val nombreAgenda : String,
    val descripcion: String,
    val fecha : String

)