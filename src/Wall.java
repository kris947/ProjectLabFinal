import java.awt.Image;

import javax.swing.ImageIcon;

//Osztály a fal típusú mezõ kezelésére
public class Wall extends Tile {
	
	//Megmondja, hogy ONeil mit csináljon, ha falra akar lépni
	public Wall (Coord c) {
		
		super(c);
	}
	
	@Override
	public String getType(){ return "wall";}
	
	//A lövedék megáll, ha falba csapódik
	@Override
	 public boolean fly(Bullet b)
	 {
		
		 return false;
		 
	 }
	
	//ONeill nem tud a falra lépni, ezért marad az eredeti helyén
	@Override
	public Coord stepOn(Coord k) {
		
		return k;
	}
	
	@Override
	public boolean setObj(Useable o)
	{
		return false;
	}

	

}
