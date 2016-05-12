//Ez szar így ...
public class ReplicatorThread extends Thread 
{
		private Replicator replicator=null;
		public ReplicatorThread(Replicator r)
		{
			replicator = r;
		}

		public void run()
		{
			try 
			{
				while(replicator.lives > 0)
				{
					int step;
					Caracter.Directions tempDir = replicator.direction;
					replicator.direction = replicator.RandDirection();
					if(tempDir==replicator.direction)
						step=1;
					else 
						step=2;
					for(int i=0;i<2;i++)
					{
						replicator.move(replicator.direction);
						Thread.sleep(500);
					}
					
				}
		    } catch(InterruptedException e) {}
		}
}


