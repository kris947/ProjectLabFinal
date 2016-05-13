import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.Timer;

class Clock {
    
    private int time=300;
    

    public Clock(final JTextField timeField) {
        //timer l�trehoz�sa
        Timer t = new Timer(1000, new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
                	  
                	  int min=time/60;    //perc kisz�m�t�sa
                	  int sec=time-min*60;//m�sodperc kisz�m�t�sa
                	  
                	  if(time>=0){
                		  if(sec>=10) timeField.setText(min+":"     +sec);
                		  else 		 timeField.setText(min+":" +"0"+sec); //ha a sec kevesebb mint 10 0sec form�tumban �rjuk ki
                		  time--; //cs�kkentj�k az id�t
                	  }
                      
                  }
              }
        );
        
        t.start(); 
    }
}