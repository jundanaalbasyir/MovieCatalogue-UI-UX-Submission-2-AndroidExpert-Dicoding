package com.jundana.moviecatalogue;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.jundana.moviecatalogue.model.Movie;

import java.util.Objects;

public class MovieDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        Movie getMovie = intent.getParcelableExtra("MOVIE");
        String movieName = Objects.requireNonNull(getMovie).getMovieName();
        Objects.requireNonNull(getSupportActionBar()).setTitle(movieName);

        ImageView imgPhoto = findViewById(R.id.imageView);
        TextView tvItemDetail = findViewById(R.id.tv_item_detail);

        String movieDetail = getMovie.getMovieDetail();
        int photo = Objects.requireNonNull(getMovie).getPhoto();
        Glide.with(this).load(photo).into(imgPhoto);
        tvItemDetail.setText(movieDetail);
    }
}
