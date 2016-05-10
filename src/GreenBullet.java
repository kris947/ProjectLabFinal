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
		//System.out.println("GreenBullett: open metódus hívás");
		map.map[loc.getY()][loc.getX()]=new Portal(loc,'g');
		wormhole.setGreen(new Coord( loc.getY(),loc.getX()));
		wormhole.setGreenDir(dir);
		map.map[loc.getY()][loc.getX()].setWH(wormhole);
		//System.out.println("GreenBullet: Zöld portál nyílt");
	}
}
