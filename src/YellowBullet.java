import java.awt.Image;

import javax.swing.ImageIcon;

//Osztály: Sárga lövedék
public class YellowBullet extends Bullet {
	public WormHole wormhole;
	

	public YellowBullet(ONeil.Directions directions, Coord coord, Map m,WormHole w) {
		super(directions,coord,m);
		wormhole=w;	
		type = "yellow";
	}
	
	public void open()
	{
		if(wormhole.getYellow() != null)
		{
			map.map[wormhole.getYellow().getY()][wormhole.getYellow().getX()]=new SpecialWall(new Coord(wormhole.getYellow().getY(),wormhole.getYellow().getX()));
		}

		wormhole.setYellow(new Coord( loc.getY(),loc.getX()));
		wormhole.setYellowDir(dir);

		map.map[loc.getY()][loc.getX()]=new Portal(loc,'y',wormhole);
	}
	
}
