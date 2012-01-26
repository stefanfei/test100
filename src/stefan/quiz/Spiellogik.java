package stefan.quiz;

import stefan.quiz.R.id;
import android.app.Activity;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;


class Spiellogik {
   final int ANZAHL_FRAGEN = 8;

   Frage[] fragen = new Frage[ANZAHL_FRAGEN];
   byte aktFrage = 0;
   int gewinnstufe = 0;

   Spiellogik() {
      // Fragen erzeugen
	   
	  /********  Disney  *********/
      fragen[0] = new Frage("Wie heißt der kleine Berater Pinocchios?",
                            "Jimmy, die Grille", "Jim Jarmusch", "Jiminiy Grille", "Jimmy, die Zikade", 3);
      fragen[1] = new Frage("Mit welchem Vogel fliegen Bernard und Bianca?",
                             "Airbus", "Adler", "Taube", "Albatros", 4);
      fragen[2] = new Frage("Wer spricht den Albatros Orville?",
                            "H. Juhnke", "D. Hallervorden", "B. Pastewka", "S. Raab", 1);
      fragen[3] = new Frage("Welcher Schauspieler spricht Prinz John?",
                            "G. Fröbe", "H. Rühmann", "P. Ustinov", "Ch. Lee", 3);
      fragen[4] = new Frage("Welches war der erste abendfüllende Disney-Film?",
                            "Schneewittchen", "Fantasia", "Bambi", "Aristocats", 1);
      fragen[5] = new Frage("Wo lebt Peter Pan?",
                            "Nummerland", "Kummerland", "Nimmerland", "Lummerland", 3);
      fragen[6] = new Frage("Was raucht Roger aus 101 Dalmatiner?",
                            "Zigarette", "Gras", "Pfeife", "Zigarre", 3);
      fragen[7] = new Frage("Welcher Disney-Film war der kommerziell erfolgreichste?",
                            "Aristocats", "Bambi", "Tarzan", "Schneewittchen", 4);
	   
   }

   void auswerten(int schalter, Activity quizActivity) {

      if (!fragen[aktFrage].richtig(schalter)) {  // falsch beantwortet
         if (gewinnstufe == 0) {
        	 Toast.makeText(quizActivity, "Leider nichts gewonnen.  :-(", Toast.LENGTH_LONG).show();
         }
         else {
     	 	String str = "Sie haben Gewinnstufe " + gewinnstufe + " erreicht!  :-)  - Glückwunsch!!!";
    	 	Toast.makeText(quizActivity, str, Toast.LENGTH_LONG).show();
         }
         // Schalter deaktivieren
         ((Button) quizActivity.findViewById(id.antwort1)).setEnabled(false);
         ((Button) quizActivity.findViewById(id.antwort2)).setEnabled(false);
         ((Button) quizActivity.findViewById(id.antwort3)).setEnabled(false);
         ((Button) quizActivity.findViewById(id.antwort4)).setEnabled(false);

      } else {
    	 if (aktFrage < ANZAHL_FRAGEN-1) {
            fragen[++aktFrage].anzeigen(quizActivity);

            gewinnstufe++;
            ((ProgressBar) quizActivity.findViewById(id.progressBar1)).setProgress(gewinnstufe);
         }
      	 else {
      		gewinnstufe++;
      		((ProgressBar) quizActivity.findViewById(id.progressBar1)).setProgress(gewinnstufe);
             
      		String str = "Super, Sie haben alles richtig beantwortet!!!";
      		Toast.makeText(quizActivity, str, Toast.LENGTH_LONG).show();

      		// Schalter deaktivieren
      		((Button) quizActivity.findViewById(id.antwort1)).setEnabled(false);
      		((Button) quizActivity.findViewById(id.antwort2)).setEnabled(false);
      		((Button) quizActivity.findViewById(id.antwort3)).setEnabled(false);
      		((Button) quizActivity.findViewById(id.antwort4)).setEnabled(false);
      	 }
      }
   }
}