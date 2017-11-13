package pratikthapa.example.com.retrofitconsumingredditapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.InputType;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import pratikthapa.example.com.retrofitconsumingredditapi.adapter.RecyclerAdapter;
import pratikthapa.example.com.retrofitconsumingredditapi.model.Feed;
import pratikthapa.example.com.retrofitconsumingredditapi.model.children.Children;
import pratikthapa.example.com.retrofitconsumingredditapi.model.children.Data;
import pratikthapa.example.com.retrofitconsumingredditapi.model.children.Images;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity  {



    String url = "";
    ArrayList<Images> imagesArrayList;

    RecyclerAdapter recyclerAdapter = null;


    private RecyclerView.Adapter adapter;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    private static final String BASE_URL = "https://www.reddit.com/";
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView =(RecyclerView)findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final RedditAPI redditAPI = retrofit.create(RedditAPI.class);

        Call<Feed> call = redditAPI.getFeed();



        call.enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Call<Feed> call, Response<Feed> response) {



                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();

                Log.d(TAG,"onResponse: Server Response: "+response.toString());
                Log.e(TAG,"onResponse: received information "+response.body().toString());


                ArrayList<Children> childrenArrayList = response.body().getData().getChildren();




                for(int i=0; i<childrenArrayList.size();i++) {

                    try {
                        imagesArrayList = childrenArrayList.get(i).getData().getPreview().getImages();
                    }catch (Exception e){}


                    adapter = new RecyclerAdapter(childrenArrayList, getApplicationContext());
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setHasFixedSize(true);


                    for(int j=0; j<imagesArrayList.size();j++){


                            url = imagesArrayList.get(j).getSource().getUrl();


                    }





                    Log.d(TAG, "onResponse: \n" +
                            "kind: " + childrenArrayList.get(i).getKind() + "\n" +
                            "contest_mode: " + childrenArrayList.get(i).getData().getContest_mode() + "\n" +
                            "subreddit: " + childrenArrayList.get(i).getData().getSubreddit() + "\n" +
                            "author: " + childrenArrayList.get(i).getData().getAuthor() + "\n"+
                            "Image url"+url+ "\n"
                    );

                }

                }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();

            }
        });
    }

}
