import retrofit2.http.GET

interface ApiService {
    @GET("todos")
    suspend fun getUser(): List<UserResponse>
}
