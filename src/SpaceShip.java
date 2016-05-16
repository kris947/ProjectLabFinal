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
	 * A p�lyaelemre l�p�s met�dusa
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
    * Egy Useable object elhelyez�se az �rhaj�n.
    */
   @Override
   public boolean setObj(Useable o)
   {
	   if(o == null)	//t�rgy lev�telekor
	   {		
		   object = null;
		   return true;
	   }
	   else
	   {
		   if(object != null) //ha van vmi a spaceshipen akkor nem rakhatunk r� semmit
			   return false;
		   else if (o.redeem()== true)  //ha ZPM-et rak r� akkor az elt�nik
		   {
			   o.redeemed = true;
			   object = null;
			   return true;
		   }
		   else  //ha box-ot akar r�tenni �s nincs rajta semmi akkor r� ker�l
		   {
			   object = o;
			   return true;
		   }
	   }
	   
   }
   

}

	

