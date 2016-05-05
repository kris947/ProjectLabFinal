//Oszt�ly a fal t�pus� mez� kezel�s�re
public class Wall extends Tile {
	
	//Megmondja, hogy ONeil mit csin�ljon, ha falra akar l�pni
	public Wall (Coord c) {
		
		super(c);
		//System.out.println("W");
	}
	
	//A l�ved�k meg�ll, ha falba csap�dik
	@Override
	 public boolean fly(Bullet b)
	 {
		//System.out.println("KutyaCica");
		 return false;
		 
	 }
	
	//ONeill nem tud a falra l�pni, ez�rt marad az eredeti hely�n
	@Override
	public Coord stepOn(Coord k) {
		//System.out.println("Falba utkozott");
		return k;
	}

	

}
