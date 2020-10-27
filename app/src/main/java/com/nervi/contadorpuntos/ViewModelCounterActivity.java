package com.nervi.contadorpuntos;

import androidx.lifecycle.ViewModel;

public class ViewModelCounterActivity extends ViewModel {

    private String team1Name;
    private String team2Name;
    private int team1Score = 0;
    private int team2Score = 0;

    public void setTeam1Score(int score) {
        team1Score = score;
    }

    public int getTeam1Score() {
        return team1Score;
    }

    public void setTeam2Score(int score) {
        team2Score = score;
    }
    public int getTeam2Score() {
        return team2Score;
    }


}
