import java.awt.Image;

//A zöld lövedéket reprezentáló osztály
public class GreenBullet extends Bullet{
	private Image image;
	public WormHole wormhole;
	
	//Konstruktor
	public GreenBullet(Jaffa.Directions directions, Coord coord, Map m,WormHole w)
	{
		super(directions,coord,m);
		wormhole=w;
		//System.out.println("GreenBullet: konstruktor hívás");
			
	}
	
	//Portál nyitás
		public void open() 
		{
			System.out.println("GreenBullett: open metódus hívás");
			if(wormhole.getGreen() != null){
			
				map.map[wormhole.getGreen().getY()][wormhole.getGreen().getX()]=new SpecialWall(new Coord(wormhole.getGreen().getY(),wormhole.getGreen().getX()));
			}

			wormhole.setGreen(new Coord(loc.getY(),loc.getX()));	//Kivalasztjuk a kek portalt
			wormhole.setGreenDir(dir);
			map.map[loc.getY()][loc.getX()]=new Portal(loc,'g',wormhole); //Portal letrehoza a megfelelo helyen
			//System.out.println("GreenBullet: Zöld portál nyílt");*/
		}
	}