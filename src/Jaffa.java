
public class Jaffa extends Caracter {
	
	int ZPMget=0; //begyüjtött ZMP szám
	 
	 //Konstruktor
	public Jaffa(Map map,int lives) 
	{
		super(map,lives);
		loc = new Coord(10,11); //(oszlop,sor)
        weight=100;
	}
	
	public int getzpmw()	//ZPM szám lekérdezéséhez
	{
		return ZPMget;
	}

	//Felvesz egy tárgyat
	public void pickUp() {
		
		if(!paused){
		
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
	}
	
	//Lövés kezelése - lsd ONeill
	public void shoot(char c,WormHole w) 
	{
		
		if(c=='r' && !paused)
		{
			if (map.shots.size() != 10)	//a megjelenítéshez használt shots listába is belekerül(max 10 szálat engedünk)
			{
		        RedBullet red = new RedBullet(direction, loc , map,w);
				Thread rb = new Thread(red);
		        rb.start();
		        map.shots.add(red);
			}
		}
		else if(!paused)
		{
			if (map.shots.size() != 10)	//a megjelenítéshez használt shots listába is belekerül(max 10 szálat engedünk)
			{
		        GreenBullet green = new GreenBullet(direction, loc , map,w);
				Thread gb = new Thread(green);
		        gb.start();
		        map.shots.add(green);
			}
		}
		
	}
	
	///boolean - sikeres volt-e a lerakás - lsd. ONeill
	public boolean dropDown() {
		switch (direction) {
		case Up: //fel
			if (map.map[loc.getY()-1][loc.getX()].setObj(object) == true)	//Koordináták beállítása
			{ 
				if (object.redeem() == true && object.redeemed == true)
					ZPMget++;
				object = null;
				return true;
			}
		break;
		case Down: //le
			if (map.map[loc.getY()+1][loc.getX()].setObj(object) == true)
			{ 
				if (object.redeem() == true && object.redeemed == true)
					ZPMget++;
				object = null;
				return true;
			}
		break;
		case Left: //balra
			if (map.map[loc.getY()][loc.getX()-1].setObj(object) == true)
			{
				if (object.redeem() == true && object.redeemed == true)
					ZPMget++;
				object = null;
				return true;
			}
		break;
		case Right: //jobbra
			if (map.map[loc.getY()][loc.getX()+1].setObj(object) == true)
			{
				if (object.redeem() == true && object.redeemed == true)
					ZPMget++;
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
