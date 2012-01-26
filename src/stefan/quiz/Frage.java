package stefan.quiz;

import stefan.quiz.R.id;
import android.app.Activity;
import android.provider.MediaStore.Audio;
import android.widget.TextView;
import android.widget.Button;

public class Frage {
	private String frage;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private int loesung;

	public Frage(String f, String o1, String o2, String o3, String o4, int l) {
		frage = f;
		option1 = o1;
		option2 = o2;
		option3 = o3;
		option4 = o4;
		loesung = l;
	}
	
	
	public void anzeigen(Activity quizAktivity) {
		//setzen der Fragen und Texte
		((TextView) quizAktivity.findViewById(id.frage)).setText(frage);
		((Button) quizAktivity.findViewById(id.antwort1)).setText(option1);
		((Button) quizAktivity.findViewById(id.antwort2)).setText(option2);
		((Button) quizAktivity.findViewById(id.antwort3)).setText(option3);
		((Button) quizAktivity.findViewById(id.antwort4)).setText(option4);
	}
	
	public boolean richtig(int ausgewaehlt) {
		if(this.loesung == ausgewaehlt)
			return true;
		else
			return false;
	}
	
}
