import java.awt.Image;

import javax.swing.ImageIcon;

//Abstract oszt�ly haszn�lati t�rgyak le�r�s�ra
public abstract class Useable {
	static protected int  ZPMCount=0;
	protected int weight;
	protected String type= "Useable";
	
	public String getType(){return type;}
	
	public abstract  void redeem(); //A haszn�lhat� objektumokkal val� interakci�t �rja le
	{
	}
	public int getZPMcount(){
		return ZPMCount;
	}
    
   
}
