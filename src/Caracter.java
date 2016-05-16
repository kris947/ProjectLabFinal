
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
	 
	 Directions direction = Directions.Right;		//Alap irány átadása
	 protected int weight;
	 protected boolean paused = false;
	 
	 public Caracter(Map map,int lives)
	 {
			this.map=map;
			this.lives=lives;
	 }
	 
	 public void pause()
	 {
		boolean tmp = paused ;
		if(!tmp) paused = true;
		if(tmp) paused = false;		
	 }
	  
	 public boolean getpause(){return paused;}
	 
	 public void move( Caracter.Directions dir) {
		
		 if(lives>0 && !paused) {
			 		 
			switch (dir) {
				case Up:  //Felfele mozgas
					
					if(direction == dir){		//ha arra akar mozogni amerre néz
					loc = map.map[loc.getY()-1][loc.getX()].stepOn(loc); //akkor arra módosítjuk a helyzetét
					map.map[loc.getY()+1][loc.getX()].stepoff();	//ez a scale-nél használatos
					}
					else
					direction = Directions.Up;		//ha nem arra nézet akkor ezutá arra fog
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
		 if (lives == 0)	//ha elfogy az élete akkor meghívjuk a die() fgv-t
			 this.die();
	 }
	 
	 protected void die() {};
}