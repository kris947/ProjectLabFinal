
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
	private boolean inMPanel;		//Benne vagyunk-e vmilyen menüpanelban
	
	Clock clock = new Clock();
	
	//Konstruktor
	public Control(Game game)
	{
		this.game = game;
		inMPanel = false;
		
	}
	
	//Megefelelõ nézet társítása
	public void addView(View view){
		this.view=view;
	}
	
	//Típusok meghatározása
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
	
	//Nyitva van-e az ajtó
	public boolean dooropenat(int x, int y)
	{
		 return game.getMap().map[y][x].isOpen;
		
	}
	
	//ONeil adatai a kirajzoláshoz
	public CharGraphics ODraw()
	{
		if(game.o ==null)
			return null;
		Coord c = game.o.getLoc();
		Caracter.Directions d = game.o.getDir();
		return new CharGraphics(c,d);
	}
	
	//Jaffa adatai a kirajzoláshoz
	public CharGraphics JDraw()
	{
		if(game.j ==null)
			return null;
		Coord c = game.j.getLoc();
		Caracter.Directions d = game.j.getDir();
		return new CharGraphics(c,d);
	}
	
	//Replikátor adatai a kirajzoláshoz
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

	//A lenyomott billenytûk lekezelése
	@Override
	public void keyPressed(KeyEvent e)
	{
		if(game.o != null)
		{
			if(e.getKeyCode() == KeyEvent.VK_W)				//ONeil felfelé néz
			{
				game.o.move(game.o.direction.Up);			//ONeil move metódusa a felfele irányra
				view.Paint();								//Újrarajzolás
			}
			else if(e.getKeyCode() == KeyEvent.VK_A)		//ONeil balra néz
			{
				game.o.move(game.o.direction.Left);			//ONeil move metódusa a bal irányra
				view.Paint();								//Újrarajzolás
	
			}
			else if(e.getKeyCode() == KeyEvent.VK_S)		//ONeil lefelé néz
			{
				game.o.move(game.o.direction.Down);			//ONeil move metódusa a lefelé irányra
				view.Paint();								//Újrarajzolás
	
			}
			else if(e.getKeyCode() == KeyEvent.VK_D)		//ONeil jobbra néz
			{
				game.o.move(game.o.direction.Right);		//ONeil move metódusa a jobb irányra
				view.Paint();								//Újrarajzolás
			}
			else if(e.getKeyCode() == KeyEvent.VK_E)		//ONeil objektumhasználta
			{
				if(game.o.object==null)						//ha nincs
				{
					game.o.pickUp();						//felvesz
					if(game.o.object != null && game.o.object.getType().equals("box"))		//doboz, és melyik irányba néz
					{
						view.getGpanel().UoneilImage = "UboxO.png";
						view.getGpanel().DoneilImage = "DboxO.png";
						view.getGpanel().LoneilImage = "LboxO.png";
						view.getGpanel().oneilImage = "RboxO.png";
					}
					if(game.o.object != null && game.o.object.getType().equals("zpm"))		//zpm, és melyik irányba néz
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
			else if(e.getKeyCode() == KeyEvent.VK_B)		//ONeil kék lövés
			{
				game.o.shoot('b', game.wh);
			}
			else if(e.getKeyCode() == KeyEvent.VK_Y)		//ONeil sárga lövés
			{
				game.o.shoot('y', game.wh);
			}
		}
		
		if(game.j != null)
		{
			if(e.getKeyCode() == KeyEvent.VK_UP)			//Jaffa felfelé néz
			{
				game.j.move(game.j.direction.Up);
				view.Paint();
			}	
			else if(e.getKeyCode() == KeyEvent.VK_DOWN)		//Jaffa lefelé néz
			{
				game.j.move(game.j.direction.Down);
				view.Paint();
			}	
			else if(e.getKeyCode() == KeyEvent.VK_LEFT)		//Jaffa balra néz
			{
				game.j.move(game.j.direction.Left);
				view.Paint();
			}	
			else if(e.getKeyCode() == KeyEvent.VK_RIGHT)	//Jaffa jobbra néz
			{
				game.j.move(game.j.direction.Right);
				view.Paint();
			}
			else if(e.getKeyCode() == KeyEvent.VK_R)		//Jaffa piros lövés
			{
				game.j.shoot('r', game.wh);
			}
			else if(e.getKeyCode() == KeyEvent.VK_G)		//Jaffa piros lövés
			{
				game.j.shoot('g', game.wh);				
			}

			else if(e.getKeyCode() == KeyEvent.VK_K){		//Jaffa objektumhasználata
				if(game.j.object==null)
			{
				game.j.pickUp();
				if(game.j.object != null && game.j.object.getType().equals("box"))	//ha doboz van nála
				{
					view.getGpanel().UjaffaImage = "UboxJ.png";
					view.getGpanel().DjaffaImage = "DboxJ.png";
					view.getGpanel().LjaffaImage = "LboxJ.png";
					view.getGpanel().RjaffaImage = "RboxJ.png";
				}
				if(game.j.object != null && game.j.object.getType().equals("zpm")) //ha zpm van nála
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
		
		
		else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) //vissza a fõmenübe
		{
			view.setPanel(view.getMpanel());
			inMPanel = false;
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_P)	//szünet
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
	
	//Egérkattintás lekezelése
	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(!inMPanel)			//Ha nem vagyunk semelyik menüpanelbe
		{
			if(arg0.getX()>240 && arg0.getX()<770 && arg0.getY()>320 && arg0.getY()<395)		//Game
			{
				view.control.game.init();		//Karakterek és pálya betöltése
				view.setPanel(view.getGpanel());		//Game panel beállítása
				clock.settime(600);
				clock.start();
				inMPanel = true;
			}	
			if(arg0.getX()>240 && arg0.getX()<770 && arg0.getY()>438 && arg0.getY()<523)		//Rules
			{
				view.setPanel(view.getRpanel());		//Rules panel beállítása
				inMPanel = true;
			}
			if(arg0.getX()>240 && arg0.getX()<770 && arg0.getY()>578 && arg0.getY()<655)		//Credits
			{
				view.setPanel(view.getCpanel());		//Credits panel beállítása
				inMPanel = true;
			}
			if(arg0.getX()>240 && arg0.getX()<770 && arg0.getY()>714 && arg0.getY()<788)		//Exit
			{
				System.exit(0);							//Kilépés :(
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
