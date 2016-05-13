import java.awt.Image;
import javax.swing.ImageIcon;



public class Jaffa extends Caracter {
	/*public enum Directions{
		  Up, 
		  Down, 
		  Left, 
		  Right  
		}
	static Directions direction = Directions.Right;*/
	 
	 //Konstruktor
	public Jaffa(Map map,int lives) {
		super(map,lives);
		loc = new Coord(9,12); //(oszlop,sor)
        weight=100;
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
			System.out.println("Jaffa: shoot metódus hívás");
			if(c=='r')
			{
				
		        RedBullet red = new RedBullet(direction, loc , map,w);
				Thread rb = new Thread(red);
		        rb.start();
		        map.shots.add(red);
			}
			else 
			{
				GreenBullet green = new GreenBullet(direction, loc , map,w);
				Thread gb = new Thread(green);
		        gb.start();
		        map.shots.add(green);
				
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
