package huecomundo.muhich.fireworks_prime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Settings extends AppCompatActivity {
    public static boolean isMuted = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_settings);

        setMuteText();
    }
    private void setMuteText(){
        Button btnSoundFX = (Button) findViewById(R.id.btnMuteVolume);
        if(isMuted){ btnSoundFX.setText("Unmute Sound Effects"); }
        else btnSoundFX.setText("Mute Sound Effects");
    }

    public void toggleMute(View v){
        isMuted = !isMuted;
        setMuteText();
    }
}
