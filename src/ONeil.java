
//Osztály ONeil kezelésére
public class ONeil extends Caracter{ 
		
	 int ZPMget = 0; //eddig begyüjtött ZPM szám
	 
	 //Konstruktor
	public ONeil(Map map,int lives) 
	{
		super(map,lives);
		loc = new Coord(8,11); //(oszlop,sor)
        weight=100;
       
	}	
	
	//vissza adja az eddig begyûjtött ZPM számot
	public int getzpmw()
	{
		return ZPMget;
	}
	
	//Felvesz egy tárgyat
	public void pickUp() 
	{
		switch (direction) 
		{
			case Up:   //Fel				
				object = map.map[loc.getY()-1][loc.getX()].takeObj(); //Koordináták beállítása
				map.map[loc.getY()-1][loc.getX()].setObj(null);		//a felvett tárgy helyére null-r rak
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
	public void shoot(char c,WormHole w) 
	{
		if(c=='b')
		{			
			if (map.shots.size() != 10)	//a megjelenítéshez használt shots listába is belekerül(max 10 szálat engedünk)
			{
				BlueBullet blue = new BlueBullet(direction, loc , map,w);	//létre hozza a lövedéket
				map.shots.add(blue);
				Thread bb = new Thread(blue);	//külön szálon fut a lövedék mozgása
		        bb.start();
			}
		}
		else 
		{
			if (map.shots.size() != 10)	//a megjelenítéshez használt shots listába is belekerül(max 10 szálat engedünk)
			{
				YellowBullet yellow = new YellowBullet(direction, loc , map,w);
				Thread yb = new Thread(yellow);
		        yb.start();
		        map.shots.add(yellow);
			}
		}
	}
	
	//boolean - sikeres volt-e a lerakás
	public boolean dropDown() {
		switch (direction) {
		case Up: //fel
			if (map.map[loc.getY()-1][loc.getX()].setObj(object) == true)	//ha lerakható
			{ 
				if (object.redeem() == true && object.redeemed == true)	//ha beváltható és a spaceship elis fogadta
					ZPMget++;
				object = null;		//ONeillnál lévõ object ezután null
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
		return false;	//ha nem lehetett lerakni akkor false-al tér vissza
	}
	
	@Override
	public void die()	//ha elfogy az élete akkor az Oneil trölõdik a map-bõl
	{
		map.game.o = null;
	}
	
}
