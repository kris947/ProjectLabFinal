import java.awt.Image;

import javax.swing.ImageIcon;




//Oszt�ly ONeil kezel�s�re
public class ONeil extends Caracter{ 
		
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
	//Felvesz egy t�rgyat
	public void pickUp() {
		switch (direction) {
			case Up:   //Fel
				
				object = map.map[loc.getY()-1][loc.getX()].takeObj(); //Koordin�t�k be�ll�t�sa
				map.map[loc.getY()-1][loc.getX()].setObj(null);
			break;
			case Down: //le
				object = map.map[loc.getY()+1][loc.getX()].takeObj(); //Koordin�t�k be�ll�t�sa
				map.map[loc.getY()+1][loc.getX()].setObj(null);
			break;
			case Left: //Balra
				object = map.map[loc.getY()][loc.getX()-1].takeObj(); //Koordin�t�k be�ll�t�sa
				map.map[loc.getY()][loc.getX()-1].setObj(null);
			break;
			case Right: //Jobb
				System.out.println("doboz felv�ve");
				object = map.map[loc.getY()][loc.getX()+1].takeObj(); //Koordin�t�k be�ll�t�sa
				map.map[loc.getY()][loc.getX()+1].setObj(null);
			break;		
		}
		if(object!=null){
			
		}
	}
	
	//L�v�s kezel�se
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
	
	public void dropDown() {
		switch (direction) {
		case Up: //fel
			map.map[loc.getY()-1][loc.getX()].setObj(object); //Koordin�t�k be�ll�t�sa
			object = null;
		break;
		case Down: //le
			map.map[loc.getY()+1][loc.getX()].setObj(object); //Koordin�t�k be�ll�t�sa
			object = null;
		break;
		case Left: //balra
			map.map[loc.getY()][loc.getX()-1].setObj(object); //Koordin�t�k be�ll�t�sa
			object = null;
		break;
		case Right: //jobbra
			map.map[loc.getY()][loc.getX()+1].setObj(object); //Koordin�t�k be�ll�t�sa
			object = null;
		break;		
		}
	}
	


	
}
