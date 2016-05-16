import java.awt.Image;

import javax.swing.ImageIcon;

//Oszt�ly a fal t�pus� mez� kezel�s�re
public class Wall extends Tile {
	
	//Megmondja, hogy ONeil mit csin�ljon, ha falra akar l�pni
	public Wall (Coord c) {
		
		super(c);
	}
	
	@Override
	public String getType(){ return "wall";}
	
	//A l�ved�k meg�ll, ha falba csap�dik
	@Override
	 public boolean fly(Bullet b)
	 {
		
		 return false;
		 
	 }
	
	//ONeill nem tud a falra l�pni, ez�rt marad az eredeti hely�n
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
