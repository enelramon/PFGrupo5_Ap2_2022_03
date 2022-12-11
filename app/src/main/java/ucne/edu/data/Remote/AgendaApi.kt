package ucne.edu.data.Remote

import retrofit2.http.*
import ucne.edu.data.Remote.Dto.AgendaDto

interface AgendaApi {
    @GET("/Agenda/GetAgenda")
    suspend fun getAll(): List<AgendaDto>

    @GET("/Agenda/GetAgenda{id}")
    suspend fun getById(@Path("id") id: String): AgendaDto

    @PUT("/Agenda/PutAgenda{id}")
    suspend fun update(@Path("id") id: String, @Body agenda: AgendaDto): AgendaDto

    @POST("/Agenda/PostAgenda")
    suspend fun insert(@Body agenda: AgendaDto): AgendaDto
}