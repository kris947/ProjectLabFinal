import java.awt.Image;

import javax.swing.ImageIcon;

//Oszt�ly a box megval�s�t�s�ra
public class Box extends Useable {
 public Image image;
 
 	//Konstruktor
 	public Box()
 	{
		ImageIcon ic = new ImageIcon("box.png");
        image = ic.getImage();
 	}
   //A haszn�lhat� objektumokkal val� interakci�t �rja le
	@Override
	public void redeem() {
		//System.out.println("Box: redeem met�dus h�v�s");
		
	}

	//visszaadja a zmp-k sz�m�t
	@Override
	public int getZPMcount() {
		//System.out.println("Box: getZPMcount met�dus h�v�s");
		return ZPMCount;
	}
	
	//Visszadja az Image-t
	@Override
	 public Image getImage() { return image; }
}
