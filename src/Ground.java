import java.awt.Image;

import javax.swing.ImageIcon;

//Osztály a ground kezelésére
public class Ground extends Tile {
	public Boolean hasLifeOnIT; //tárolja hogy van-e élet a ground-on
	
	
	//Konstruktor
	public Ground (Coord c) {
		super(c);
		//System.out.println("Ground: konstruktor hívás");
		ImageIcon ic = new ImageIcon("ground.jpg");
        image = ic.getImage();
        type = "ground";
	}
	
	//Metódus annak az esetnek a kezelésére ha vki groundra lép
	@Override
	public Coord stepOn(Coord c) {
		//System.out.println("Ground: stepOn metódus hívás");
		return location; //visszatér a saját koordinátáival

	}
	
	
	@Override
	public boolean setObj(Useable object) {
		//System.out.println("Ground: setObj metódus hívás");
		this.object = object;
		
		if(object != null){	
			
			return true;
		}
		else {
			return false;
		}
		
	}
	@Override
	public Useable getObj() {
		//System.out.println("Ground: getObj metódus hívás");
	
		return object;
	}

}
