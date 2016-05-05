import java.awt.Image;

public class SpaceShip extends Tile {
	
	private Coord location;
	Useable object;
	Image image;
	SpaceShip(Coord c){
		super(c);
	}
	
	public void endGame() {
		//System.out.println("A jat�knak v�ge");
	}
	
	public Coord stepOn(Coord c){
		if(object!=null){
		//System.out.println("O'neil a haj� fed�lzet�re l�pett");
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
		//System.out.println("SpaceShip: setObj met�dus h�v�s");
		if(object == null){
		this.object = o;
		object.redeem();
		return true;
		}
		else return false;
   };

}

	

