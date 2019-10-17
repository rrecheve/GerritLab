package es.unex.giiis.asee.retrofit101;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/*
    Steps:
    * Create empty project
    * Declare INTERNET permission
    * Add dependencies:
        - com.squareup.retrofit2
        - com.squareup.retrofit2:converter-gson
    * Add pojos: Repo and Owner from jsonschema2pojo
    * Define service interface
    * Create REST adapter
    * Create a service implementation
    * Create a call
    * Use the call async'ly
        - define callbacks: onReponse & onFailure
 */


public class MainActivity extends AppCompatActivity implements MyAdapter.OnListInteractionListener{

    private RecyclerView recyclerView;
    private MyAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public interface GitHubService {
        @GET("users/{user}/repos")
        Call<List<Repo>> listRepos(@Path("user") String user);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.repolist);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        List<Repo> myDataset = new ArrayList<Repo>();
        mAdapter = new MyAdapter(myDataset, this);
        recyclerView.setAdapter(mAdapter);

        // Create a very simple REST adapter which points the API.
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Create an instance of our GitHub API interface.
        GitHubService service = retrofit.create(GitHubService.class);

        // Create a call instance for looking up repos.
        Call<List<Repo>> call = service.listRepos("rrecheve");

        // Fetch and print a list of the contributors to the library.
        // Async call
        call.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                if (response.isSuccessful()) {
                    // tasks available
                    List<Repo> repos = response.body();
                    mAdapter.swap(repos);
                    for (Repo repo : repos) {
                        Log.i("Retrofit101","name: "+repo.getName()+
                                " created at: "+repo.getCreatedAt());
                    }
                } else {
                    // error response, no access to resource?
                    Log.d("REtrofit101", "RESPONSE NOOK");
                }
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                // something went completely south (like no internet connection)
                Log.d("Error", t.getMessage());
            }
        });
    }

    @Override
    public void onListInteraction(String url) {
        Uri webpage = Uri.parse(url);
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(webIntent);
    }
}
