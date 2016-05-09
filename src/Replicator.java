import java.util.Random;

/*
 * A Replicator mozg�sa , egy sz�lon fog futni , mely  100 ms onk�nt megh�vja a RandDirection, �s RandValue f�ggv�nyt , ami eld�nti ,h milyen
 * ir�nyba , �s mennyit l�p 
 */
public class Replicator extends Caracter{

	public Replicator(Map map,int lives) {
		super(map,lives);
		loc = new Coord(2,1); //(oszlop,sor)
	}	
	
	public Caracter.Directions RandDirection(){
		Random rand=new Random();
		int n=rand.nextInt(4);
		if (n==1){
			return Caracter.Directions.Up;
		}
		else if (n==2){
			return Caracter.Directions.Down;
		}
		else if (n==3){
			 return Caracter.Directions.Right;
		}
		else if (n==4){
			 return Caracter.Directions.Left;
		}
		else 
			return direction;
	}
	
	public int  RandValue(){
		Random rand=new Random();
		return  rand.nextInt(3);
	}
	
	@Override
	 public void DecrementLife(){
		 lives--;
		 map.map[loc.getX()][loc.getY()]=new Ground(loc);		 
	 }
	
}


