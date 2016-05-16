import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.Timer;



class Clock {
    
    private int time=600;
    String ido = "";
    boolean paused = false;
    Timer t;
    
    public Clock() 
    {
        //timer létrehozása
    	
    	ActionListener al = new ActionListener() 
        {
        public void actionPerformed(ActionEvent e)
        {
                	  
                	  int min=time/60;    //perc kiszámítása
                	  int sec=time-min*60;//másodperc kiszámítása
                	  
                	  if(time>=0){
                		  if(!paused)time--; //növeljük az idõt
                		  if(sec>=10) ido = (min+":"     +sec);
                		  else 		  ido = (min+":" +"0"+sec); //ha a sec kevesebb mint 10 0sec formátumban írjuk ki
                		  
                	  }          
        }};
    	
        t = new Timer(1000,al);
  
    }
    
    public String gettime(){return ido;}
    public int gettimeint(){return time;}
    public void pause()
    {
		boolean tmp = paused ;
		if(!tmp) paused = true;
		if(tmp) paused = false;	
    }
    
    public boolean getpause(){return paused;}
    public void start(){t.start();}
    
}