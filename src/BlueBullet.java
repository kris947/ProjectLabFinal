import java.awt.Image;

import javax.swing.ImageIcon;

//Osztály a kék lövedék kezelésére
public class BlueBullet extends Bullet {
	public WormHole wormhole;
	
	//Konstruktor
	public BlueBullet(ONeil.Directions directions, Coord coord, Map m,WormHole w)
	{
		super(directions,coord,m); //Ososztály konstruktoranak hivasa
		wormhole=w;
		type = "blue";
	}
	
	//Portál nyitás
	public void open() 
	{	
		if(wormhole.getBlue() != null)
		{
			map.map[wormhole.getBlue().getY()][wormhole.getBlue().getX()]=new SpecialWall(new Coord(wormhole.getBlue().getY(),wormhole.getBlue().getX()));
		}

		wormhole.setBlue(new Coord(loc.getY(),loc.getX()));	//Kivalasztjuk a kek portalt
		wormhole.setBlueDir(dir);

		map.map[loc.getY()][loc.getX()]=new Portal(loc,'b',wormhole); //Portal letrehoza a megfelelo helyen
		
	}
	
}
