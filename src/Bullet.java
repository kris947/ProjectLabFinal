
//Abstract osztály: a lövedék kezelésére
public abstract class Bullet implements Runnable{
	protected Map map;     
	protected Coord loc;  //lövedék pozíciója

	
	//Enum az irányokra
	public enum Directions{
		  Up, 
		  Down, 
		  Left, 
		  Right
	}
	
	protected ONeil.Directions dir;			//Hivatkozás ONeil irányára
	//Konstruktor
	public Bullet(ONeil.Directions directions, Coord coord, Map m) {
		//System.out.println("Bullet: konstruktor hívás");
		dir = directions; 								//Irány átadása
		loc= new Coord(coord.getX(),coord.getY());		//Koordináta beállítása
		map = m;
		
	}
	
	public String Color(){return "bullet";}
	
	
	//A lövedék mozgását írja le
	public void run() {		
		boolean flying=true;  //elindul a lövedék
		while(flying == true) //amíg nem csapódik be
		{
			switch(dir)
			{
			case Up:  //ha felfele megy
				loc.setY(loc.getY()-1); 
				flying=map.map[loc.getY()][loc.getX()].fly(this);  //Koordináta beállítása
				if(loc.equals(map.replicator.loc))
					map.replicator.die();
				break;
			case Down: //ha lefele megy
				loc.setY(loc.getY()+1);
				flying=map.map[loc.getY()][loc.getX()].fly(this);  //Koordináta beállítása
				if(loc.equals(map.replicator.loc))
					map.replicator.die();
				break;
			case Left: //ha balra megy
				loc.setX(loc.getX()-1);
				flying=map.map[loc.getY()][loc.getX()].fly(this); //Koordináta beállítása
				if(loc.equals(map.replicator.loc))
					map.replicator.die();
				break;
			case Right: //ha jobbra megy
				loc.setX(loc.getX()+1);
				flying=map.map[loc.getY()][loc.getX()].fly(this); //Koordináta beállítása
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
	
	
	//Lekérdezõ függvény
	public Coord getLoc() {
		return new Coord(loc.getX(),loc.getY());
	}
	
	//Kinyit egy portált
	public abstract void open();
}
