import java.awt.Image;

import javax.swing.ImageIcon;

//Osztály a Portal kezelésére
public class Portal extends Tile {
private Coord location; //a portál koordinátája
public WormHole wormhole;
Useable object;
//Image image;

//Konstruktor
	Portal(Coord c,char colour,WormHole wh){
		super( new Coord(c.getX(),c.getY()));
		wormhole = wh;
        type="portal";
	};
	
	/*public void setWH(WormHole wh) {
		wormhole = wh;
	}*/
	
	//A portálra lépést kezeli
	@Override 
	public Coord stepOn(Coord c) {
		
		if (wormhole.isOpen()==true){  //Ha nyitva van
			
			if(isColour(c,wormhole.getBlue())&& isGoodDir(c,wormhole.getBlueDir(),wormhole.getBlue())){	 // ez kék portál
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
					else return c;
				}
			
			if(isColour(c,wormhole.getYellow())&& isGoodDir(c,wormhole.getYellowDir(),wormhole.getYellow())){
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
			//else return location;
			else return c;
			}
			/*else if (isColour(c,wormhole.getRed())&& isGoodDir(c,wormhole.getRedDir(),wormhole.getRed())){
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
		else if (isColour(c,wormhole.getGreen())&& isGoodDir(c,wormhole.getGreenDir(),wormhole.getGreen())){
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
		}*/
			//else return location;
			else return c;
		}
		
		//else return location;	
		else return c;	 //egyébként a helyzetét
		}
	
	//koord lekérdezése
	public Coord getLoc()
	{
		//System.out.println("Portal: getloc metódus hívás");
		return location;
	}
	//koord beállítása
	public void setLoc(Coord c)
	{
		//System.out.println("Portal: setloc metódus hívás");
		location=c;
	}
	
	public Useable getObj(){
		//System.out.println("Portal: getObj metódus hívás");
		return null;
	}
	
	public boolean setObj(Useable o)
	{
		//System.out.println("Portal: setObj metódus hívás");
		return false;
	}
	
	public boolean isColour(Coord c,Coord colour)
	{
		if((1==Math.abs(colour.getX()-c.getX()) &&(0==Math.abs(colour.getY()-c.getY())))|| (0==Math.abs(colour.getX()-c.getX()) &&(1==Math.abs(colour.getY()-c.getY()))))
		return true;
		else 
		return false;
	}
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
		 //System.out.println("Portal: fly metódus hívás");
		 return false;
	 }

}
