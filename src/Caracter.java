import java.awt.Image;
public class Caracter {
	
	 private Image image;
	 int lives; //�leteinek a sz�ma
	 Map map;   
	 public Coord loc;  //koordin�t�i
	 public Useable object; //milyen t�rgy van n�la
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
	 }
	 public void move() {
			switch (direction) {
				case Up:  //Felfele mozg�s
					loc = map.map[loc.getY()-1][loc.getX()].stepOn(loc); //Koordin�t�k be�ll�t�sa
					direction = Directions.Up;
				break;
				case Down: //Lefele mozg�s
					loc = map.map[loc.getY()+1][loc.getX()].stepOn(loc); //Koordin�t�k be�ll�t�sa
					direction = Directions.Down;
				break;
				case Left: //Balra mozg�s
					loc = map.map[loc.getY()][loc.getX()-1].stepOn(loc); //Koordin�t�k be�ll�t�sa
					direction = Directions.Left;
				break;
				case Right: //Jobbra mozg�s
					loc = map.map[loc.getY()][loc.getX()+1].stepOn(loc); //Koordin�t�k be�ll�t�sa
					direction = Directions.Right;
				break;		
			}
		}
	 public Coord getLoc() {
			return loc;
		}

public void DecrementLife(){
	lives--;
}
}