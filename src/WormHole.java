public class WormHole {
	private Coord BluePortal;
	private Coord YellowPortal;
	private Coord RedPortal;
	private Coord GreenPortal;
	
	private Caracter.Directions BlueDirection;
	private Caracter.Directions YellowDirection;
	private Caracter.Directions RedDirection;
	private Caracter.Directions GreenDirection;
	
	//ha bevan allitva kek es sarga portal akkor igazat ad vissza
	//BluePortal es YellowPortal beállitasa kivulrol - Bullet osztalybol
	//vigyazni kell a null beíllitasara ha megszunik a portal
	public WormHole(){
	}
	public Boolean isOpen() {
		
		if ((BluePortal!= null && YellowPortal != null)|| (GreenPortal!= null && RedPortal != null) ){ //ha nyitva van egy kek meg egy sarga portal is..
			
			return true; //..akkor nyitva van a feregjarat
		}
		else 
			return false; //ha nincs, akkor zarva van a feregjarat
	}
	
	//BluePortal koordiatait adja vissza
	public Coord getBlue() {
		if(BluePortal!=null)
			return (new Coord(BluePortal.getY(),BluePortal.getX()));
		else 
			return null;
	}
	
	//YellowPortal koordinatait adja vissza
	public Coord getYellow() {
		if (YellowPortal != null)
			return (new Coord(YellowPortal.getY(),YellowPortal.getX()));
		else 
			return null;
	}
	
	//GreenPortal koordinatait adja vissza
		public Coord getGreen() {
			
			if(GreenPortal!=null)
				return (new Coord(GreenPortal.getY(),GreenPortal.getX()));
			else 
				return null;
		}
		
		//RedPortal koordinatait adja vissza
		public Coord getRed() {
		
			
			if(RedPortal!=null)
				return (new Coord(RedPortal.getY(),RedPortal.getX()));
			else 
				return null;
			
			
		}
	
	//BluePortal koordinatait allitja be 
	public void setBlue(Coord c) {
		
		BluePortal = c;
	}
	
	//YellowPortal koordinatait allitja be
	public void setYellow(Coord c) {
	
		YellowPortal = c;
	}
	
	//GreenPortal koordinatait allitja be
	public void setGreen(Coord c) {
		
		GreenPortal = c;
	}
	
	//RedPortal koordinatait allitja be
	public void setRed(Coord c) {
		
		RedPortal = c;
	}
	public void setBlueDir(Caracter.Directions dir) {
		BlueDirection = dir;
	}
	public void setYellowDir(Caracter.Directions dir) {
		YellowDirection = dir;
	}
	public void setRedDir(Caracter.Directions dir) {
		RedDirection = dir;
	}
	public void setGreenDir(Caracter.Directions dir) {
		GreenDirection = dir;
	}
	public Caracter.Directions getBlueDir(){
		return BlueDirection;
	}
	public Caracter.Directions getYellowDir(){
		return YellowDirection;
	}
	public Caracter.Directions getRedDir(){
		return RedDirection;
	}
	public Caracter.Directions getGreenDir(){
		return GreenDirection;
	}
}
