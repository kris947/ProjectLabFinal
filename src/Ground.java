import java.awt.Image;

import javax.swing.ImageIcon;

//Osztály a ground kezelésére
public class Ground extends Tile {
	public Boolean hasLifeOnIT; //tárolja hogy van-e élet a ground-on
	
	
	//Konstruktor
	public Ground (Coord c) {
		super(c);
		//System.out.println("Ground: konstruktor hívás");
       
	}
	
	@Override
	public String getType(){ return "ground";}
	
	//Metódus annak az esetnek a kezelésére ha vki groundra lép
	@Override
	public Coord stepOn(Coord c) {
		//System.out.println("Ground: stepOn metódus hívás");
		return location; //visszatér a saját koordinátáival

	}
	

	
	@Override
	public Useable getObj() {
		//System.out.println("Ground: getObj metódus hívás");
	
		return object;
	}

}
