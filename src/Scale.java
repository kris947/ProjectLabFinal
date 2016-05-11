import java.awt.Image;

import javax.swing.ImageIcon;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Scale.java
//  @ Date : 2016.03.27.
//  @ Author : 
//
//




public class Scale extends Tile {
	private Coord door;
	public Map map;
	public Useable objects[]=new Useable [10];
	public int pressedweight;
	public Scale(Coord location, Coord door, Map map){
		super(location);
		//System.out.println("Scale: konsturktor h�v�s");
		this.door = door;
		this.map = map;
	//	objects=new Useable() [] ;
		pressedweight=0;
		ImageIcon ic = new ImageIcon("scale.jpg");
        image = ic.getImage();
	}
	
	@Override
	public boolean setObj(Useable object) {
		if(object!=null){
		System.out.println("Scale: setObj met�dus h�v�s");
		//this.object = object;
		pressedweight+=50;
		objects[(pressedweight / 50)-1]=object;
		System.out.println(pressedweight);
		if( pressedweight>=100)	
			map.map[door.getY()][door.getX()].openDoor();
			
			return true;
		
		}
		else {
			return false;
		}
		
	}
	@Override
	public Useable getObj() {
		
		map.map[door.getX()][door.getY()].closeDoor();
		return object;
	}


	@Override
	public Coord stepOn(Coord c) {
		
		map.map[door.getY()][door.getX()].openDoor();
		
		return location;
		
	}
	
	@Override
	public void stepoff(){
		map.map[door.getY()][door.getX()].closeDoor();
	}
}
