package es.unex.giiis.asee.executorslab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import java.util.ArrayList;


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
        AppExecutors.getInstance().networkIO().execute(new ReposNetworkLoaderRunnable(
                repos -> mAdapter.swap(repos)
        ));
        mAdapter = new MyAdapter(new ArrayList<>(), this);
        recyclerView.setAdapter(mAdapter);
    }


    @Override
    public void onListInteraction(String url) {
        Uri webpage = Uri.parse("https://git.eclipse.org/r/"+url+"/");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(webIntent);
    }
}
