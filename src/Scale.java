
public class Scale extends Tile {
	private Coord door;
	public Map map;
	public Useable objects[] = new Useable [10];	//a m�rlegen l�v� useable-�k
	public int pressedweight;	//a m�rlegen l�v� dolgok s�lya
	private int objcount = 0;	//a m�rlegen l�v� useable-�k sz�ma
	
	
	public Scale(Coord location, Coord door, Map map)
	{
		super(location);
		this.door = door;
		this.map = map;
		pressedweight=0;
        type="scale";
	}
	
	
	@Override
	public boolean setObj(Useable object) {
		if(object!=null){
		
		pressedweight+=object.getweight();

		objects[objcount]=object;	
		this.object = objects[objcount];
		
		objcount++;
		
		if( pressedweight>=100)	
			map.map[door.getY()][door.getX()].openDoor();
			
			return true;
		
		}
		else {
			return false;
		}
		
	}
	
	//vissza adja a rajta tal�lhat� useable-�k t�mbj�t, ezt a kirajzol�shoz haszn�ljuk
	@Override
	public Useable getObj() 
	{		
		return object;
	}
	
	//ez kezeli ha egy karakter leakar venni valamit a m�rlegr�l
	@Override
	public Useable takeObj(){
		int act=objcount-1;				//legfels� elem indexe
				
		if(act >= 0)					//ha volt valami a m�rlegen
		{
			objcount--;					//cs�kkentjuk az elemsz�mot
			if(act==0)			
				object=null;			//ha ez volt az utols� akkor null lesz a Useable t�mb
			else 
				object=objects[act-1];	
		
			pressedweight-=objects[act].getweight();	//az �sszs�ly cs�kkent�se az adott elem s�ly�val
		
			if( pressedweight<100)
				map.map[door.getY()][door.getX()].closeDoor();
			
			Useable temp = objects[act];
			objects[act]= null;			//kit�rli a t�mbb�l a legfels� elemet
			
			return temp;				//vissza t�r a legfels� elemmel
		}
		else 
		{
			object=null;
			return null;
		}
	}


	@Override
	public Coord stepOn(Coord c) 
	{		
		map.map[door.getY()][door.getX()].openDoor();		
		return location;		
	}
	
	@Override
	public void stepoff(){
		if( pressedweight<100)	
			map.map[door.getY()][door.getX()].closeDoor();
	}
}
