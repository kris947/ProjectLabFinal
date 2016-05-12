import java.awt.Image;

import javax.swing.ImageIcon;

//Oszt�ly a ground kezel�s�re
public class Ground extends Tile {
	public Boolean hasLifeOnIT; //t�rolja hogy van-e �let a ground-on
	
	
	//Konstruktor
	public Ground (Coord c) {
		super(c);
		//System.out.println("Ground: konstruktor h�v�s");
		ImageIcon ic = new ImageIcon("ground.jpg");
        image = ic.getImage();
        type = "ground";
	}
	
	//Met�dus annak az esetnek a kezel�s�re ha vki groundra l�p
	@Override
	public Coord stepOn(Coord c) {
		//System.out.println("Ground: stepOn met�dus h�v�s");
		return location; //visszat�r a saj�t koordin�t�ival

	}
	
	
	@Override
	public boolean setObj(Useable object) {
		//System.out.println("Ground: setObj met�dus h�v�s");
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
		//System.out.println("Ground: getObj met�dus h�v�s");
	
		return object;
	}

}
