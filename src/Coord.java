//osztály a pálya koordinátáinak a tárolására
public class Coord {
	private int x;  //adott pont x koordinátáját tárolja
	private int y;  //adott pont y koordinátáját tárolja
	
	//Konstruktor, x,y attribútum értékeinek beállítására
	public  Coord(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	//Metódus az x koordináta lekérdezésére
	public int getX() {
		return x;
	}
	
	//Metódus az y koordináta lekérdezésére
	public int getY() {
		return y;
	}
	
	//Metódus az x koordináta beállítására
	public void setX(int x) {
		this.x=x;
	}
	
	//Metódus az y koordináta beállítására
	public void setY(int y) {
		this.y=y;
	}
	
	public boolean equals(Coord c2)
	{
		if( x==c2.getX() && y == c2.getY() ){ return true;} 
		
		else return false;
	}
}
