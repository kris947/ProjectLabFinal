
//Abstract osztály: a lövedék kezelésére
public abstract class Bullet {
	protected Map map;     
	protected Coord loc;  //lövedék pozíciója
	
	//enum az irányokra
	public enum Directions{
		  Up, 
		  Down, 
		  Left, 
		  Right
	}
	
	protected ONeil.Directions dir;
	//Ez itt nem fix h jó 
	//Konstruktor
	public Bullet(ONeil.Directions directions, Coord coord, Map m) {
		//System.out.println("Bullet: konstruktor hívás");
		dir = directions; //
		loc= new Coord(coord.getX(),coord.getY());
		map = m;
		
	}
	
	
	//a lövedék mozgását írja le
	public void move() {
		//System.out.println("Bullet: move metódus hívás");
		//System.out.println(loc.getY()+" "+loc.getX());
		
		boolean flying=true;  //elindul a lövedék
		while(flying == true) //amíg nem csapódik be
		{
			switch(dir)
			{
			case Up:  //ha felfele megy
				loc.setY(loc.getY()-1); 
				flying=map.map[loc.getY()][loc.getX()].fly(this);  //Koordináta beállítása
				
				//System.out.println("Bullet: Lövedék fel pew-pew");
				break;
			case Down: //ha lefele megy
				loc.setY(loc.getY()+1);
				flying=map.map[loc.getY()][loc.getX()].fly(this);  //Koordináta beállítása
								//System.out.println("Lövedék lel pew-pew");
				break;
			case Left: //ha balra megy
				loc.setX(loc.getX()-1);
				flying=map.map[loc.getY()][loc.getX()].fly(this); //Koordináta beállítása
				
				//System.out.println("Lövedék balra pew-pew");
				break;
			case Right: //ha jobbra megy
				loc.setX(loc.getX()+1);
				flying=map.map[loc.getY()][loc.getX()].fly(this); //Koordináta beállítása
				
				//System.out.println("Bullet: Lövedék jobbra pew-pew");
				break;
			}
		}
	}
	
	
	//Lekérdezõ függvény
	public Coord getLoc() {
		//System.out.println("Bullet: getloc metódus hívása");
		return new Coord(loc.getX(),loc.getY());
	}
	
	//Kinyit egy portált
	public abstract void open();
}
