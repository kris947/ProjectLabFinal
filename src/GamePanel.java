import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

//játék pálya megjelenítésére szolgáló JPanel
public class GamePanel extends JPanel
{
	

	
	//Pályaelemek
	private View view;                

	// Oneil 4 irány vagy dobozzal épp az értéke vagy doboz nélküli
	public String UoneilImage;
	public String DoneilImage;
	public String oneilImage;
	public String LoneilImage;
	
	// jaffa 4 irány
	public String RjaffaImage;
	public String UjaffaImage;
	public String DjaffaImage;
	public String LjaffaImage;
	
	
	
	public Image backg;
	
	
	
	// Rajzolás 0,1 secenként
	Timer drawTimer;


	public GamePanel(View v) 
	{
		setLayout(null);
		setBounds(0, 0, 1000, 1000);
		view = v;
		drawTimer =new Timer(100, new drawTimerListener());
		drawTimer.start();
		
		
		backg = new ImageIcon("background.jpg").getImage();

	}
	
	public void drawTile(int x, int y, Image images, Graphics g)
	{
		g.drawImage(images, x*50, y*50,50,50,this);
		
	}

	//Az összes pálya elem kirajzolása a Control.getDrawData függvénnyel
	@Override
    public void paint(Graphics g) 
	{
		if (view.control.game.o != null)
		{
			if (view.control.game.o.getzpmw() == 7)		//ha Oneil nyer
				view.setPanel(view.getWOpanel());	

			if(view.control.game.o.object == null)
			{
				view.getGpanel().UoneilImage = "OneilUp.png";
				view.getGpanel().DoneilImage = "ONeilD.png";
				view.getGpanel().LoneilImage = "ONeilL.png";
				view.getGpanel().oneilImage = "ONeilR.png";
			}
		}
		
		if (view.control.game.j != null)
		{
			if (view.control.game.j.getzpmw() == 7)			//ha Jaffa nyer
				view.setPanel(view.getWJpanel());
			
			if(view.control.game.j.object == null)
			{
				view.getGpanel().UjaffaImage = "Jaffa1.png";
				view.getGpanel().DjaffaImage = "Jaffa3.png";
				view.getGpanel().LjaffaImage = "Jaffa4.png";
				view.getGpanel().RjaffaImage = "Jaffa2.png";
			}
		}
		
		
		for(int i=0;i<20;i++)
		{
			for(int j=0;j<20;j++)
			{
				String[] types = view.control.getDrawData(i,j);
				if(types[0].equals("ground"))
				{
					drawTile(i , j, view.readImage("ground.jpg"), g);
				}
				else if(types[0].equals("door"))
				{
					if(view.control.dooropenat(i, j))
						drawTile(i , j, view.readImage("dooropen_new.jpg") , g);
					else
						drawTile(i , j, view.readImage("door_new.jpg"), g);
				}
				else if(types[0].equals("pit"))
				{
					drawTile(i , j, view.readImage("pit.jpg") , g);
				}
				else if(types[0].equals("scale"))
				{
					drawTile(i , j, view.readImage("scale.jpg"), g);
				}
				else if(types[0].equals("spaceship"))
				{
					drawTile(i , j, view.readImage("spaceship_new.jpg"), g);
				}
				else if(types[0].equals("specialwall"))
				{
					drawTile(i , j, view.readImage("specialwall_new.jpg"), g);
				}
				else if(types[0].equals("wall"))
				{
					drawTile(i , j, view.readImage("wall_new.jpg"), g);
				}
				else if(types[0].equals("portal"))
				{
					
					if(view.control.game.wh.getBlue() != null && new Coord(i,j).equals(view.control.game.wh.getBlue()))
					{
						if((view.control.game.wh.getBlueDir()==Caracter.Directions.Up)||(view.control.game.wh.getBlueDir()==Caracter.Directions.Down))
							drawTile(i , j, view.readImage("blueportal1_new.jpg"), g);
						else
							drawTile(i , j, view.readImage("blueportal2_new.jpg"), g);
					}
					else if(view.control.game.wh.getYellow() != null && new Coord(i,j).equals(view.control.game.wh.getYellow()))
					{
						if((view.control.game.wh.getYellowDir()==Caracter.Directions.Up)||(view.control.game.wh.getYellowDir()==Caracter.Directions.Down))
							drawTile(i , j, view.readImage("yellowportal1_new.jpg"), g);
						else
							drawTile(i , j, view.readImage("yellowportal2_new.jpg"), g);
					}
					else if(view.control.game.wh.getGreen() != null && new Coord(i,j).equals(view.control.game.wh.getGreen()))
					{
						if((view.control.game.wh.getGreenDir()==Caracter.Directions.Up)||(view.control.game.wh.getGreenDir()==Caracter.Directions.Down))
							drawTile(i , j, view.readImage("greenportal1_new.jpg"), g);
						else
							drawTile(i , j, view.readImage("greenportal2_new.jpg"), g);
					}
					else if(view.control.game.wh.getRed() != null && new Coord(i,j).equals(view.control.game.wh.getRed()))
					{
						if((view.control.game.wh.getRedDir()==Caracter.Directions.Up)||(view.control.game.wh.getRedDir()==Caracter.Directions.Down))
							drawTile(i , j, view.readImage("redportal1_new.jpg"), g);
						else
							drawTile(i , j, view.readImage("redportal2_new.jpg"), g);
					}
					
				}
				
				if(types[1]!=null)
				{
					if(types[1].equals("box"))
					{
						drawTile(i,j,view.readImage("box_new.png"),g);
					}
					else if(types[1].equals("zpm"))
					{
						drawTile(i , j, view.readImage("zpm.png"), g);
					}
					
				}
						
			}
		}
		CharGraphics OGrafInfo = view.control.ODraw();
		CharGraphics JGrafInfo = view.control.JDraw();
		CharGraphics RGrafInfo = view.control.RDraw();
		
		if(OGrafInfo != null)
		{
			switch(OGrafInfo.getDir())
			{
				case Up:
					drawTile(OGrafInfo.getX(),OGrafInfo.getY(),view.readImage(UoneilImage),g); 
				break;
				case Down:
					drawTile(OGrafInfo.getX(),OGrafInfo.getY(),view.readImage(DoneilImage),g); 
				break;
				case Left:
					drawTile(OGrafInfo.getX(),OGrafInfo.getY(),view.readImage(LoneilImage),g); 
				break;
				case Right:
					drawTile(OGrafInfo.getX(),OGrafInfo.getY(),view.readImage(oneilImage),g); 
				break;			
			}
			
		}
		
		if(JGrafInfo != null)
		{
			switch(JGrafInfo.getDir())
			{
				case Up:
					drawTile(JGrafInfo.getX(),JGrafInfo.getY(),view.readImage(UjaffaImage),g); 
				break;
				case Down:
					drawTile(JGrafInfo.getX(),JGrafInfo.getY(),view.readImage(DjaffaImage),g); 
				break;
				case Left:
					drawTile(JGrafInfo.getX(),JGrafInfo.getY(),view.readImage(LjaffaImage),g); 
				break;   
				case Right:
					drawTile(JGrafInfo.getX(),JGrafInfo.getY(),view.readImage(RjaffaImage),g); 
				break;
			}
			
		}
		
		if(RGrafInfo != null)
			drawTile(RGrafInfo.getX(),RGrafInfo.getY(),view.readImage("replicator.png"),g);
		
		for(int i=0;i<view.control.game.map.shots.size();i++)
		{
			Bullet current = view.control.game.map.shots.get(i);
			if (current.Color().equals("blue"))
				drawTile(current.loc.getX(),current.loc.getY(),view.readImage("bluebullet.png"),g);
			if (current.Color().equals("yellow"))
				drawTile(current.loc.getX(),current.loc.getY(),view.readImage("yellowbullet.png"),g);
			if (current.Color().equals("red"))
				drawTile(current.loc.getX(),current.loc.getY(),view.readImage("redbullet.png"),g);
			if (current.Color().equals("green"))
				drawTile(current.loc.getX(),current.loc.getY(),view.readImage("greenbullet.png"),g);
		}
				

		
		g.drawImage(backg, 395, 5, 160, 35, this);
		String s9;
		s9 = "Time:   " + view.control.clock.gettime();

		if(view.control.clock.getpause())s9= s9+"   PAUSED";
		
		g.drawString(s9 , 400, 27);		
		g.drawRect(395, 5, 159, 34);
		g.drawRect(394, 4, 160, 35);
		g.drawRect(394, 4, 161, 36);
		g.drawRect(396, 6, 158, 33);
		g.drawRect(396, 6, 157, 32);
		
		
		
		g.drawImage(backg, 795, 5, 160, 35, this);
		String s;
		String s2;
		if (view.control.game.o != null)
		{
			s = "Oneill életeinek száma:   " + view.control.game.o.getLife();
			s2 = "Begyûjtött ZPM:   " + view.control.game.o.getzpmw();
		}
		else 
		{
			s = "Oneill életeinek száma:   0";
			s2 = "Begyûjtött ZPM:   -";
		}
		
		g.drawString(s , 800, 20);		
		g.drawString(s2 , 800, 35);
		g.drawRect(795, 5, 159, 34);
		g.drawRect(794, 4, 160, 35);
		g.drawRect(794, 4, 161, 36);
		g.drawRect(796, 6, 158, 33);
		g.drawRect(796, 6, 157, 32);
		
		
		
		g.drawImage(backg, 595, 5, 160, 35, this);
		String s3;
		String s4;		
		if (view.control.game.j != null)
		{
			s3 = "Jaffa életeinek száma:   " + view.control.game.j.getLife();
			s4 = "Begyûjtött ZPM:   " + view.control.game.j.getzpmw();
		}
		else 
		{
			s3 = "Jaffa életeinek száma:   0";
			s4 = "Begyûjtött ZPM:   -";
		}
		
		g.drawString(s3 , 600, 20);
		g.drawString(s4 , 600, 35);
		g.drawRect(595, 5, 159, 34);
		g.drawRect(594, 4, 160, 35);
		g.drawRect(594, 4, 161, 36);
		g.drawRect(596, 6, 158, 33);
		g.drawRect(596, 6, 157, 32);
		
		if (view.control.game.j == null && view.control.game.o == null)	//ha mindkét játékos meghal
			view.setPanel(view.getMpanel());		//vissza  a fõmeübe
		
		
		if (view.control.clock.gettimeint()== 0)	//ha mindkét játékos meghal
			view.setPanel(view.getMpanel());

	}
	
	class drawTimerListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			repaint();
		}
		
	}
	
}
