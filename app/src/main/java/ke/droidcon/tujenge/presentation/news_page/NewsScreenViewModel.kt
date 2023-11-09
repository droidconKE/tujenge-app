package ke.droidcon.tujenge.presentation.news_page

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ke.droidcon.tujenge.data.remote.dto.NewsItem
import ke.droidcon.tujenge.data.remote.dto.NewsResponse
import ke.droidcon.tujenge.data.remote.retrofit.RetrofitProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsScreenViewModel : ViewModel() {

    // Define a StateFlow to hold the current state
    private val _newsState = MutableStateFlow<List<NewsItem>>(emptyList())
    val newsState: StateFlow<List<NewsItem>> = _newsState

    fun  getEggCollectionList(){
        viewModelScope.launch {

            try {
                val category = "science" // Replace with the actual category name
                val call: Call<NewsResponse> = RetrofitProvider.createNewsFetchingService().getNewsByCategory(category)

                call.enqueue(object : Callback<NewsResponse> {
                    override fun onResponse(
                        call: Call<NewsResponse>,
                        response: Response<NewsResponse>
                    ) {
                        if (response.isSuccessful) {
                            val newsResponse = response.body()
                            newsResponse?.let {
                                _newsState.value = it.data
                            }
                        } else {
                            Log.d("RESPONSE :->", "unsuccessful")
                        }
                    }

                    override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                        // Handle the failure
                    }
                })


            }catch (e:Exception){
                Log.d("fetching error:->", e.message.toString());
            }
        }
    }

}