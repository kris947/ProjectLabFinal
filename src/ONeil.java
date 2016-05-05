import java.awt.Image;

//import Bullet.Directions;

//Oszt�ly ONeil kezel�s�re
public class ONeil extends Caracter{ 
	 private int weight;
	 
	 //Konstruktor
	public ONeil(Map map,int lives) {
		super(map,lives);
		//System.out.println("ONeil: konstruktor met�dus h�v�s");
		loc = new Coord(2,1); //(oszlop,sor)
	}
	

	
	//Felvesz egy t�rgyat
	public void pickUp() {
		//System.out.println("ONeil: pickUp met�dus h�v�s");
		switch (direction) {
			case Up:   //Fel
				object = map.map[loc.getY()-1][loc.getX()].getObj(); //Koordin�t�k be�ll�t�sa
				//System.out.println(loc.getY()-1+" "+loc.getX());
			break;
			case Down: //le
				object = map.map[loc.getY()+1][loc.getX()].getObj(); //Koordin�t�k be�ll�t�sa
			break;
			case Left: //Balra
				object = map.map[loc.getY()][loc.getX()-1].getObj(); //Koordin�t�k be�ll�t�sa
				//System.out.println(loc.getY()+" "+(loc.getX()-1));
			break;
			case Right: //Jobb
				object = map.map[loc.getY()][loc.getX()+1].getObj(); //Koordin�t�k be�ll�t�sa
			break;		
		}
		if(object!=null){
			//System.out.println("yaay");
		}
	}
	
	//L�v�s kezel�se
	public void shoot(char c,WormHole w) {
		
		//System.out.println("ONeil: shoot met�dus h�v�s");
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
	

	
	//Item lerak�sa
	public void dropDown() {
		//System.out.println("ONeil: dropDown met�dus h�v�s");
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
