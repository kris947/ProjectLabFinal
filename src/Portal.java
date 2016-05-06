import java.awt.Image;

//Oszt�ly a Portal kezel�s�re
public class Portal extends Tile {
private Coord location; //a port�l koordin�t�ja
public WormHole wormhole;
Useable object;
Image image;

//Konstruktor
	Portal(Coord c){
		super( new Coord(c.getX(),c.getY()));
		//System.out.println("Portal: konstruktor h�v�s");
	};
	
	public void setWH(WormHole wh) {
		wormhole = wh;
	}
	
	//A port�lra l�p�st kezeli
	@Override 
	public Coord stepOn(Coord c) {
		//System.out.println("kuyta");
		if (wormhole.isOpen()==true){  //Ha nyitva van
			
			if((1==Math.abs(wormhole.getBlue().getX()-c.getX()) &&(0==Math.abs(wormhole.getBlue().getY()-c.getY())))|| (0==Math.abs(wormhole.getBlue().getX()-c.getX()) &&(1==Math.abs(wormhole.getBlue().getY()-c.getY())))){	 // ez k�k port�l
			System.out.println("From Blue to Yellow");
			if(wormhole.getYellowDir()==ONeil.Directions.Up){
				Coord cord= new Coord(0,0);
				cord.setX(wormhole.getYellow().getX());
				cord.setY(wormhole.getYellow().getY()+1);
				return cord;
				}
			else if(wormhole.getYellowDir()==ONeil.Directions.Down){
				Coord cord= new Coord(0,0);
				cord.setX(wormhole.getYellow().getX());
				cord.setY(wormhole.getYellow().getY()-1);
				return cord;
				}
			else if(wormhole.getYellowDir()==ONeil.Directions.Right){
				System.out.println("From Right");
				Coord cord= new Coord(0,0);
				cord.setX(wormhole.getYellow().getX()-1);
				cord.setY(wormhole.getYellow().getY());
				return cord;
				}
			else	if(wormhole.getYellowDir()==ONeil.Directions.Left){
				Coord cord= new Coord(0,0);
				cord.setX(wormhole.getYellow().getX()+1);
				cord.setY(wormhole.getYellow().getY());
				return cord;
				}
					else return location;
				}
			
			if((1==Math.abs(wormhole.getYellow().getX()-c.getX()) &&(0==Math.abs(wormhole.getYellow().getY()-c.getY())))|| (0==Math.abs(wormhole.getYellow().getX()-c.getX()) &&(1==Math.abs(wormhole.getYellow().getY()-c.getY())))){
				System.out.println("From Yellow to Blue side");
			
			if(wormhole.getBlueDir()==ONeil.Directions.Up){
				Coord cord= new Coord(0,0);
				cord.setX(wormhole.getBlue().getX());
				cord.setY(wormhole.getBlue().getY()+1);
				return cord;
				
				}
			else if(wormhole.getBlueDir()==ONeil.Directions.Down){
				Coord cord= new Coord(0,0);
				cord.setX(wormhole.getBlue().getX());
				cord.setY(wormhole.getBlue().getY()-1);
				return cord;
				
				}
			else if(wormhole.getBlueDir()==ONeil.Directions.Right){
				System.out.println("From Right");
				Coord cord= new Coord(0,0);
				cord.setX(wormhole.getBlue().getX()-1);
				cord.setY(wormhole.getBlue().getY());
				return cord;
				
				}
			else if(wormhole.getBlueDir()==ONeil.Directions.Left){
				Coord cord= new Coord(0,0);
				cord.setX(wormhole.getBlue().getX()+1);
				cord.setY(wormhole.getBlue().getY());
				return cord;
				}
			else return location;
			}
			else if (wormhole.getRed().getX()==c.getX()+1 && wormhole.getRed().getY()==c.getY()){
			System.out.println("From Red to Green side");
		
		if(wormhole.getGreenDir()==Jaffa.Directions.Up){
			Coord cord= new Coord(0,0);
			cord.setX(wormhole.getGreen().getX());
			cord.setY(wormhole.getGreen().getY()+1);
			return cord;
			
			}
		else if(wormhole.getGreenDir()==Jaffa.Directions.Down){
			Coord cord= new Coord(0,0);
			cord.setX(wormhole.getGreen().getX());
			cord.setY(wormhole.getGreen().getY()-1);
			return cord;
			
			}
		else if(wormhole.getGreenDir()==Jaffa.Directions.Right){
			System.out.println("From Right");
			Coord cord= new Coord(0,0);
			cord.setX(wormhole.getGreen().getX()-1);
			cord.setY(wormhole.getGreen().getY());
			return cord;
			
			}
		else if(wormhole.getGreenDir()==Jaffa.Directions.Left){
			Coord cord= new Coord(0,0);
			cord.setX(wormhole.getGreen().getX()+1);
			cord.setY(wormhole.getGreen().getY());
			return cord;
			}
		else return location;
		}
		else if (wormhole.getGreen().getX()==c.getX()+1 && wormhole.getGreen().getY()==c.getY()){
			System.out.println("From Green to Red side");
		
		if(wormhole.getRedDir()==Jaffa.Directions.Up){
			Coord cord= new Coord(0,0);
			cord.setX(wormhole.getRed().getX());
			cord.setY(wormhole.getRed().getY()+1);
			return cord;
			
			}
		else if(wormhole.getRedDir()==Jaffa.Directions.Down){
			Coord cord= new Coord(0,0);
			cord.setX(wormhole.getRed().getX());
			cord.setY(wormhole.getRed().getY()-1);
			return cord;
			
			}
		else if(wormhole.getRedDir()==Jaffa.Directions.Right){
			System.out.println("From Right");
			Coord cord= new Coord(0,0);
			cord.setX(wormhole.getRed().getX()-1);
			cord.setY(wormhole.getRed().getY());
			return cord;
			
			}
		else if(wormhole.getRedDir()==Jaffa.Directions.Left){
			Coord cord= new Coord(0,0);
			cord.setX(wormhole.getRed().getX()+1);
			cord.setY(wormhole.getRed().getY());
			return cord;
			}
		else return location;
		}
			else return location;
		}
		
			
		else return location;	 //egy�bk�nt a helyzet�t
		}
	
	//koord lek�rdez�se
	public Coord getLoc()
	{
		//System.out.println("Portal: getloc met�dus h�v�s");
		return location;
	}
	//koord be�ll�t�sa
	public void setLoc(Coord c)
	{
		//System.out.println("Portal: setloc met�dus h�v�s");
		location=c;
	}
	
	public Useable getObj(){
		//System.out.println("Portal: getObj met�dus h�v�s");
		return null;
	}
	
	public boolean setObj(Useable o)
	{
		//System.out.println("Portal: setObj met�dus h�v�s");
		return false;
	}
	
	
	@Override
	public boolean fly(Bullet b)
	 {
		 //System.out.println("Portal: fly met�dus h�v�s");
		 return false;
	 }

}
