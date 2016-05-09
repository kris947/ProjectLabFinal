import java.awt.Image;

import javax.swing.ImageIcon;

//Osztály a box megvalósítására
public class Box extends Useable {
 public Image image;
 
 	public Box()
 	{
		ImageIcon ic = new ImageIcon("box.png");
        Image image = ic.getImage();
 	}
   //A használható objektumokkal való interakciót írja le
	@Override
	public void redeem() {
		//System.out.println("Box: redeem metódus hívás");
		
	}

	//visszaadja a zmp-k számát
	@Override
	public int getZPMcount() {
		//System.out.println("Box: getZPMcount metódus hívás");
		return ZPMCount;
	}
	
}
