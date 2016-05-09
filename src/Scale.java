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
	
	public Scale(Coord location, Coord door, Map map){
		super(location);
		//System.out.println("Scale: konsturktor h�v�s");
		this.door = door;
		this.map = map;
	}
	
	@Override
	public boolean setObj(Useable object) {
		//System.out.println("Scale: setObj met�dus h�v�s");
		this.object = object;
		
		if(object != null){	
			map.map[door.getY()][door.getX()].openDoor();
			return true;
		}
		else {
			return false;
		}
		
	}
	@Override
	public Useable getObj() {
		//System.out.println("Scale: getObj met�dus h�v�s");
		map.map[door.getX()][door.getY()].closeDoor();
		return object;
	}


	@Override
	public Coord stepOn(Coord c) {
		//System.out.println("Scale stepon met�dus");
		map.map[door.getY()][door.getX()].openDoor();
		//System.out.println(door.getX()+"  "+door.getY());
		return location;
		
	}
}
