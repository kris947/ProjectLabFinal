import java.awt.Image;

//Osztály a box megvalósítására
public class Box extends Useable {
 public Image image;
 
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
