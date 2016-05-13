import java.awt.Image;

import javax.swing.ImageIcon;

//Osztály a box megvalósítására
public class Box extends Useable {
	
 	//Konstruktor
 	public Box()
 	{
        this.weight=50;
        type="box";
 	}
   //A használható objektumokkal való interakciót írja le
	@Override
	public boolean redeem() {
		//System.out.println("Box: redeem metódus hívás");
		return false;
	}

	//visszaadja a zmp-k számát
	@Override
	public int getZPMcount() {
		//System.out.println("Box: getZPMcount metódus hívás");
		return ZPMCount;
	}
}
	
	
	
