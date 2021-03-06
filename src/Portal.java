

//Oszt�ly a Portal kezel�s�re
public class Portal extends Tile {
private Coord location; //a port�l koordin�t�ja
public WormHole wormhole;
Useable object;


//Konstruktor
	Portal(Coord c,char colour,WormHole wh){
		super( new Coord(c.getX(),c.getY()));
		wormhole = wh;
        
       
	};
	
	@Override
	public String getType(){ return "portal";}
	
	//A port�lra l�p�st kezeli
	@Override 
	public Coord stepOn(Coord c) {
		
		if (wormhole.isOpen()==true){  //Ha nyitva van
			
			if(isColour(c,wormhole.getBlue())&& isGoodDir(c,wormhole.getBlueDir(),wormhole.getBlue())){	 // Ez k�k port�l
			
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
					else return c;
				}
			
			if(isColour(c,wormhole.getYellow())&& isGoodDir(c,wormhole.getYellowDir(),wormhole.getYellow())){ //S�rga port�l
				
			
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
			else return c;
			}
			else if (isColour(c,wormhole.getRed())&& isGoodDir(c,wormhole.getRedDir(),wormhole.getRed())){ //Piros port�l
			
		
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
		else if (isColour(c,wormhole.getGreen())&& isGoodDir(c,wormhole.getGreenDir(),wormhole.getGreen())){ //Z�ld port�l
			
		
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
			else return c;
		}
		
		else return c;	 //egy�bk�nt a helyzet�t
		}
	
	//koord lek�rdez�se
	public Coord getLoc()
	{
		return location;
	}
	//koord be�ll�t�sa
	public void setLoc(Coord c)
	{
		location=c;
	}
	
	public Useable getObj(){
		return null;
	}
	
	public boolean setObj(Useable o)
	{
		return false;
	}
	/*
	 * A metodus seg�ts�g�vel hat�rozzuk meg ,hogy a Caracterek �pp melyik port�lon k�sz�lnek �thaladni 
	 * A c-a Caracter koordin�t�ja
	 * A colour a megadott sz�n� port�l coordin�t�ja 
	 * �gy meg�llap�that� , hogy a Caracter melyik port�lra l�phetett r� �pp
	 */
	public boolean isColour(Coord c,Coord colour)
	{   if(colour==null || c==null){
			return false;
			}
		if((1==Math.abs(colour.getX()-c.getX()) &&(0==Math.abs(colour.getY()-c.getY())))|| (0==Math.abs(colour.getX()-c.getX()) &&(1==Math.abs(colour.getY()-c.getY()))))
		return true;
		else 
		return false;
	}
	/*
	 * A Port�lba csak megfelel� ir�nyb�l lehet bemenni , ez a f�ggv�ny true-val t�r vissza ,
	 * ha a Caracter helyes ir�nyba �ll ,illetve false-al ha helytelenbe.
	 */
	public boolean isGoodDir(Coord c,Caracter.Directions dir,Coord colour){
		if(dir==Caracter.Directions.Down){
			if(c.getY()==colour.getY()-1){
				return true;
			}
			return false;
		}
		else if(dir==Caracter.Directions.Up){
			if(c.getY()==colour.getY()+1){
				return true;
			}
			return false;
		}
		else if(dir==Caracter.Directions.Left){
			if(c.getX()==colour.getX()+1){
				return true;
			}
			return false;
		}
		else if(dir==Caracter.Directions.Right){
			if(c.getX()==colour.getX()-1){
				return true;
			}
			return false;
		}
		return false;
	}
	@Override
	public boolean fly(Bullet b)
	 {
		 
		 return false;
	 }

}
