import java.awt.Image;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Tile.java
//  @ Date : 2016.03.27.
//  @ Author : 
//
//




public abstract class Tile {
	protected Image image;
	public Useable object;
	public Coord location;
	
	public Tile(){
		
	}
	
	public Tile(Coord c) {
		object = null;
		location = c;
	}
	
	
	public Coord getLoc() {
		return location;
	}
	
	public abstract Coord stepOn(Coord c);
	
	public Useable getObj() {
		//System.out.println("Tile: getObj met�dus h�v�s");
		return object;
	}
	
	 public boolean fly(Bullet b)
	 {

		 return true;
	 }
	
	public void stepoff(){};
	public void openDoor(){};
	public void closeDoor(){};
	public void setWH(WormHole wh){};
	 
	public boolean setObj(Useable object) {
		//System.out.println("Tile: setObj met�dus h�v�s");
		if(object == null){
		this.object = object;
		return true;
		}
		else return false;
	}
    
    public Image getImage() { return image; }
	
	
}
