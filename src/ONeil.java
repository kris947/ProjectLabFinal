
//Oszt�ly ONeil kezel�s�re
public class ONeil extends Caracter{ 
		
	 int ZPMget = 0; //eddig begy�jt�tt ZPM sz�m
	 
	 //Konstruktor
	public ONeil(Map map,int lives) 
	{
		super(map,lives);
		loc = new Coord(8,11); //(oszlop,sor)
        weight=100;
       
	}	
	
	//vissza adja az eddig begy�jt�tt ZPM sz�mot
	public int getzpmw()
	{
		return ZPMget;
	}
	
	//Felvesz egy t�rgyat
	public void pickUp() 
	{
		switch (direction) 
		{
			case Up:   //Fel				
				object = map.map[loc.getY()-1][loc.getX()].takeObj(); //Koordin�t�k be�ll�t�sa
				map.map[loc.getY()-1][loc.getX()].setObj(null);		//a felvett t�rgy hely�re null-r rak
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
				object = map.map[loc.getY()][loc.getX()+1].takeObj(); //Koordin�t�k be�ll�t�sa
				map.map[loc.getY()][loc.getX()+1].setObj(null);
			break;		
		}
	}
	
	//L�v�s kezel�se
	public void shoot(char c,WormHole w) 
	{
		if(c=='b')
		{			
			if (map.shots.size() != 10)	//a megjelen�t�shez haszn�lt shots list�ba is beleker�l(max 10 sz�lat enged�nk)
			{
				BlueBullet blue = new BlueBullet(direction, loc , map,w);	//l�tre hozza a l�ved�ket
				map.shots.add(blue);
				Thread bb = new Thread(blue);	//k�l�n sz�lon fut a l�ved�k mozg�sa
		        bb.start();
			}
		}
		else 
		{
			if (map.shots.size() != 10)	//a megjelen�t�shez haszn�lt shots list�ba is beleker�l(max 10 sz�lat enged�nk)
			{
				YellowBullet yellow = new YellowBullet(direction, loc , map,w);
				Thread yb = new Thread(yellow);
		        yb.start();
		        map.shots.add(yellow);
			}
		}
	}
	
	//boolean - sikeres volt-e a lerak�s
	public boolean dropDown() {
		switch (direction) {
		case Up: //fel
			if (map.map[loc.getY()-1][loc.getX()].setObj(object) == true)	//ha lerakhat�
			{ 
				if (object.redeem() == true && object.redeemed == true)	//ha bev�lthat� �s a spaceship elis fogadta
					ZPMget++;
				object = null;		//ONeilln�l l�v� object ezut�n null
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
		return false;	//ha nem lehetett lerakni akkor false-al t�r vissza
	}
	
	@Override
	public void die()	//ha elfogy az �lete akkor az Oneil tr�l�dik a map-b�l
	{
		map.game.o = null;
	}
	
}
