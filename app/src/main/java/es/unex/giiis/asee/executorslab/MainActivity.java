package es.unex.giiis.asee.executorslab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import es.unex.giiis.asee.executorslab.model.Repo;


public class MainActivity extends AppCompatActivity implements MyAdapter.OnListInteractionListener{

    private RecyclerView recyclerView;
    private MyAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.repolist);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // Parse json file into JsonReader
        JsonReader reader = new JsonReader(new InputStreamReader(getResources().openRawResource(R.raw.rrecheve_github_repos)));
        // Parse JsonReader into list of Repo using Gson
        List<Repo> repos = Arrays.asList(new Gson().fromJson(reader, Repo[].class));
        mAdapter = new MyAdapter(repos, this);
        recyclerView.setAdapter(mAdapter);
    }


    @Override
    public void onListInteraction(String url) {
        Uri webpage = Uri.parse(url);
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(webIntent);
    }
}
