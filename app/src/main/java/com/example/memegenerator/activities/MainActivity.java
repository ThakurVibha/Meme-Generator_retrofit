package com.example.memegenerator.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.memegenerator.utils.MemeInterface;
import com.example.memegenerator.models.MemeModel;
import com.example.memegenerator.R;
import com.example.memegenerator.utils.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ImageView memeCard;
    MemeInterface memeInterface;
    Button next, share;
    String currentMeme=null;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        memeCard = findViewById(R.id.meme_cardView);
        share = findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("image/jpg");
                shareIntent.putExtra(Intent.EXTRA_STREAM, currentMeme);
                startActivity(Intent.createChooser(shareIntent, "Share this meme with"));
            }
        });
        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchmemes();
            }
        });
        fetchmemes();
    }

    private void fetchmemes() {
        memeInterface = RetrofitInstance.getRetrofit().create(MemeInterface.class);
        memeInterface.getMemes().enqueue(new Callback<MemeModel>() {
            @Override
            public void onResponse(Call<MemeModel> call, Response<MemeModel> response) {
                MemeModel memeModel = response.body();
                currentMeme=memeModel.getImageUrl();
                Glide.with(MainActivity.this)
                        .load(memeModel.getImageUrl()).override(500, 500)
                        .into(memeCard);

            }

            @Override
            public void onFailure(Call<MemeModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "sorry", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
