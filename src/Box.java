
//Osztály a box megvalósítására
public class Box extends Useable {
	
 	//Konstruktor
 	public Box()
 	{
        this.weight=50;			//Alap súly érték megadása
        type="box";
 	}
   //A használható objektumokkal való interakciót írja le
	@Override
	public boolean redeem() {
		return false;
	}

	//visszaadja a zmp-k számát
	@Override
	public int getZPMcount() {
		return ZPMCount;
	}
}
	
	
	
