import java.awt.Image;


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
		//System.out.println("GreenBullett: open metódus hívás");
		map.map[loc.getY()][loc.getX()]=new Portal(loc);
		wormhole.setGreen(new Coord( loc.getY(),loc.getX()));
		//System.out.println("GreenBullet: Zöld portál nyílt");
	}
}
