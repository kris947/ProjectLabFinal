
//Oszt�ly a box megval�s�t�s�ra
public class Box extends Useable {
	
 	//Konstruktor
 	public Box()
 	{
        this.weight=50;			//Alap s�ly �rt�k megad�sa
        type="box";
 	}
   //A haszn�lhat� objektumokkal val� interakci�t �rja le
	@Override
	public boolean redeem() {
		return false;
	}

	//visszaadja a zmp-k sz�m�t
	@Override
	public int getZPMcount() {
		return ZPMCount;
	}
}
	
	
	
