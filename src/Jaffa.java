
public class Jaffa extends Caracter {
	private int weight;
	 
	 //Konstruktor
	public Jaffa(Map map,int lives) {
		super(map,lives);
		loc = new Coord(0,0); //(oszlop,sor)
	}
	

	//Felvesz egy tárgyat
	public void pickUp() {
		System.out.println("ONeil: pickUp metódus hívás");
		switch (direction) {
			case Up:   //Fel
				object = map.map[loc.getY()-1][loc.getX()].getObj(); //Koordináták beállítása
			break;
			case Down: //le
				object = map.map[loc.getY()+1][loc.getX()].getObj(); //Koordináták beállítása
			break;
			case Left: //Balra
				object = map.map[loc.getY()][loc.getX()-1].getObj(); //Koordináták beállítása
			break;
			case Right: //Jobb
				object = map.map[loc.getY()][loc.getX()+1].getObj(); //Koordináták beállítása
			break;		
		}
	}
	
	//Lövés kezelése
	public void shoot(char c,WormHole w) {
		System.out.println("ONeil: shoot metódus hívás");
		if(c=='r')
		{
			RedBullet r = new RedBullet(direction, loc , map,w);
			r.move();
		}
		else 
		{
			GreenBullet g = new GreenBullet(direction, loc , map,w);
			g.move();
		}
		
	}
	
	//Item lerakása
	public void dropDown() {
		System.out.println("ONeil: dropDown metódus hívás");
		switch (direction) {
		case Up: //fel
			map.map[loc.getY()-1][loc.getX()].setObj(object); //Koordináták beállítása
			object = null;
		break;
		case Down: //le
			map.map[loc.getY()+1][loc.getX()].setObj(object); //Koordináták beállítása
			object = null;
		break;
		case Left: //balra
			map.map[loc.getY()][loc.getX()-1].setObj(object); //Koordináták beállítása
			object = null;
		break;
		case Right: //jobbra
			map.map[loc.getY()][loc.getX()+1].setObj(object); //Koordináták beállítása
			object = null;
		break;		
	}
}
	
}
