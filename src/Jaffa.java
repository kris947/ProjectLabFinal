
public class Jaffa extends Caracter {
	
	int ZPMget=0; //begy�jt�tt ZMP sz�m
	 
	 //Konstruktor
	public Jaffa(Map map,int lives) 
	{
		super(map,lives);
		loc = new Coord(10,11); //(oszlop,sor)
        weight=100;
	}
	
	public int getzpmw()	//ZPM sz�m lek�rdez�s�hez
	{
		return ZPMget;
	}

	//Felvesz egy t�rgyat
	public void pickUp() {
		
		if(!paused){
		
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
				object = map.map[loc.getY()][loc.getX()+1].takeObj(); //Koordin�t�k be�ll�t�sa
				map.map[loc.getY()][loc.getX()+1].setObj(null);
			break;		
	
		}
		}
	}
	
	//L�v�s kezel�se - lsd ONeill
	public void shoot(char c,WormHole w) 
	{
		
		if(c=='r' && !paused)
		{
			if (map.shots.size() != 10)	//a megjelen�t�shez haszn�lt shots list�ba is beleker�l(max 10 sz�lat enged�nk)
			{
		        RedBullet red = new RedBullet(direction, loc , map,w);
				Thread rb = new Thread(red);
		        rb.start();
		        map.shots.add(red);
			}
		}
		else if(!paused)
		{
			if (map.shots.size() != 10)	//a megjelen�t�shez haszn�lt shots list�ba is beleker�l(max 10 sz�lat enged�nk)
			{
		        GreenBullet green = new GreenBullet(direction, loc , map,w);
				Thread gb = new Thread(green);
		        gb.start();
		        map.shots.add(green);
			}
		}
		
	}
	
	///boolean - sikeres volt-e a lerak�s - lsd. ONeill
	public boolean dropDown() {
		switch (direction) {
		case Up: //fel
			if (map.map[loc.getY()-1][loc.getX()].setObj(object) == true)	//Koordin�t�k be�ll�t�sa
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
