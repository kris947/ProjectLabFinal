public class SpecialWall extends Wall {
	
	public SpecialWall (Coord c) {
		super(c);
	}
	
	//Megmondja, hogy ONeil mit csin�ljon, ha falra akar l�pni 
		@Override
		public Coord stepOn(Coord k) {
			//System.out.println("swall");
			return k;
		}
		
		@Override
		public boolean fly(Bullet b)
		{
			 b.open();
			 return false;
		}
		
	
}
