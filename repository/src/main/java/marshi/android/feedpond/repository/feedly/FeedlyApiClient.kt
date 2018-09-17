package marshi.android.feedpond.repository.feedly

import io.reactivex.Single
import retrofit2.http.GET

interface FeedlyApiClient {
  
  @GET("/v3/auth/auth?client_id=4145b94d-8ff9-4c7a-9472-5ef05bbd0b14&redirect_uri=http://localhost&response_type=code&scope=https://cloud.feedly.com/subscriptions")
  fun auth(): Single<String>
  
}
