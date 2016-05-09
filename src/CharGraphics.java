import java.awt.Image;

public class CharGraphics 
{
	private Coord loc;
	private Image image;
	
	public CharGraphics(Coord loc, Image image)
	{
		this.loc=loc;
		this.image=image;
	}
	
	public Coord getloc(){ return loc;}
	public Image getImage(){ return image;}
}