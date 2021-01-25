package es.unex.giiis.asee.executorslab;

import java.util.List;

import es.unex.giiis.asee.executorslab.model.Ticket;

public interface OnReposLoadedListener {
    public void onReposLoaded(List<Ticket> repos);

}
