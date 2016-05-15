import java.awt.Image;
public class Caracter {
	
	 protected int lives; //életeinek a száma
	 public Map map;   
	 public Coord loc;  //koordinátái
	 public Useable object; //milyen tárgy van nála
	 public enum Directions{
		  Up, 
		  Down, 
		  Left, 
		  Right  
		}
	 Directions direction = Directions.Right;
	 protected int weight;
	 
	 public Caracter(Map map,int lives){
			this.map=map;
			this.lives=lives;
	 }
	 
	 public void move( Caracter.Directions dir) {
		
		 if(lives>0) {
			 		 
			switch (dir) {
				case Up:  //Felfele mozgas
					
					if(direction == dir){
					loc = map.map[loc.getY()-1][loc.getX()].stepOn(loc); 
					map.map[loc.getY()+1][loc.getX()].stepoff();
					}
					else
					direction = Directions.Up;
				break;
				
				case Down: //Lefele mozg�s
					if(direction == dir){
					loc = map.map[loc.getY()+1][loc.getX()].stepOn(loc); 
					map.map[loc.getY()-1][loc.getX()].stepoff();
					}
					else
					direction = Directions.Down;
				break;
				
				case Left: //Balra mozg�s
					if(direction == dir){
					loc = map.map[loc.getY()][loc.getX()-1].stepOn(loc); 
					map.map[loc.getY()][loc.getX()+1].stepoff();
					}
					else
					direction = Directions.Left;
				break;
				
				case Right: //Jobbra mozg�s
					if(direction == dir){
					loc = map.map[loc.getY()][loc.getX()+1].stepOn(loc); 
					map.map[loc.getY()][loc.getX()-1].stepoff();
					}
					else
					direction = Directions.Right;
				break;		
			}
		 }
	 }
	 
	 //visszadja ONeill eleteinek a szamat
	 public int getLife()
	 {
		 return lives;
	 }
	 public Caracter.Directions getDir(){return direction; }
	 
	 //visszadja ONeill helyzetet
	 public Coord getLoc() {
		return loc;
	}

	 //csokkenti ONeill eleteinek a szamat eggyel
	 public void DecrementLife(){
		 object=null;
		 lives--;
		 if (lives == 0)
			 this.die();
	 }
	 
	 protected void die() {};
}