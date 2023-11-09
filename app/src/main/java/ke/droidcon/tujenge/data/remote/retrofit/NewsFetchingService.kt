package ke.droidcon.tujenge.data.remote.retrofit

import ke.droidcon.tujenge.data.remote.dto.NewsResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface NewsFetchingService {

    @GET("news?category={category_name}")
    fun getNewsByCategory(@Path("category_name") categoryName: String): Call<NewsResponse>

}
