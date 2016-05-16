import java.awt.Image;

import javax.swing.ImageIcon;

public class SpecialWall extends Wall {
	
	public SpecialWall (Coord c) {
		super(c);
       
	}
	
	@Override
	public String getType(){ return "specialwall";}
	
	//Megmondja, hogy ONeil mit csin�ljon, ha falra akar l�pni 
		@Override
		public Coord stepOn(Coord k) {
			
			return k;
		}
		
		@Override
		public boolean fly(Bullet b)
		{
			 b.open();
			 return false;
		}
		
	
}
