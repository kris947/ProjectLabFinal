
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Control implements KeyListener, MouseListener
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
	
	public boolean dooropenat(int x, int y)
	{
		 return game.getMap().map[y][x].isOpen;
		
	}
	
	public CharGraphics ODraw()
	{
		if(game.o ==null)
			return null;
		Coord c = game.o.getLoc();
		Caracter.Directions d = game.o.getDir();
		return new CharGraphics(c,d);
	}
	
	public CharGraphics JDraw()
	{
		if(game.j ==null)
			return null;
		Coord c = game.j.getLoc();
		Caracter.Directions d = game.j.getDir();
		return new CharGraphics(c,d);
	}
	
	public CharGraphics RDraw()
	{
		if(game.r ==null)
			return null;
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
		if(game.o != null)
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
					if(game.o.object != null && game.o.object.getType().equals("box"))
					{
						view.getGpanel().UoneilImage = view.getGpanel().UboxOneil;
						view.getGpanel().DoneilImage = view.getGpanel().DboxOneil;
						view.getGpanel().LoneilImage = view.getGpanel().LboxOneil;
						view.getGpanel().oneilImage = view.getGpanel().RboxOneil;
					}
				}
				else if(game.o.dropDown() == true)
				{
					
					view.getGpanel().UoneilImage = view.getGpanel().UnoboxOneil;
					view.getGpanel().DoneilImage = view.getGpanel().DnoboxOneil;
					view.getGpanel().LoneilImage = view.getGpanel().LnoboxOneil;
					view.getGpanel().oneilImage = view.getGpanel().RnoboxOneil;
				}
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
		
		if(game.j != null)
		{
			if(e.getKeyCode() == KeyEvent.VK_UP)
			{
				game.j.move(game.j.direction.Up);
				view.Paint();
				//System.out.println(game.o.getLoc().getX() + " " + game.o.getLoc().getY());
			}	
			else if(e.getKeyCode() == KeyEvent.VK_DOWN)
			{
				game.j.move(game.j.direction.Down);
				view.Paint();
				//System.out.println(game.o.getLoc().getX() + " " + game.o.getLoc().getY());
			}	
			else if(e.getKeyCode() == KeyEvent.VK_LEFT)
			{
				game.j.move(game.j.direction.Left);
				view.Paint();
				
			}	
			else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			{
				game.j.move(game.j.direction.Right);
				view.Paint();
				
			}
			else if(e.getKeyCode() == KeyEvent.VK_R)
			{
				game.j.shoot('r', game.wh);
				
			
			}
			else if(e.getKeyCode() == KeyEvent.VK_G)
			{
				game.j.shoot('g', game.wh);				
			}

			else if(e.getKeyCode() == KeyEvent.VK_K){
				if(game.j.object==null)
			{
				game.j.pickUp();
				if(game.j.object != null && game.j.object.getType().equals("box"))
				{
					view.getGpanel().UjaffaImage = view.getGpanel().UboxJaffa;
					view.getGpanel().DjaffaImage = view.getGpanel().DboxJaffa;
					view.getGpanel().LjaffaImage = view.getGpanel().LboxJaffa;
					view.getGpanel().RjaffaImage = view.getGpanel().RboxJaffa;
				}
			}
			else if(game.j.dropDown() == true)
			{
				
				view.getGpanel().UjaffaImage = view.getGpanel().UnoboxJaffa;
				view.getGpanel().DjaffaImage = view.getGpanel().DnoboxJaffa;
				view.getGpanel().LjaffaImage = view.getGpanel().LnoboxJaffa;
				view.getGpanel().RjaffaImage = view.getGpanel().RnoboxJaffa;
			}
			view.Paint();
			}
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
		{
			view.setPanel(view.getMpanel());
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

		System.out.println(arg0.getY());
		if(arg0.getX()>240 && arg0.getX()<770 && arg0.getY()>320 && arg0.getY()<395)
			view.setPanel(view.getGpanel());
		if(arg0.getX()>240 && arg0.getX()<770 && arg0.getY()>438 && arg0.getY()<523)
			view.setPanel(view.getRpanel());
		if(arg0.getX()>240 && arg0.getX()<770 && arg0.getY()>578 && arg0.getY()<655)
			view.setPanel(view.getCpanel());
		if(arg0.getX()>240 && arg0.getX()<770 && arg0.getY()>714 && arg0.getY()<788)
			System.exit(0);
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
