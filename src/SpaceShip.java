import java.awt.Image;

import javax.swing.ImageIcon;

public class SpaceShip extends Tile {
	
	private Coord location;
	Useable object;
	Image image;
	SpaceShip(Coord c){
		super(c);
		ImageIcon ic = new ImageIcon("spaceship.jpg");
        Image image = ic.getImage();
	}
	
	public void endGame() {
		//System.out.println("A jatéknak vége");
	}
	
	public Coord stepOn(Coord c){
		if(object!=null){
		//System.out.println("O'neil a hajó fedélzetére lépett");
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
   public Useable getObj(){
		//System.out.println("SpaceShip: getObj metódus hívás");
	   return object;}

   public boolean setObj(Useable o){
		//System.out.println("SpaceShip: setObj metódus hívás");
		if(object == null){
		this.object = o;
		object.redeem();
		return true;
		}
		else return false;
   };

}

	

