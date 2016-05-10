import java.awt.Image;

//A karakterek megjeleniteseert felelos osztaly
public class CharGraphics 
{
	private Coord loc;      //A karakter koordinataja
	private Image image;	//A karakterhez tartozo Image
	
	//Konstruktor
	public CharGraphics(Coord loc, Image image)
	{
		this.loc=loc;
		this.image=image;
	}
	
	//visszaadja a karakter helyzetet
	public Coord getloc(){ return loc;}
	
	//visszadja a karakterhez tartozo kepet
	public Image getImage(){ return image;}
}