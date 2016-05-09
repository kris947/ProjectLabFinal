import java.awt.Image;

import javax.swing.ImageIcon;

//Osztály a pályán elhelyeszkedõ ajtók kezelésére
public class Door extends  Wall {
	private Boolean isOpen; //True, ha nyitva az ajtó, false ha csukva
	
	//Konstruktor
	public Door (Coord c) {
		super(c);
		//System.out.println("Door: konsturktor hívás");
		isOpen=false; //Alapértelmezetten csukva van
		ImageIcon ic = new ImageIcon("door1.jpg");
        image = ic.getImage();
	}
	
	//Metódus: az ajtó kinyitására illetve becsukására szolgál
	@Override 
	public void openDoor() {
		//System.out.println("Door: open metódus hívása");
		if(isOpen==false) //Ha csukva van..
		{
			//System.out.println("Ajtó kinyitva");
			isOpen=true; //..nyissa ki
		}
		else   //Ha nyitva van...
		{
			//System.out.println("Ajtó bezárása");
			isOpen=false; //..csukja be
		} 
	}
	
	//Csukott ajtó esetén nem engedi át ONeillt, nyitott ajtó esetén pedig igen
	@Override
	public Coord stepOn(Coord c) {
		System.out.println("Door: stepOn metódus hívás");
		if(isOpen==false)
		{	
			System.out.println("ONeill marad a helyén.");
			return c; //visszatér a ONeill koordinátáival
		}
		else
		{
			System.out.println("ONeill átmehet az ajtón");
			return this.getLoc(); //Visszatér az ajtó koordinátájával
		}
	}
}
