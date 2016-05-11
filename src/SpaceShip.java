import java.awt.Image;

import javax.swing.ImageIcon;

public class SpaceShip extends Tile {
	
	private Coord location;
	Useable object;
	
	SpaceShip(Coord c){
		super(c);
		ImageIcon ic = new ImageIcon("spaceship.jpg");
        image = ic.getImage();
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
   public Useable getObj(){
		//System.out.println("SpaceShip: getObj met�dus h�v�s");
	   return object;}

   public boolean setObj(Useable o){
		//Itt m�g le kell kezelni ha l�d�t tesz�nk r� azt ne nyelje el
	   //System.out.println("SpaceShip: setObj met�dus h�v�s");
		if(object == null){
		this.object = o;
		object.redeem();
		object=null;
		return true;
		}
		else return false;
   };

}

	

