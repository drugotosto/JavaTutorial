package ferrero.com.beatBox;

import ferrero.com.annotations.*;

import javax.sound.midi.*;

@MyClassInfoAnnotation (
	date="14/03/2018",
	comment="Classe di prova per la costruzione di un BeatBox che serve per prendere confidenza con l'argomento riguardante le eccezioni che possono essere generate da metodi richiosi' e su come gestire il problema"
)
public class MusicTest {  
       
     public static void main(String[] args) {
        MusicTest mini = new MusicTest();
        if (args.length < 2) {
        		int instrument = Integer.parseInt("80");
            int note = Integer.parseInt("50");
            mini.play(instrument, note);
        } else {
            int instrument = Integer.parseInt(args[0]);
            int note = Integer.parseInt(args[1]);
            mini.play(instrument, note);
        }
     }

    public void play(int instrument, int note) {

      try {
 
         Sequencer player = MidiSystem.getSequencer();         
         player.open();
        
         Sequence seq = new Sequence(Sequence.PPQ, 4);         
         Track track = seq.createTrack();  
          
         MidiEvent event = null;

         ShortMessage first = new ShortMessage();
         // "128" Tipo del messaggio che definisce il tipo di strumento che verrà suonato nel canale 1
         first.setMessage(192, 1, instrument, 0);
         MidiEvent changeInstrument = new MidiEvent(first, 1); 
         track.add(changeInstrument);

         
         ShortMessage a = new ShortMessage();
         // "128" Tipo del messaggio che definire quando iniziarà ad essere suonata la nota
         a.setMessage(144, 1, note, 100);
         MidiEvent noteOn = new MidiEvent(a, 1); 
         track.add(noteOn);

         ShortMessage b = new ShortMessage();
         // "128" Tipo del messaggio che definisce fino a quando la nota verrà suonata
         b.setMessage(128, 1, note, 100);
         MidiEvent noteOff = new MidiEvent(b, 16); 
         track.add(noteOff);
         player.setSequence(seq); 
         player.start();
         // new
	     Thread.sleep(5000);
	     player.close();
         System.exit(0);

      } catch (Exception ex) {ex.printStackTrace();}
  } // close play

} // close class
