package es.unex.giiis.asee.executorslab;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;

import es.unex.giiis.asee.executorslab.model.Ticket;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ReposNetworkLoaderRunnable implements Runnable{

    private final OnReposLoadedListener mOnReposLoadedListener;

    public ReposNetworkLoaderRunnable(OnReposLoadedListener onReposLoadedListener){
        mOnReposLoadedListener = onReposLoadedListener;
    }

    @Override
    public void run() {
        // Instanciación de Retrofit y llamada síncrona
        // Llamada al Listener con los datos obtenidos
        // Create a very simple REST adapter which points to the API.

        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://git.eclipse.org/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        // Create an instance of our GitHub API interface.
        GerritService service = retrofit.create(GerritService.class);
        // Synchronous call
        try {
            List<Ticket> repos = service.listTickets().execute().body();
            AppExecutors.getInstance().mainThread().execute(() -> mOnReposLoadedListener.onReposLoaded(repos));
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
