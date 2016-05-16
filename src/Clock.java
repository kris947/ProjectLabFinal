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
        //timer l�trehoz�sa
    	
    	ActionListener al = new ActionListener() 
        {
        public void actionPerformed(ActionEvent e)
        {
                	  
                	  int min=time/60;    //perc kisz�m�t�sa
                	  int sec=time-min*60;//m�sodperc kisz�m�t�sa
                	  
                	  if(time>=0){
                		  if(!paused)time--; //n�velj�k az id�t
                		  if(sec>=10) ido = (min+":"     +sec);
                		  else 		  ido = (min+":" +"0"+sec); //ha a sec kevesebb mint 10 0sec form�tumban �rjuk ki
                		  
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