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
		//System.out.println("A jatéknak vége");
	}
	
	//Ez vszínüleg nem is kell , mert Oneil nem is tud rálépni az ûrhajóra , mivel letenni csak maga köré tud
	public Coord stepOn(Coord c){
		if(object!=null){
		// Ha a lenyomott billentyû a letevés , akkor hívódik az object.redeem 
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
   //System.out.println("SpaceShip: getObj metódus hívás");
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

	

