import java.awt.Image;

import javax.swing.ImageIcon;

//Osztály a fal típusú mezõ kezelésére
public class Wall extends Tile {
	
	//Megmondja, hogy ONeil mit csináljon, ha falra akar lépni
	public Wall (Coord c, Image image) {
		
		super(c);
		//System.out.println("W");
        this.image = image;
        type= "wall";
	}
	
	//A lövedék megáll, ha falba csapódik
	@Override
	 public boolean fly(Bullet b)
	 {
		//System.out.println("KutyaCica");
		 return false;
		 
	 }
	
	//ONeill nem tud a falra lépni, ezért marad az eredeti helyén
	@Override
	public Coord stepOn(Coord k) {
		//System.out.println("Falba utkozott");
		return k;
	}

	

}
