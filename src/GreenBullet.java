

//A z�ld l�ved�ket reprezent�l� oszt�ly
public class GreenBullet extends Bullet{
	public WormHole wormhole;
	
	//Konstruktor
	public GreenBullet(Jaffa.Directions directions, Coord coord, Map m,WormHole w)
	{
		super(directions,coord,m);
		wormhole=w;
		
	}
	
	
	@Override
	public String Color()
	{
		return "green";
	}
	
	
	//Port�l nyit�s
		public void open() 
		{
			
			if(wormhole.getGreen() != null){
				/* /Abban az esetben ,ha �j helyre l�v�nk ki z�ld port�lt a megel�z� helyen bez�rja az ott l�v�t,
				 * �s hely�re �jra SpecialWall-t helyez
				 */
				map.map[wormhole.getGreen().getY()][wormhole.getGreen().getX()]=new SpecialWall(new Coord(wormhole.getGreen().getY(),wormhole.getGreen().getX()));
			}

			wormhole.setGreen(new Coord(loc.getY(),loc.getX()));	       //Kivalasztjuk a kek portalt
			wormhole.setGreenDir(dir);									  //A f�reglyukba �rkez� l�ved�k ir�ny�nak a be�ll�t�sa
			map.map[loc.getY()][loc.getX()]=new Portal(loc,'g',wormhole); //Portal letrehoza a megfelelo helyen
			
		}
	}