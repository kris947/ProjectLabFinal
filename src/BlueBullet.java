

//Oszt�ly a k�k l�ved�k kezel�s�re
public class BlueBullet extends Bullet {
	public WormHole wormhole;
	
	//Konstruktor
	public BlueBullet(ONeil.Directions directions, Coord coord, Map m,WormHole w)
	{
		super(directions,coord,m); //Ososzt�ly konstruktoranak hivasa
		wormhole=w;
		type = "blue";
	}
	
	//Port�l nyit�s
	public void open() 
	{	
		if(wormhole.getBlue() != null){
			
			/* /Abban az esetben ,ha �j helyre l�v�nk ki k�k port�lt a megel�z� helyen bez�rja az ott l�v�t,
			 * �s hely�re �jra SpecialWall-t helyez
			 */
			map.map[wormhole.getBlue().getY()][wormhole.getBlue().getX()]=new SpecialWall(new Coord(wormhole.getBlue().getY(),wormhole.getBlue().getX()));  
		}
		wormhole.setBlue(new Coord(loc.getY(),loc.getX()));         	//Kivalasztjuk a kek portalt
		wormhole.setBlueDir(dir);                                      //A f�reglyukba �rkez� l�ved�k ir�ny�nak a be�ll�t�sa
		map.map[loc.getY()][loc.getX()]=new Portal(loc,'b',wormhole); //Portal letrehoza a megfelelo helyen
		
	}
	
}
