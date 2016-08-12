package huecomundo.muhich.fireworks_prime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
    }
    public void gotoGameMaker(View v){ startActivity(new Intent(Main.this, GameMaker.class)); }
    public void gotoRules_Credits(View v){
        startActivity(new Intent(Main.this, Rules_Credits.class));
    }
    public void gotoSettings(View v){ startActivity(new Intent(Main.this, Settings.class)); }

}