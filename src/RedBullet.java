import java.awt.Image;


public class RedBullet extends Bullet{
	private Image image;
	public WormHole wormhole;
	
	//Konstruktor
	public RedBullet(Jaffa.Directions directions, Coord coord, Map m,WormHole w)
	{
		super(directions,coord,m);
		wormhole=w;
		//System.out.println("RedBullet: konstruktor h�v�s");
			
	}
	
	//Port�l nyit�s
	public void open() 
	{
		//System.out.println("RedBullett: open met�dus h�v�s");
		map.map[loc.getY()][loc.getX()]=new Portal(loc,'r');
		wormhole.setRed(new Coord( loc.getY(),loc.getX()));	
		wormhole.setRedDir(dir);
		map.map[loc.getY()][loc.getX()].setWH(wormhole);
		//System.out.println("RedBullet: piros port�l ny�lt");
	}
	
}

