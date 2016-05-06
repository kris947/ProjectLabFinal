//Ez szar így ...
public class ReplicatorThread extends Thread {
			Replicator r=null;
		  public ReplicatorThread(Map map){
		    r=new Replicator(map,1);
		  }

		  public void run(){

		    try {

		      for(;;){
		        r.RandDirection();
		       for(int i=0;i<r.RandValue();i++){
		    	   r.move();
		       }
		        Thread.sleep(1000);
		      }

		    } catch(InterruptedException e) {

		      
		    }
		  }
	}

