import java.awt.Image;

//import Bullet.Directions;

//Osztály ONeil kezelésére
public class ONeil extends Caracter{ 
	 private int weight;
	 
	 //Konstruktor
	public ONeil(Map map,int lives) {
		super(map,lives);
		//System.out.println("ONeil: konstruktor metódus hívás");
		loc = new Coord(2,1); //(oszlop,sor)
	}
	

	
	//Felvesz egy tárgyat
	public void pickUp() {
		//System.out.println("ONeil: pickUp metódus hívás");
		switch (direction) {
			case Up:   //Fel
				object = map.map[loc.getY()-1][loc.getX()].getObj(); //Koordináták beállítása
				//System.out.println(loc.getY()-1+" "+loc.getX());
			break;
			case Down: //le
				object = map.map[loc.getY()+1][loc.getX()].getObj(); //Koordináták beállítása
			break;
			case Left: //Balra
				object = map.map[loc.getY()][loc.getX()-1].getObj(); //Koordináták beállítása
				//System.out.println(loc.getY()+" "+(loc.getX()-1));
			break;
			case Right: //Jobb
				object = map.map[loc.getY()][loc.getX()+1].getObj(); //Koordináták beállítása
			break;		
		}
		if(object!=null){
			//System.out.println("yaay");
		}
	}
	
	//Lövés kezelése
	public void shoot(char c,WormHole w) {
		
		//System.out.println("ONeil: shoot metódus hívás");
		if(c=='b'){
			//System.out.println("Blue bullet");
		BlueBullet b = new BlueBullet(direction, loc , map,w);
		b.move();
		}
		else {
			//System.out.println("yellow bullet");
			YellowBullet y = new YellowBullet(direction, loc , map,w);
			y.move();
		}
	}
	

	
	//Item lerakása
	public void dropDown() {
		//System.out.println("ONeil: dropDown metódus hívás");
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
