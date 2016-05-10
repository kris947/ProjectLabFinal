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
		System.out.println("Wormhole is open");
	}
	public Boolean isOpen() {
		//System.out.println("WormHole: isOpen metódus hívás");
		if (BluePortal!= null && YellowPortal != null) //ha nyitva van egy kek meg egy sarga portal is..
			return true; //..akkor nyitva van a feregjarat
		else 
			return false; //ha nincs, akkor zarva van a feregjarat
	}
	
	//BluePortal koordiatait adja vissza
	public Coord getBlue() {
		//System.out.println("WormHole: getBlue metódus hívás");
		
		return (new Coord(BluePortal.getY(),BluePortal.getX()));
	}
	
	//YellowPortal koordinatait adja vissza
	public Coord getYellow() {
		//System.out.println("WormHole: getYellow metódus hívás");
		return (new Coord(YellowPortal.getY(),YellowPortal.getX()));
	}
	
	//GreenPortal koordinatait adja vissza
	public Coord getGreen() {
		//System.out.println("WormHole: getGreen metódus hívás");
		
		return (new Coord(GreenPortal.getY(),GreenPortal.getX()));
	}
	
	//RedPortal koordinatait adja vissza
	public Coord getRed() {
		//System.out.println("WormHole: getRed metódus hívás");
		
		return (new Coord(RedPortal.getY(),RedPortal.getX()));
	}
	
	//BluePortal koordinatait allitja be 
	public void setBlue(Coord c) {
		//System.out.println("WormHole: setBlue metódus hívás");
		//System.out.println(c.getX()+"  "+c.getY());
		BluePortal = c;
	}
	
	//YellowPortal koordinatait allitja be
	public void setYellow(Coord c) {
		//System.out.println("WormHole: setYellow metódus hívás");
		//System.out.println(c.getX()+"  "+c.getY());
		YellowPortal = c;
	}
	
	//GreenPortal koordinatait allitja be
	public void setGreen(Coord c) {
		//System.out.println("WormHole: setGreen metódus hívás");
		//System.out.println(c.getX()+"  "+c.getY());
		GreenPortal = c;
	}
	
	//RedPortal koordinatait allitja be
	public void setRed(Coord c) {
		//System.out.println("WormHole: setRed metódus hívás");
		//System.out.println(c.getX()+"  "+c.getY());
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
