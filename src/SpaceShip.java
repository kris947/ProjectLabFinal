import java.awt.Image;

import javax.swing.ImageIcon;

public class SpaceShip extends Tile {
	
	private Coord location;
	
	
	SpaceShip(Coord c){
		super(c);
     
	}
	
	@Override
	public String getType(){ return "spaceship";}
	
	public void endGame() {
		
	}
	/*
	 * A pályaelemre lépés metódusa
	 * 
	 */
	public Coord stepOn(Coord c){
		if(object!=null){
		
		object.redeem();
		
		if(object.getZPMcount()==7){ 
			endGame();
			return null;
		}
		
		else 
		return c;
		
		}
		else 	
		return c;
	}

   public Coord getLoc(){
   return location;
   }
   public void setLoc(Coord c){location=c;}
   
   @Override
   public Useable takeObj()
   {
	   return object;
   }

   /*
    * Egy Useable object elhelyezése az Ûrhajón.
    */
   @Override
   public boolean setObj(Useable o)
   {
	   if(o == null)	//tárgy levételekor
	   {		
		   object = null;
		   return true;
	   }
	   else
	   {
		   if(object != null) //ha van vmi a spaceshipen akkor nem rakhatunk rá semmit
			   return false;
		   else if (o.redeem()== true)  //ha ZPM-et rak rá akkor az eltünik
		   {
			   o.redeemed = true;
			   object = null;
			   return true;
		   }
		   else  //ha box-ot akar rátenni és nincs rajta semmi akkor rá kerül
		   {
			   object = o;
			   return true;
		   }
	   }
	   
   }
   

}

	

