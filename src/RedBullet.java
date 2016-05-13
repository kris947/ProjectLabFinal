import java.awt.Image;


public class RedBullet extends Bullet{
	private Image image;
	public WormHole wormhole;
	
	//Konstruktor
	public RedBullet(Jaffa.Directions directions, Coord coord, Map m,WormHole w)
	{
		super(directions,coord,m);
		wormhole=w;
		//System.out.println("RedBullet: konstruktor hívás");
		type = "red";
			
	}
	
	//Portál nyitás
		public void open() 
		{
			if(wormhole.getRed() != null){
				map.map[wormhole.getRed().getY()][wormhole.getRed().getX()]=new SpecialWall(new Coord(wormhole.getRed().getY(),wormhole.getRed().getX()));
			}

			wormhole.setRed(new Coord(loc.getY(),loc.getX()));	//Kivalasztjuk a kek portalt
			wormhole.setRedDir(dir);

			map.map[loc.getY()][loc.getX()]=new Portal(loc,'r',wormhole); //Portal letrehoza a megfelelo helyen
			
			
		}
		
	}



