import java.awt.Image;

//A karakterek megjeleniteseert felelos osztaly
public class CharGraphics 
{
	private Coord loc;      //A karakter koordinataja
	Caracter.Directions dir;	//A karakterhez tartozo ir�ny
	
	//Konstruktor
	public CharGraphics(Coord loc, Caracter.Directions d)
	{
		this.loc=loc;			//Be�ll�tja a helyzetet
		dir =d;					//Be�ll�tja az ir�nyt
	}
	
	//visszaadja a karakter helyzetet
	public int getX(){ return loc.getX();}
	public int getY(){ return loc.getY();}
	
	//visszadja a karakterhez tartozo kepet
	public Caracter.Directions getDir(){ return dir;}
}