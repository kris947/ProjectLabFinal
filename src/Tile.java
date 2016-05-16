import java.awt.Image;

/*
 * Ez egy abstract osztály , minden pályaelem õse.
 */
public abstract class Tile {
	public Useable object;
	public Coord location;
	public boolean isOpen;
	public Tile(){}
	
	public String getType(){ return "tile";}
	
	public Tile(Coord c) {
		object = null;
		location = c;
	}
	
	
	public Coord getLoc() {
		return location;
	}
	
	public abstract Coord stepOn(Coord c);
	
	//a tileon lévõ useable-t adja vissza
	public Useable getObj() 
	{		
		return object;
	}
	
	//ha a bullet tovább repülhet akkor true-val tér vissza
	 public boolean fly(Bullet b)
	 {
		 return true;
	 }
	 
	//ezek mind a leszármazottakba valósulnak meg
	public void stepoff(){};
	public void openDoor(){};
	public void closeDoor(){};
	public void setWH(WormHole wh){};
	
	public Useable takeObj(){
				return object;
	}

	//beállítja a tileon lévõ objektumot
	public boolean setObj(Useable o) {
		if(o==null)
			object=o;	
		if(object == null){	
			this.object = o;
			return true;
		}
		else 
		{
			return false;
		}	
	}
    
}
