package com.jundana.moviecatalogue.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jundana.moviecatalogue.R;
import com.jundana.moviecatalogue.adapter.MovieAdapter;
import com.jundana.moviecatalogue.helper.MoviesData;
import com.jundana.moviecatalogue.model.Movie;

import java.util.ArrayList;

public class MovieFragment extends Fragment {
    private RecyclerView rvMovies;
    private ArrayList<Movie> list = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedIntanceState) {
        View view = inflater.inflate(R.layout.fragment_movie, container, false);

        rvMovies = view.findViewById(R.id.rv_movie);
        rvMovies.setHasFixedSize(true);

        list.addAll(MoviesData.getListData());
        showRecyclerList();
        return view;
    }

    private void showRecyclerList() {
        rvMovies.setLayoutManager(new LinearLayoutManager(getContext()));
        MovieAdapter listMovieAdapter = new MovieAdapter(getContext(), list);
        rvMovies.setAdapter(listMovieAdapter);
    }
}
