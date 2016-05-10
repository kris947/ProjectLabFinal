import java.awt.Image;

//A z�ld l�ved�ket reprezent�l� oszt�ly
public class GreenBullet extends Bullet{
	private Image image;
	public WormHole wormhole;
	
	//Konstruktor
	public GreenBullet(Jaffa.Directions directions, Coord coord, Map m,WormHole w)
	{
		super(directions,coord,m);
		wormhole=w;
		//System.out.println("GreenBullet: konstruktor h�v�s");
			
	}
	
	//Port�l nyit�s
	public void open() 
	{
		//System.out.println("GreenBullett: open met�dus h�v�s");
		map.map[loc.getY()][loc.getX()]=new Portal(loc,'g');
		wormhole.setGreen(new Coord( loc.getY(),loc.getX()));
		wormhole.setGreenDir(dir);
		map.map[loc.getY()][loc.getX()].setWH(wormhole);
		//System.out.println("GreenBullet: Z�ld port�l ny�lt");
	}
}
