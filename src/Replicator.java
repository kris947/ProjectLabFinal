import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

/*
 * A Replicator mozg�sa , egy sz�lon fog futni , mely  100 ms onk�nt megh�vja a RandDirection, �s RandValue f�ggv�nyt , ami eld�nti ,h milyen
 * ir�nyba , �s mennyit l�p 
 */
public class Replicator extends Caracter{

	public Replicator(Map map,int lives) {
		super(map,lives);
		loc = new Coord(2,1); //(oszlop,sor)
		ImageIcon ic = new ImageIcon("replicator.png");
        Image image = ic.getImage();
	}	
	
	public void RandDirection(){
		Random rand=new Random();
		int n=rand.nextInt(4);
		if (n==1){
			direction=Directions.Up;
		}
		else if (n==2){
			direction=Directions.Down;
		}
		else if (n==3){
			direction=Directions.Right;
		}
		else if (n==4){
			direction=Directions.Left;
		}
	}
	
	public int  RandValue(){
		Random rand=new Random();
		return  rand.nextInt(10);
	}
	
	@Override
	 public void DecrementLife(){
		 lives--;
		 map.map[loc.getX()][loc.getY()]=new Ground(loc);		 
	 }
	
}


