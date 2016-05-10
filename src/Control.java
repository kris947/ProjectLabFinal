
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Control implements KeyListener
{
	public Game game;
	public View view;
	public Control(Game game)
	{
		this.game = game;
		
	}
	
	public void addView(View view){
		this.view=view;
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
	
	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode());
		
		if(e.getKeyCode() == KeyEvent.VK_W)
		{
			game.o.move(game.o.direction.Up);
			view.Paint();
			System.out.println(game.o.getLoc().getX() + " " + game.o.getLoc().getY());
		}
		else if(e.getKeyCode() == KeyEvent.VK_A)
		{
			game.o.move(game.o.direction.Left);
			view.Paint();
			System.out.println(game.o.getLoc().getX() + " " + game.o.getLoc().getY());

		}
		else if(e.getKeyCode() == KeyEvent.VK_S)
		{
			game.o.move(game.o.direction.Down);
			view.Paint();
			System.out.println(game.o.getLoc().getX() + " " + game.o.getLoc().getY());

		}
		else if(e.getKeyCode() == KeyEvent.VK_D)
		{
			game.o.move(game.o.direction.Right);
			view.Paint();
			System.out.println(game.o.getLoc().getX() + " " + game.o.getLoc().getY());
		}
		else if(e.getKeyCode() == KeyEvent.VK_E)
		{
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_B)
		{
			game.o.shoot('b', game.wh);
		}
		else if(e.getKeyCode() == KeyEvent.VK_Y)
		{
			game.o.shoot('y', game.wh);
		}
	}
	
}
