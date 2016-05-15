import java.awt.Image;

import javax.swing.ImageIcon;

public class SpaceShip extends Tile {
	
	private Coord location;
	//Useable object;
	
	SpaceShip(Coord c){
		super(c);
        type = "spaceship";
	}
	
	public void endGame() {
		//System.out.println("A jat�knak v�ge");
	}
	
	//Ez vsz�n�leg nem is kell , mert Oneil nem is tud r�l�pni az �rhaj�ra , mivel letenni csak maga k�r� tud
	public Coord stepOn(Coord c){
		if(object!=null){
		// Ha a lenyomott billenty� a letev�s , akkor h�v�dik az object.redeem 
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
   //System.out.println("SpaceShip: getObj met�dus h�v�s");
   return location;
   }
   public void setLoc(Coord c){location=c;}
   
   @Override
   public Useable takeObj()
   {
	   return object;
   }

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

	

