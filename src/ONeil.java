import java.awt.Image;

import javax.swing.ImageIcon;

//Osztály ONeil kezelésére
public class ONeil extends Caracter{ 
	 private int weight;
	 
	 //Konstruktor
	public ONeil(Map map,int lives) {
		super(map,lives);
		loc = new Coord(2,1); //(oszlop,sor)
		ImageIcon ic = new ImageIcon("ONeil.png");
        Image image = ic.getImage();
	}	
	//Felvesz egy tárgyat
	public void pickUp() {
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
		if(object!=null){
			
		}
	}
	
	//Lövés kezelése
	public void shoot(char c,WormHole w) {
		if(c=='b'){
			BlueBullet b = new BlueBullet(direction, loc , map,w);
			b.move();
			}
		else {
			YellowBullet y = new YellowBullet(direction, loc , map,w);
			y.move();
		}
	}
	
	public void dropDown() {
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
