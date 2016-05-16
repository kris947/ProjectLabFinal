
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
	private boolean paused;
	private boolean inMPanel;		//Benne vagyunk-e vmilyen men�panelban
	
	Clock clock = new Clock();
	
	//Konstruktor
	public Control(Game game)
	{
		this.game = game;
		inMPanel = false;
		
	}
	
	//Megefelel� n�zet t�rs�t�sa
	public void addView(View view){
		this.view=view;
	}
	
	//T�pusok meghat�roz�sa
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
	
	//Nyitva van-e az ajt�
	public boolean dooropenat(int x, int y)
	{
		 return game.getMap().map[y][x].isOpen;
		
	}
	
	//ONeil adatai a kirajzol�shoz
	public CharGraphics ODraw()
	{
		if(game.o ==null)
			return null;
		Coord c = game.o.getLoc();
		Caracter.Directions d = game.o.getDir();
		return new CharGraphics(c,d);
	}
	
	//Jaffa adatai a kirajzol�shoz
	public CharGraphics JDraw()
	{
		if(game.j ==null)
			return null;
		Coord c = game.j.getLoc();
		Caracter.Directions d = game.j.getDir();
		return new CharGraphics(c,d);
	}
	
	//Replik�tor adatai a kirajzol�shoz
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

	//A lenyomott billenyt�k lekezel�se
	@Override
	public void keyPressed(KeyEvent e)
	{
		if(game.o != null)
		{
			if(e.getKeyCode() == KeyEvent.VK_W)				//ONeil felfel� n�z
			{
				game.o.move(game.o.direction.Up);			//ONeil move met�dusa a felfele ir�nyra
				view.Paint();								//�jrarajzol�s
			}
			else if(e.getKeyCode() == KeyEvent.VK_A)		//ONeil balra n�z
			{
				game.o.move(game.o.direction.Left);			//ONeil move met�dusa a bal ir�nyra
				view.Paint();								//�jrarajzol�s
	
			}
			else if(e.getKeyCode() == KeyEvent.VK_S)		//ONeil lefel� n�z
			{
				game.o.move(game.o.direction.Down);			//ONeil move met�dusa a lefel� ir�nyra
				view.Paint();								//�jrarajzol�s
	
			}
			else if(e.getKeyCode() == KeyEvent.VK_D)		//ONeil jobbra n�z
			{
				game.o.move(game.o.direction.Right);		//ONeil move met�dusa a jobb ir�nyra
				view.Paint();								//�jrarajzol�s
			}
			else if(e.getKeyCode() == KeyEvent.VK_E)		//ONeil objektumhaszn�lta
			{
				if(game.o.object==null)						//ha nincs
				{
					game.o.pickUp();						//felvesz
					if(game.o.object != null && game.o.object.getType().equals("box"))		//doboz, �s melyik ir�nyba n�z
					{
						view.getGpanel().UoneilImage = "UboxO.png";
						view.getGpanel().DoneilImage = "DboxO.png";
						view.getGpanel().LoneilImage = "LboxO.png";
						view.getGpanel().oneilImage = "RboxO.png";
					}
					if(game.o.object != null && game.o.object.getType().equals("zpm"))		//zpm, �s melyik ir�nyba n�z
					{
						view.getGpanel().UoneilImage = "UzpmO.png";
						view.getGpanel().DoneilImage = "DzpmO.png";
						view.getGpanel().LoneilImage = "LzpmO.png";
						view.getGpanel().oneilImage = "RzpmO.png";
					}
				}
				else if(game.o.dropDown() == true)			//ha eldobja
				{
					view.getGpanel().UoneilImage = "OneilUp.png";
					view.getGpanel().DoneilImage = "ONeilD.png";
					view.getGpanel().LoneilImage = "ONeilL.png";
					view.getGpanel().oneilImage = "ONeilR.png";
				}
				view.Paint();
			}
			else if(e.getKeyCode() == KeyEvent.VK_B)		//ONeil k�k l�v�s
			{
				game.o.shoot('b', game.wh);
			}
			else if(e.getKeyCode() == KeyEvent.VK_Y)		//ONeil s�rga l�v�s
			{
				game.o.shoot('y', game.wh);
			}
		}
		
		if(game.j != null)
		{
			if(e.getKeyCode() == KeyEvent.VK_UP)			//Jaffa felfel� n�z
			{
				game.j.move(game.j.direction.Up);
				view.Paint();
			}	
			else if(e.getKeyCode() == KeyEvent.VK_DOWN)		//Jaffa lefel� n�z
			{
				game.j.move(game.j.direction.Down);
				view.Paint();
			}	
			else if(e.getKeyCode() == KeyEvent.VK_LEFT)		//Jaffa balra n�z
			{
				game.j.move(game.j.direction.Left);
				view.Paint();
			}	
			else if(e.getKeyCode() == KeyEvent.VK_RIGHT)	//Jaffa jobbra n�z
			{
				game.j.move(game.j.direction.Right);
				view.Paint();
			}
			else if(e.getKeyCode() == KeyEvent.VK_R)		//Jaffa piros l�v�s
			{
				game.j.shoot('r', game.wh);
			}
			else if(e.getKeyCode() == KeyEvent.VK_G)		//Jaffa piros l�v�s
			{
				game.j.shoot('g', game.wh);				
			}

			else if(e.getKeyCode() == KeyEvent.VK_K){		//Jaffa objektumhaszn�lata
				if(game.j.object==null)
			{
				game.j.pickUp();
				if(game.j.object != null && game.j.object.getType().equals("box"))	//ha doboz van n�la
				{
					view.getGpanel().UjaffaImage = "UboxJ.png";
					view.getGpanel().DjaffaImage = "DboxJ.png";
					view.getGpanel().LjaffaImage = "LboxJ.png";
					view.getGpanel().RjaffaImage = "RboxJ.png";
				}
				if(game.j.object != null && game.j.object.getType().equals("zpm")) //ha zpm van n�la
				{
					view.getGpanel().UjaffaImage = "UzpmJ.png";
					view.getGpanel().DjaffaImage = "DzpmJ.png";
					view.getGpanel().LjaffaImage = "LzpmJ.png";
					view.getGpanel().RjaffaImage = "RzpmJ.png";
				}
			}
			else if(game.j.dropDown() == true)
			{
				
				view.getGpanel().UjaffaImage = "Jaffa1.png";
				view.getGpanel().DjaffaImage = "Jaffa3.png";
				view.getGpanel().LjaffaImage = "Jaffa4.png";
				view.getGpanel().RjaffaImage = "Jaffa2.png";
			}
			view.Paint();
			}
		
		
		else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) //vissza a f�men�be
		{
			view.setPanel(view.getMpanel());
			inMPanel = false;
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_P)	//sz�net
		{
			if(game.o != null)
				game.o.pause();
			if(game.j != null)
				game.j.pause();
			if(game.r != null)
				game.r.pause();
			clock.pause();
		}	
			
	}
	}
	
	//Eg�rkattint�s lekezel�se
	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(!inMPanel)			//Ha nem vagyunk semelyik men�panelbe
		{
			if(arg0.getX()>240 && arg0.getX()<770 && arg0.getY()>320 && arg0.getY()<395)		//Game
			{
				view.control.game.init();		//Karakterek �s p�lya bet�lt�se
				view.setPanel(view.getGpanel());		//Game panel be�ll�t�sa
				clock.settime(600);
				clock.start();
				inMPanel = true;
			}	
			if(arg0.getX()>240 && arg0.getX()<770 && arg0.getY()>438 && arg0.getY()<523)		//Rules
			{
				view.setPanel(view.getRpanel());		//Rules panel be�ll�t�sa
				inMPanel = true;
			}
			if(arg0.getX()>240 && arg0.getX()<770 && arg0.getY()>578 && arg0.getY()<655)		//Credits
			{
				view.setPanel(view.getCpanel());		//Credits panel be�ll�t�sa
				inMPanel = true;
			}
			if(arg0.getX()>240 && arg0.getX()<770 && arg0.getY()>714 && arg0.getY()<788)		//Exit
			{
				System.exit(0);							//Kil�p�s :(
			}
		}
		
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
