package com.nervi.contadorpuntos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CounterActivity extends AppCompatActivity {

    private ViewModelCounterActivity viewModel;

    private TextView team1Score;
    private TextView team2Score;
    private Button button3pTeam1, button3pTeam2, button2pTeam1, button2pTeam2, button1pTeam1, button1pTeam2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        // Using ViewModel to store data in changes
        viewModel = new ViewModelProvider(this).get(ViewModelCounterActivity.class);
        // Get intent from "main" activity
        Intent intent = getIntent();
        // Linking Widgets (Views)
        TextView team1Name = findViewById(R.id.textViewE1);
        TextView team2Name = findViewById(R.id.textViewE2);
        team1Score = findViewById(R.id.textViewSc1);
        team2Score = findViewById(R.id.textViewSc2);

        button3pTeam1 = findViewById(R.id.button3pT1);
        button3pTeam2 = findViewById(R.id.button3pT2);
        button2pTeam1 = findViewById(R.id.button2pT1);
        button2pTeam2 = findViewById(R.id.button2pT2);
        button1pTeam1 = findViewById(R.id.button1pT1);
        button1pTeam2 = findViewById(R.id.button1pT2);
        // Set teams names to TextViews (Maybe ok on window orientation changes, without passing values to ViewModel)
        team1Name.setText(intent.getStringExtra(MainActivity.TEAM1_NAME));
        team2Name.setText(intent.getStringExtra(MainActivity.TEAM2_NAME));
        // Set teams scores to TextsViews
        team1Score.setText(String.valueOf(viewModel.getTeam1Score()));
        team2Score.setText(String.valueOf(viewModel.getTeam2Score()));
    }

    public void increaseScore(View v) {
        int idButton = v.getId();

        if (idButton == button3pTeam1.getId()) {
            viewModel.setTeam1Score(viewModel.getTeam1Score() + 3);
            team1Score.setText(String.valueOf(viewModel.getTeam1Score()));
        } else if (idButton == button3pTeam2.getId()) {
            viewModel.setTeam2Score(viewModel.getTeam2Score() + 3);
            team2Score.setText(String.valueOf(viewModel.getTeam2Score()));
        } else if (idButton == button2pTeam1.getId()) {
            viewModel.setTeam1Score(viewModel.getTeam1Score() + 2);
            team1Score.setText(String.valueOf(viewModel.getTeam1Score()));
        } else if (idButton == button2pTeam2.getId()) {
            viewModel.setTeam2Score(viewModel.getTeam2Score() + 2);
            team2Score.setText(String.valueOf(viewModel.getTeam2Score()));
        } else if (idButton == button1pTeam1.getId()) {
            viewModel.setTeam1Score(viewModel.getTeam1Score() + 1);
            team1Score.setText(String.valueOf(viewModel.getTeam1Score()));
        } else if (idButton == button1pTeam2.getId()) {
            viewModel.setTeam2Score(viewModel.getTeam2Score() + 1);
            team2Score.setText(String.valueOf(viewModel.getTeam2Score()));
        }
    }
}