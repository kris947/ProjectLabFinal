import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.Timer;

class Clock {
    
    private int time=300;
    

    public Clock(final JTextField timeField) {
        //timer létrehozása
        Timer t = new Timer(1000, new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
                	  
                	  int min=time/60;    //perc kiszámítása
                	  int sec=time-min*60;//másodperc kiszámítása
                	  
                	  if(time>=0){
                		  if(sec>=10) timeField.setText(min+":"     +sec);
                		  else 		 timeField.setText(min+":" +"0"+sec); //ha a sec kevesebb mint 10 0sec formátumban írjuk ki
                		  time--; //csökkentjük az idõt
                	  }
                      
                  }
              }
        );
        
        t.start(); 
    }
}