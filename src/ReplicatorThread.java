//Ez szar így ...
public class ReplicatorThread extends Thread {
		private Replicator replicator=null;
		public ReplicatorThread(Map map){
		    replicator=new Replicator(map,1);
		}

		public void run(){
			try 
			{
				while(replicator.lives > 0)
				{
					replicator.RandDirection();
					for(int i=0;i<replicator.RandValue();i++){
						replicator.move(replicator.direction);
					
		        Thread.sleep(1000);
					}
		      }
		    } catch(InterruptedException e) {}
		}
	}

