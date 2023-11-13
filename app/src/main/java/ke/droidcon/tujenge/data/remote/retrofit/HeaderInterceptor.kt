package ke.droidcon.tujenge.data.remote.retrofit

import okhttp3.Interceptor

object HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        val request = chain.request()
        val newRequest = request.newBuilder()
            .addHeader("Authorization", "Bearer ")
            .build()
        return chain.proceed(newRequest)
    }
}
