


public class RedBullet extends Bullet{

	public WormHole wormhole;
	
	//Konstruktor
	public RedBullet(Jaffa.Directions directions, Coord coord, Map m,WormHole w)
	{
		super(directions,coord,m);
		wormhole=w;
		type = "red";		
	}
	
	//Portál nyitás
		public void open() 
		{
			if(wormhole.getRed() != null){
				/* /Abban az esetben ,ha új helyre lövünk ki piros portált a megelõzõ helyen bezárja az ott lévõt,
				 * és helyére újra SpecialWall-t helyez
				 */
			map.map[wormhole.getRed().getY()][wormhole.getRed().getX()]=new SpecialWall(new Coord(wormhole.getRed().getY(),wormhole.getRed().getX()));
			}

			wormhole.setRed(new Coord(loc.getY(),loc.getX()));				 //Kivalasztjuk a kek portalt
			wormhole.setRedDir(dir); 										//A féreglyukba érkezõ lövedék irányának a beállítása
			map.map[loc.getY()][loc.getX()]=new Portal(loc,'r',wormhole); //Portal letrehoza a megfelelo helyen
			
			
		}
		
	}



