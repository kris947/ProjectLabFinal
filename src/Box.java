import java.awt.Image;

import javax.swing.ImageIcon;

//Oszt�ly a box megval�s�t�s�ra
public class Box extends Useable {
	
 	//Konstruktor
 	public Box()
 	{
        this.weight=50;
        type="box";
 	}
   //A haszn�lhat� objektumokkal val� interakci�t �rja le
	@Override
	public boolean redeem() {
		//System.out.println("Box: redeem met�dus h�v�s");
		return false;
	}

	//visszaadja a zmp-k sz�m�t
	@Override
	public int getZPMcount() {
		//System.out.println("Box: getZPMcount met�dus h�v�s");
		return ZPMCount;
	}
}
	
	
	
