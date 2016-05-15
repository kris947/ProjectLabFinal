


public class RedBullet extends Bullet{

	public WormHole wormhole;
	
	//Konstruktor
	public RedBullet(Jaffa.Directions directions, Coord coord, Map m,WormHole w)
	{
		super(directions,coord,m);
		wormhole=w;
		type = "red";		
	}
	
	//Port�l nyit�s
		public void open() 
		{
			if(wormhole.getRed() != null){
				/* /Abban az esetben ,ha �j helyre l�v�nk ki piros port�lt a megel�z� helyen bez�rja az ott l�v�t,
				 * �s hely�re �jra SpecialWall-t helyez
				 */
			map.map[wormhole.getRed().getY()][wormhole.getRed().getX()]=new SpecialWall(new Coord(wormhole.getRed().getY(),wormhole.getRed().getX()));
			}

			wormhole.setRed(new Coord(loc.getY(),loc.getX()));				 //Kivalasztjuk a kek portalt
			wormhole.setRedDir(dir); 										//A f�reglyukba �rkez� l�ved�k ir�ny�nak a be�ll�t�sa
			map.map[loc.getY()][loc.getX()]=new Portal(loc,'r',wormhole); //Portal letrehoza a megfelelo helyen
			
			
		}
		
	}



