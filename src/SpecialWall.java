import java.awt.Image;

import javax.swing.ImageIcon;

public class SpecialWall extends Wall {
	
	public SpecialWall (Coord c) {
		super(c);
		ImageIcon ic = new ImageIcon("specialwall1.jpg");
        image = ic.getImage();
	}
	
	//Megmondja, hogy ONeil mit csináljon, ha falra akar lépni 
		@Override
		public Coord stepOn(Coord k) {
			//System.out.println("swall");
			return k;
		}
		
		@Override
		public boolean fly(Bullet b)
		{
			 b.open();
			 return false;
		}
		
	
}
