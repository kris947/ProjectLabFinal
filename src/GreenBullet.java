

//A zöld lövedéket reprezentáló osztály
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
	
	
	//Portál nyitás
		public void open() 
		{
			
			if(wormhole.getGreen() != null){
				/* /Abban az esetben ,ha új helyre lövünk ki zöld portált a megelõzõ helyen bezárja az ott lévõt,
				 * és helyére újra SpecialWall-t helyez
				 */
				map.map[wormhole.getGreen().getY()][wormhole.getGreen().getX()]=new SpecialWall(new Coord(wormhole.getGreen().getY(),wormhole.getGreen().getX()));
			}

			wormhole.setGreen(new Coord(loc.getY(),loc.getX()));	       //Kivalasztjuk a kek portalt
			wormhole.setGreenDir(dir);									  //A féreglyukba érkezõ lövedék irányának a beállítása
			map.map[loc.getY()][loc.getX()]=new Portal(loc,'g',wormhole); //Portal letrehoza a megfelelo helyen
			
		}
	}