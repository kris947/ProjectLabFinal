import java.awt.Image;




public class Caracter {

	private Image image;
	 int lives; //életeinek a száma
	 Map map;   
	 public Coord loc;  //koordinátái
	 public Useable object; //milyen tárgy van nála
	 public enum Directions{
		  Up, 
		  Down, 
		  Left, 
		  Right
		  
		}
	 Directions direction = Directions.Right;
	 public Caracter(Map map,int lives){
			this.map=map;
			this.lives=lives;
	 };
	 public void move() {
			//System.out.println("ONeil: move metódus hívás");
			switch (direction) {
				case Up:  //Felfele mozgás
					loc = map.map[loc.getY()-1][loc.getX()].stepOn(loc); //Koordináták beállítása
					direction = Directions.Up;
				break;
				case Down: //Lefele mozgás
					loc = map.map[loc.getY()+1][loc.getX()].stepOn(loc); //Koordináták beállítása
					direction = Directions.Down;
				break;
				case Left: //Balra mozgás
					loc = map.map[loc.getY()][loc.getX()-1].stepOn(loc); //Koordináták beállítása
					direction = Directions.Left;
				break;
				case Right: //Jobbra mozgás
					loc = map.map[loc.getY()][loc.getX()+1].stepOn(loc); //Koordináták beállítása
					direction = Directions.Right;
				break;		
			}
			
		}
	 public Coord getLoc() {
			//System.out.println("ONeil: getloc metódus hívás");
			return loc;
		}
}
