
//Oszt�ly: S�rga l�ved�k
public class YellowBullet extends Bullet {
	public WormHole wormhole;
	

	public YellowBullet(ONeil.Directions directions, Coord coord, Map m,WormHole w) {
		super(directions,coord,m); //Ososzt�ly konstruktoranak hivasa
		wormhole=w;	
		
	}
	
	@Override
	public String Color()
	{
		return "yellow";
	}
	
	public void open()
	{
		if(wormhole.getYellow() != null)
		{
			/* /Abban az esetben ,ha �j helyre l�v�nk ki k�k port�lt a megel�z� helyen bez�rja az ott l�v�t,
			 * �s hely�re �jra SpecialWall-t helyez
			 */
			map.map[wormhole.getYellow().getY()][wormhole.getYellow().getX()]=new SpecialWall(new Coord(wormhole.getYellow().getY(),wormhole.getYellow().getX()));
		}

		wormhole.setYellow(new Coord( loc.getY(),loc.getX()));      //Kivalasztjuk a sarga portalt
		wormhole.setYellowDir(dir);                                 //A f�reglyukba �rkez� l�ved�k ir�ny�nak a be�ll�t�sa
		map.map[loc.getY()][loc.getX()]=new Portal(loc,'y',wormhole);//Portal letrehoza a megfelelo helyen
	}
	
}
