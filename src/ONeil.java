import java.awt.Image;

import javax.swing.ImageIcon;

//Oszt�ly ONeil kezel�s�re
public class ONeil extends Caracter{ 
	 private int weight;
	 
	 //Konstruktor
	public ONeil(Map map,int lives) {
		super(map,lives);
		loc = new Coord(2,1); //(oszlop,sor)
		ImageIcon ic = new ImageIcon("ONeil.png");
        Image image = ic.getImage();
	}	
	//Felvesz egy t�rgyat
	public void pickUp() {
		switch (direction) {
			case Up:   //Fel
				object = map.map[loc.getY()-1][loc.getX()].getObj(); //Koordin�t�k be�ll�t�sa
			break;
			case Down: //le
				object = map.map[loc.getY()+1][loc.getX()].getObj(); //Koordin�t�k be�ll�t�sa
			break;
			case Left: //Balra
				object = map.map[loc.getY()][loc.getX()-1].getObj(); //Koordin�t�k be�ll�t�sa
				
			break;
			case Right: //Jobb
				object = map.map[loc.getY()][loc.getX()+1].getObj(); //Koordin�t�k be�ll�t�sa
			break;		
		}
		if(object!=null){
			
		}
	}
	
	//L�v�s kezel�se
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
