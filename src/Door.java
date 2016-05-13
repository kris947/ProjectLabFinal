import java.awt.Image;

import javax.swing.ImageIcon;

//Oszt�ly a p�ly�n elhelyeszked� ajt�k kezel�s�re
public class Door extends  Wall {

	
	//Konstruktor
	public Door (Coord c) {
		super(c);
		//System.out.println("Door: konsturktor h�v�s");
		isOpen=false; //Alap�rtelmezetten csukva van
        type = "door";
	}
	
	//Met�dus: az ajt� kinyit�s�ra illetve becsuk�s�ra szolg�l
	@Override 
	public void openDoor() {
			isOpen=true; //..nyissa ki

	}
	@Override
	public void closeDoor(){
		
		isOpen=false;
	}
	
	//Csukott ajt� eset�n nem engedi �t ONeillt, nyitott ajt� eset�n pedig igen
	@Override
	public Coord stepOn(Coord c) {
		if(isOpen==false) 
		{	
			return c; //visszat�r a ONeill koordin�t�ival z�rt ajt� eset�n
		}
		else
		{
			return this.getLoc(); //Visszat�r az ajt� koordin�t�j�val nyitott ajt� eset�n
		}
	}
}
