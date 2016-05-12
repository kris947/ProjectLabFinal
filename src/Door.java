import java.awt.Image;

import javax.swing.ImageIcon;

//Oszt�ly a p�ly�n elhelyeszked� ajt�k kezel�s�re
public class Door extends  Wall {
	private Boolean isOpen; //True, ha nyitva az ajt�, false ha csukva
	
	//Konstruktor
	public Door (Coord c) {
		super(c,new ImageIcon("door.jpg").getImage());
		//System.out.println("Door: konsturktor h�v�s");
		isOpen=false; //Alap�rtelmezetten csukva van
        type = "door";
	}
	
	//Met�dus: az ajt� kinyit�s�ra illetve becsuk�s�ra szolg�l
	@Override 
	public void openDoor() {
		//System.out.println("Door: open met�dus h�v�sa");
		if(isOpen==false) //Ha csukva van..
		{
			//System.out.println("Ajt� kinyitva");
			isOpen=true; //..nyissa ki
		}
		else   //Ha nyitva van...
		{
			//System.out.println("Ajt� bez�r�sa");
			isOpen=false; //..csukja be
		} 
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
