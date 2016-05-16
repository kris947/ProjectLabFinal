import java.util.Random;

import javax.swing.ImageIcon;

/*
 * A Replicator mozg�sa , egy sz�lon fog futni , mely  100 ms onk�nt megh�vja a RandDirection, �s RandValue f�ggv�nyt , ami eld�nti ,h milyen
 * ir�nyba , �s mennyit l�p 
 */
public class Replicator extends Caracter{

	public Replicator(Map map,int lives) {
		super(map,lives);
		loc = new Coord(10,10); //(oszlop,sor)
	}	
	
	/*
	 * A Replicator v�letlenszer� mozg�s�hoz minden mozulatsorhoz v�letlenszer�en randomol egy ir�nyt is , ennek a met�dusnak a seg�ts�g�vel.
	 */
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
		else if (n==0){
			 return Caracter.Directions.Left;
		}
		else 
			return Caracter.Directions.Up;
	}
	/*
	 * A Replicator mozgat�s�hoz az �pp aktu�lis l�p�ssz�mhoz gener�l egy v�letlen sz�mot 0-4 k�z�tt
	 */
	public int  RandValue()
	{
		Random rand=new Random();
		return  rand.nextInt(4);
	}
	
	@Override
	 public void DecrementLife()
	{
		lives--;
		map.map[loc.getY()][loc.getX()]=new Ground(loc);
		die();
	}
	
	/*
	 * A Replicator hal�la eset�n megh�vod� met�dus.
	 */
	@Override
	public void die()
	{
		map.game.r = null;
	}
	
}


