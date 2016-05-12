import java.awt.Image;

import javax.swing.ImageIcon;

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
		ImageIcon ic=null;
		if((wormhole.getBlueDir()==Caracter.Directions.Right) ||(wormhole.getBlueDir()==Caracter.Directions.Left))
		 ic = new ImageIcon("specialwall2.jpg");
		else 
			 ic = new ImageIcon("specialwall1.jpg");
	    image = ic.getImage();
			if(wormhole.isOpen()==true){
				map.map[wormhole.getBlue().getY()][wormhole.getBlue().getX()]=new SpecialWall(new Coord(wormhole.getBlue().getY(),wormhole.getBlue().getX()),image);
			}
		//System.out.println("BlueBullet: open met�dus h�v�s");
		wormhole.setBlue(new Coord(loc.getY(),loc.getX()));	//Kivalasztjuk a kek portalt
		wormhole.setBlueDir(dir);
	//	map.map[loc.getY()][loc.getX()].setWH(wormhole);
		map.map[loc.getY()][loc.getX()]=new Portal(loc,'b',wormhole); //Portal letrehoza a megfelelo helyen
		//System.out.println("BlueBullet: K�k port�l ny�lt");
	}
	
}
