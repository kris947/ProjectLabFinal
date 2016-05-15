import java.awt.Image;
import javax.swing.ImageIcon;



public class Jaffa extends Caracter {
	
	int ZPMget=0;
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
	
	public int getzpmw(){return ZPMget;}

	//Felvesz egy tárgyat
	public void pickUp() {
		System.out.println("ONeil: pickUp metódus hívás");
		switch (direction) {
			case Up:   //Fel
				object = map.map[loc.getY()-1][loc.getX()].takeObj(); //Koordináták beállítása
				map.map[loc.getY()-1][loc.getX()].setObj(null);
			break;
			case Down: //le
				object = map.map[loc.getY()+1][loc.getX()].takeObj(); //Koordináták beállítása
				map.map[loc.getY()+1][loc.getX()].setObj(null);
			break;
			case Left: //Balra
				object = map.map[loc.getY()][loc.getX()-1].takeObj(); //Koordináták beállítása
				map.map[loc.getY()][loc.getX()-1].setObj(null);
			break;
			case Right: //Jobb
				object = map.map[loc.getY()][loc.getX()+1].takeObj(); //Koordináták beállítása
				map.map[loc.getY()][loc.getX()+1].setObj(null);
			break;		
		}
	}
	
	//Lövés kezelése
	public void shoot(char c,WormHole w) {
		System.out.println("ONeil: shoot metódus hívás");
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
	
	///boolean - sikeres volt-e a lerakás
	public boolean dropDown() {
		switch (direction) {
		case Up: //fel
			if (map.map[loc.getY()-1][loc.getX()].setObj(object) == true)	//Koordináták beállítása
			{ 
				object = null;
				return true;
			}
		break;
		case Down: //le
			if (map.map[loc.getY()+1][loc.getX()].setObj(object) == true)
			{ 
				object = null;
				return true;
			}
		break;
		case Left: //balra
			if (map.map[loc.getY()][loc.getX()-1].setObj(object) == true)
			{
				object = null;
				return true;
			}
		break;
		case Right: //jobbra
			if (map.map[loc.getY()][loc.getX()+1].setObj(object) == true)
			{
				object = null;
				return true;
			}
		break;		
		}
		return false;
	}
	
	@Override
	public void die()
	{
		map.game.j = null;
	}
}
