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
		System.out.println("kuyta");
		if (wormhole.isOpen()==true){  //Ha nyitva van
			
			if(wormhole.getBlue().getX()==c.getX()+1 && wormhole.getBlue().getY()==c.getY()){	 //�s ez k�k port�l
				return wormhole.getYellow(); //adja vissza a s�rga koordin�t�it
				}
			else
			{
				Coord cord= new Coord(0,0);
				cord.setX(wormhole.getBlue().getX()-1);
				cord.setY(wormhole.getBlue().getY());
				return cord;
				
			}//egy�bk�nt a k�k�t
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
