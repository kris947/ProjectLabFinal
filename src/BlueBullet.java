import java.awt.Image;

//Oszt�ly a k�k l�ved�k kezel�s�re
public class BlueBullet extends Bullet {
	private Image image;
	public WormHole wormhole;
	
	//Konstruktor
	public BlueBullet(ONeil.Directions directions, Coord coord, Map m,WormHole w)
	{
		super(directions,coord,m); //Ososzt�ly konstruktoranak hivasa
		wormhole=w;
		//System.out.println("BlueBullet: konstruktor h�v�s");
	}
	
	//Port�l nyit�s
	public void open() 
	{
		System.out.println("BlueBullet: open met�dus h�v�s");
		map.map[loc.getY()][loc.getX()]=new Portal(loc); //Portal letrehoza a megfelelo helyen
		wormhole.setBlue(new Coord(loc.getY(),loc.getX()));	//Kivalasztjuk a kek portalt
		wormhole.setBlueDir(dir);
		map.map[loc.getY()][loc.getX()].setWH(wormhole);
		//System.out.println("BlueBullet: K�k port�l ny�lt");
	}
	
}
