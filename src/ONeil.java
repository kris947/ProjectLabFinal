import java.awt.Image;

import javax.swing.ImageIcon;




//Osztály ONeil kezelésére
public class ONeil extends Caracter{ 
		
	 int ZPMget = 0;
	
	/*public enum Directions{
		  Up, 
		  Down, 
		  Left, 
		  Right  
		}*/
	//static Directions dir = Directions.Right;
	 
	 //Konstruktor
	public ONeil(Map map,int lives) {
		super(map,lives);
		loc = new Coord(2,1); //(oszlop,sor)
        weight=100;
       
	}	
	public int getzpmw(){return ZPMget;}
	
	//Felvesz egy tárgyat
	public void pickUp() {
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
				System.out.println("doboz felvéve");
				object = map.map[loc.getY()][loc.getX()+1].takeObj(); //Koordináták beállítása
				map.map[loc.getY()][loc.getX()+1].setObj(null);
			break;		
		}
	}
	
	//Lövés kezelése
	public void shoot(char c,WormHole w) {
		if(c=='b'){
			BlueBullet blue = new BlueBullet(direction, loc , map,w);
			Thread bb = new Thread(blue);
	        bb.start();
	        map.shots.add(blue);
			}
		else {
			//YellowBullet y = new YellowBullet(direction, loc , map,w);
			YellowBullet yellow = new YellowBullet(direction, loc , map,w);
			Thread yb = new Thread(yellow);
	        yb.start();
	        map.shots.add(yellow);
		}
	}
	
	//boolean - sikeres volt-e a lerakás
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
		map.game.o = null;
	}
	


	
}
