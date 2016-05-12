
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
	public String[] getDrawData(int x, int y)
	{
		String[] types= new String[2];
		types[0] = game.getMap().map[y][x].getType();
		if(game.getMap().map[y][x].getObj() != null)
		{
			types[1]= game.getMap().map[y][x].getObj().getType();
		}
		
		return types;
	}
	
	public CharGraphics ODraw()
	{
		
		Coord c = game.o.getLoc();
		Caracter.Directions d = game.o.getDir();
		return new CharGraphics(c,d);
	}
	
	public CharGraphics JDraw()
	{
		
		Coord c = game.j.getLoc();
		Caracter.Directions d = game.j.getDir();
		return new CharGraphics(c,d);
	}
	
	public CharGraphics RDraw()
	{
		Coord c = game.r.getLoc();
		Caracter.Directions d = game.r.getDir();
		return new CharGraphics(c,d);
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
	
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		
		if(e.getKeyCode() == KeyEvent.VK_W)
		{
			game.o.move(game.o.direction.Up);
			view.Paint();
			//System.out.println(game.o.getLoc().getX() + " " + game.o.getLoc().getY());
		}
		else if(e.getKeyCode() == KeyEvent.VK_A)
		{
			game.o.move(game.o.direction.Left);
			view.Paint();
			//System.out.println(game.o.getLoc().getX() + " " + game.o.getLoc().getY());

		}
		else if(e.getKeyCode() == KeyEvent.VK_S)
		{
			game.o.move(game.o.direction.Down);
			view.Paint();
			//System.out.println(game.o.getLoc().getX() + " " + game.o.getLoc().getY());

		}
		else if(e.getKeyCode() == KeyEvent.VK_D)
		{
			game.o.move(game.o.direction.Right);
			view.Paint();
			//System.out.println(game.o.getLoc().getX() + " " + game.o.getLoc().getY());
		}
		else if(e.getKeyCode() == KeyEvent.VK_E)
		{
			if(game.o.object==null)
			{
				game.o.pickUp();
			}
			else 
				game.o.dropDown();
			view.Paint();
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
