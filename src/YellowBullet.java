import java.awt.Image;

//Oszt�ly: S�rga l�ved�k
public class YellowBullet extends Bullet {
	private Image image;
	public WormHole wormhole;
	

	public YellowBullet(ONeil.Directions directions, Coord coord, Map m,WormHole w) {

		super(directions,coord,m);
		wormhole=w;
		//System.out.println("BlueBullet: konstruktor h�v�s");
	
	}
	
	public void open()
	{
		map.map[loc.getY()][loc.getX()]=new Portal(loc);
		wormhole.setYellow(new Coord( loc.getY(),loc.getX()));
		map.map[loc.getY()][loc.getX()].setWH(wormhole);
		//System.out.println("BlueBullet: S�rga port�l ny�lt");
	}
	
}
