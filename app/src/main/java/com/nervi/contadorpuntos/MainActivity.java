package com.nervi.contadorpuntos;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.EditText;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Button;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final String TEAM1_NAME = "com.nervi.contadorpuntos.TEAM1_NAME";
    public static final String TEAM2_NAME = "com.nervi.contadorpuntos.TEAM2_NAME";
    private EditText team1;
    private EditText team2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = (Button) findViewById(R.id.botonConfirmar);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendToSecondActivity();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        team1 = (EditText) findViewById(R.id.nameTeam1);
        team2 = (EditText) findViewById(R.id.nameTeam2);
    }

    public void sendToSecondActivity() {
        Intent intent = new Intent(this, CounterActivity.class);
        String team1Name = team1.getText().toString().trim(); //trim() removes blank spaces at first and at end of phrase
        String team2Name = team2.getText().toString().trim();
        if (TextUtils.isEmpty(team1Name)) {
            team1.setError("El nombre no puede estar vacío");
        }
        if (TextUtils.isEmpty(team2Name)) {
            team2.setError("El nombre no puede estar vacío");
        }
        if (!TextUtils.isEmpty(team1Name) && !TextUtils.isEmpty(team2Name)) {
            intent.putExtra(TEAM1_NAME, team1.getText().toString());
            intent.putExtra(TEAM2_NAME, team2.getText().toString());
            startActivity(intent);
        }
    }
}