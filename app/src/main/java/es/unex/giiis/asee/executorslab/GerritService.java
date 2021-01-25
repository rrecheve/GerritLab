package es.unex.giiis.asee.executorslab;

import java.util.List;

import es.unex.giiis.asee.executorslab.model.Ticket;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GerritService {
    @GET("r/changes/?q=status:open")
    Call<List<Ticket>> listTickets();
}

