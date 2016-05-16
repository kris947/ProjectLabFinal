
public class Scale extends Tile {
	private Coord door;
	public Map map;
	public Useable objects[] = new Useable [10];	//a mérlegen lévõ useable-ök
	public int pressedweight;	//a mérlegen lévõ dolgok súlya
	private int objcount = 0;	//a mérlegen lévõ useable-ök száma
	
	
	public Scale(Coord location, Coord door, Map map)
	{
		super(location);
		this.door = door;
		this.map = map;
		pressedweight=0;
       
	}
	
	@Override
	public String getType(){ return "scale";}
	
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
	
	//Vissza adja a rajta található useable-ök tömbjét, ezt a kirajzoláshoz használjuk
	@Override
	public Useable getObj() 
	{		
		return object;
	}
	
	//Ez kezeli ha egy karakter leakar venni valamit a mérlegrõl
	@Override
	public Useable takeObj(){
		int act=objcount-1;				//legfelsõ elem indexe
				
		if(act >= 0)					//ha volt valami a mérlegen
		{
			objcount--;					//csökkentjuk az elemszámot
			if(act==0)			
				object=null;			//ha ez volt az utolsó akkor null lesz a Useable tömb
			else 
				object=objects[act-1];	
		
			pressedweight-=objects[act].getweight();	//az összsúly csökkentése az adott elem súlyával
		
			if( pressedweight<100)
				map.map[door.getY()][door.getX()].closeDoor();
			
			Useable temp = objects[act];
			objects[act]= null;			//kitörli a tömbbõl a legfelsõ elemet
			
			return temp;				//vissza tér a legfelsõ elemmel
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
	
	//ha a karakter lelép a mérlegrõl ez hívódik meg
	@Override
	public void stepoff()
	{
		if( pressedweight<100)	//ha nincs elég súly akkor becsukódik az ajtó
			map.map[door.getY()][door.getX()].closeDoor();
	}
}
