import java.awt.Image;

import javax.swing.ImageIcon;

//Osztály: Sárga lövedék
public class YellowBullet extends Bullet {
	private Image image;
	public WormHole wormhole;
	

	public YellowBullet(ONeil.Directions directions, Coord coord, Map m,WormHole w) {

		super(directions,coord,m);
		wormhole=w;
		//System.out.println("BlueBullet: konstruktor hívás");
	
	}
	
	public void open()
	{ImageIcon ic=null;
	if((wormhole.getYellowDir()==Caracter.Directions.Right) ||(wormhole.getYellowDir()==Caracter.Directions.Left))
		 ic = new ImageIcon("specialwall2.jpg");
		else 
			 ic = new ImageIcon("specialwall1.jpg");
	    image = ic.getImage();
	    
			if(wormhole.isOpen()==true){
				map.map[wormhole.getYellow().getY()][wormhole.getYellow().getX()]=new SpecialWall(new Coord(wormhole.getYellow().getY(),wormhole.getYellow().getX()),image);
			}
	//	map.map[loc.getY()][loc.getX()]=new Portal(loc,'y');
		wormhole.setYellow(new Coord( loc.getY(),loc.getX()));
		wormhole.setYellowDir(dir);
	//	map.map[loc.getY()][loc.getX()].setWH(wormhole);
		map.map[loc.getY()][loc.getX()]=new Portal(loc,'y',wormhole);
		System.out.println("YellowBullet: Sárga portál nyílt");
	}
	
}
