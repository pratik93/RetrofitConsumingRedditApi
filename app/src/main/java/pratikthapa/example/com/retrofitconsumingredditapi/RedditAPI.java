package pratikthapa.example.com.retrofitconsumingredditapi;

import java.util.List;

import pratikthapa.example.com.retrofitconsumingredditapi.model.Feed;
import pratikthapa.example.com.retrofitconsumingredditapi.model.children.Data;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by pratikthapa on 11/8/17.
 */

public interface RedditAPI {

    String BASE_URL = "https://www.reddit.com/";

    @GET(".json")
    Call<Feed> getFeed();


}
