import java.awt.Image;

import javax.swing.ImageIcon;

//Osztály a pályán elhelyeszkedõ ajtók kezelésére
public class Door extends  Wall {

	
	//Konstruktor
	public Door (Coord c) {
		super(c);
		//System.out.println("Door: konsturktor hívás");
		isOpen=false; //Alapértelmezetten csukva van
        type = "door";
	}
	
	//Metódus: az ajtó kinyitására illetve becsukására szolgál
	@Override 
	public void openDoor() {
			isOpen=true; //..nyissa ki

	}
	@Override
	public void closeDoor(){
		
		isOpen=false;
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
