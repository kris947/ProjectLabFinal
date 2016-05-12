import java.awt.Image;

import javax.swing.ImageIcon;

//Abstract osztály használati tárgyak leírására
public abstract class Useable {
	public  Image image;
	static protected int  ZPMCount=0;
	protected int weight;
	protected String type= "Useable";
	
	public String getType(){return type;}
	
	public abstract  void redeem(); //A használható objektumokkal való interakciót írja le
	{
	}
	public int getZPMcount(){
		return ZPMCount;
	}
    
    public Image getImage() { 	return image; }
}
