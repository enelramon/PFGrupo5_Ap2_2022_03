package ucne.edu.data.Remote

import retrofit2.http.*
import ucne.edu.data.Remote.Dto.UsuarioDto

interface UsuarioApi {
    @GET("/Usuario/GetUsuario")
    suspend fun getAll(): List<UsuarioDto>

    @GET("/Usuario/GetUsuario{id}")
    suspend fun getById(@Path("id") id: String): UsuarioDto

    @PUT("/Usuario/PutUsuario{id}")
    suspend fun update(@Path("id") id: String, @Body usuario: UsuarioDto): UsuarioDto

    @POST("/Usuario/PostUsuario")
    suspend fun insert(@Body usuario: UsuarioDto): UsuarioDto
}