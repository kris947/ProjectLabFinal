
import java.awt.Image;

public class Control 
{
	public Game game;
	
	public Control(Game game)
	{
		this.game = game;
	}
	
	public Image[] getDrawData(int x, int y)
	{
		Image[] images= new Image[2];
		images[0] = game.getMap().map[y][x].getImage();
		if(game.getMap().map[y][x].getObj() != null)
		{
			
			images[1]= game.getMap().map[y][x].getObj().getImage();
		}
		
		return images;
	}
	
	public CharGraphics ODraw()
	{
		Image image = game.o.getImage();
		Coord c = game.o.getLoc();
		return new CharGraphics(c,image);
	}
	
	public CharGraphics JDraw()
	{
		Image image = game.j.getImage();
		Coord c = game.j.getLoc();
		return new CharGraphics(c,image);
	}
	
	public CharGraphics RDraw()
	{
		Image image = game.r.getImage();
		Coord c = game.r.getLoc();
		return new CharGraphics(c,image);
		
	}
	
	
}
