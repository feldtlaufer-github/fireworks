package huecomundo.muhich.fireworks_prime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Rules_Credits extends AppCompatActivity {
    private int rulesPageIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_rules__credits);

        updateRulesPage(0);
        Button prev = (Button)findViewById(R.id.btnPrev);
        prev.setEnabled(false);
    }
    public void clickNext(View v){
        Button prev = (Button)findViewById(R.id.btnPrev);
        prev.setEnabled(true);
        if(rulesPageIndex > 3){
            Button next = (Button)findViewById(R.id.btnNext);
            next.setEnabled(false);
        }
        else updateRulesPage(1);

    }
    public void clickPrev(View v){
        Button next = (Button)findViewById(R.id.btnNext);
        next.setEnabled(true);
        if(rulesPageIndex == 0){
            Button prev = (Button)findViewById(R.id.btnPrev);
            prev.setEnabled(false);
        }
        else updateRulesPage(-1);

    }
    private void updateRulesPage(int incr){
        switch(incr){
            case 0:
                rulesPageIndex = 0;
                break;
            case 1:
                rulesPageIndex++;
                break;
            case -1:
                rulesPageIndex--;
                break;
        }
    }
}
