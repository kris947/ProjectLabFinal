

//Abstract oszt�ly haszn�lati t�rgyak le�r�s�ra
public abstract class Useable {
	static protected int  ZPMCount=0;
	protected int weight = 50;
	protected String type= "Useable";
	
	public String getType(){return type;}
	
	//Igazzal t�r vissza ha bev�lthat�(ZPM) hamissal ha nem
	public abstract  boolean redeem(); //A haszn�lhat� objektumokkal val� interakci�t �rja le
	
	public int getZPMcount(){
		return ZPMCount;
	}
    
	public int getweight()
    {
    	 return weight;
    }
   
}
