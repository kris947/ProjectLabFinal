
//Abstract oszt�ly: a l�ved�k kezel�s�re
public abstract class Bullet implements Runnable{
	protected Map map;     
	protected Coord loc;  //l�ved�k poz�ci�ja
	protected String type= "Bullet";
	
	//Enum az ir�nyokra
	public enum Directions{
		  Up, 
		  Down, 
		  Left, 
		  Right
	}
	
	protected ONeil.Directions dir; 
	//Konstruktor
	public Bullet(ONeil.Directions directions, Coord coord, Map m) {
		//System.out.println("Bullet: konstruktor h�v�s");
		dir = directions; //
		loc= new Coord(coord.getX(),coord.getY());
		map = m;
		
	}
	
	
	//A l�ved�k mozg�s�t �rja le
	public void run() {		
		boolean flying=true;  //elindul a l�ved�k
		while(flying == true) //am�g nem csap�dik be
		{
			switch(dir)
			{
			case Up:  //ha felfele megy
				loc.setY(loc.getY()-1); 
				flying=map.map[loc.getY()][loc.getX()].fly(this);  //Koordin�ta be�ll�t�sa
				if(loc.equals(map.replicator.loc))
					map.replicator.die();
				break;
			case Down: //ha lefele megy
				loc.setY(loc.getY()+1);
				flying=map.map[loc.getY()][loc.getX()].fly(this);  //Koordin�ta be�ll�t�sa
				if(loc.equals(map.replicator.loc))
					map.replicator.die();
				break;
			case Left: //ha balra megy
				loc.setX(loc.getX()-1);
				flying=map.map[loc.getY()][loc.getX()].fly(this); //Koordin�ta be�ll�t�sa
				if(loc.equals(map.replicator.loc))
					map.replicator.die();
				break;
			case Right: //ha jobbra megy
				loc.setX(loc.getX()+1);
				flying=map.map[loc.getY()][loc.getX()].fly(this); //Koordin�ta be�ll�t�sa
				if(loc.equals(map.replicator.loc))
					map.replicator.die();
				break;
			}
			if (flying == false)
				map.shots.remove(this);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	//Lek�rdez� f�ggv�ny
	public Coord getLoc() {
		return new Coord(loc.getX(),loc.getY());
	}
	
	//Kinyit egy port�lt
	public abstract void open();
}
