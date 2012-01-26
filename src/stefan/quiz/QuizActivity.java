package stefan.quiz;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class QuizActivity extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
	Spiellogik spiel;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        spiel = new Spiellogik();
        
        for(int n=1; n<=4; n++) {
        	Button button = null;
        	switch (n) {
        	case 1:
        		button = (Button) findViewById(R.id.antwort1);
        		button.setOnClickListener(this);
        		break;
        	
        	case 2:
        		button = (Button) findViewById(R.id.antwort2);
        		button.setOnClickListener(this);
        		break;
        
        	case 3:
        		button = (Button) findViewById(R.id.antwort3);
        		button.setOnClickListener(this);
        		break;
        	
        	case 4:
        		button = (Button) findViewById(R.id.antwort4);
        		button.setOnClickListener(this);
        		break;
        	}
        }
        
        //1. Frage laden
        spiel.fragen[spiel.aktFrage].anzeigen(this);
        
    }

	@Override
	public void onClick(View v) {
		int id = v.getId();
		
		if(id == R.id.antwort1) {
			spiel.auswerten(1, this);
		} else if(id == R.id.antwort2) {
			spiel.auswerten(2, this);
		} else if(id == R.id.antwort3) {
			spiel.auswerten(3, this);
		} else if(id == R.id.antwort4) {
			spiel.auswerten(4, this);
		}
		
	}
    
    
    
}