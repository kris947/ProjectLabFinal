import java.awt.Image;

import javax.swing.ImageIcon;

//Osztály a pályán elhelyeszkedõ ajtók kezelésére
public class Door extends  Wall {
	private Boolean isOpen; //True, ha nyitva az ajtó, false ha csukva
	
	//Konstruktor
	public Door (Coord c) {
		super(c,new ImageIcon("door.jpg").getImage());
		//System.out.println("Door: konsturktor hívás");
		isOpen=false; //Alapértelmezetten csukva van
        type = "door";
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
		if(isOpen==false) 
		{	
			return c; //visszatér a ONeill koordinátáival zárt ajtó esetén
		}
		else
		{
			return this.getLoc(); //Visszatér az ajtó koordinátájával nyitott ajtó esetén
		}
	}
}
