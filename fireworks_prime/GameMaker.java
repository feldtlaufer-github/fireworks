package huecomundo.muhich.fireworks_prime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Collections;

public class GameMaker extends AppCompatActivity {
    public static FireworkGame fireworkGame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_game_maker);
    }

    public void createGame(View v){
        fireworkGame = new FireworkGame();
        EditText etPlayerA = (EditText) findViewById(R.id.etPlayerA);
        EditText etPlayerB = (EditText) findViewById(R.id.etPlayerB);
        EditText etPlayerC = (EditText) findViewById(R.id.etPlayerC);
        EditText etPlayerD = (EditText) findViewById(R.id.etPlayerD);
        EditText etPlayerE = (EditText) findViewById(R.id.etPlayerE);
        EditText[] editTexts = {etPlayerA, etPlayerB, etPlayerC, etPlayerD, etPlayerE};

        CheckBox cbPlayerA = (CheckBox) findViewById(R.id.cbPlayerA);
        CheckBox cbPlayerB = (CheckBox) findViewById(R.id.cbPlayerB);
        CheckBox cbPlayerC = (CheckBox) findViewById(R.id.cbPlayerC);
        CheckBox cbPlayerD = (CheckBox) findViewById(R.id.cbPlayerD);
        CheckBox cbPlayerE = (CheckBox) findViewById(R.id.cbPlayerE);
        CheckBox[] checkBoxes = {cbPlayerA, cbPlayerB, cbPlayerC, cbPlayerD, cbPlayerE};

        for(int i = 0; i < checkBoxes.length; i++){
            if(checkBoxes[i].isChecked() && editTexts[i].getText().toString().length() > 0){
                fireworkGame.addPlayer(editTexts[i].getText().toString());
            }
        }
        if(fireworkGame.getPlayerList().size() >= 2){
            //randomize the players
            Collections.shuffle(fireworkGame.getPlayerList());
            fireworkGame.startGame();
            startActivity(new Intent(GameMaker.this, Board_Greg.class));
        }
        else{
            //reset the activity because not enough players or improper names
            startActivity(new Intent(GameMaker.this, GameMaker.class));
            Toast.makeText(getApplicationContext(), "ERROR: There were not enough players to start a game" +
                            " or there was a blank name checked.",
                    Toast.LENGTH_LONG).show();
        }
        this.finish();
    }
}
