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
	private Image groundImage;
	private Image boxImage;
	private Image doorImage;
	private Image doorOImage;
	private Image pitImage;
	private Image scaleImage;
	private Image ssImage;
	private Image swImage;
	private Image wallImage;
	private Image zpmImage;
	//portálok -> 4 szín 2 irány
	private Image VYportalImage;
	private Image HYportalImage;
	private Image VBportalImage;
	private Image HBportalImage;
	private Image VRportalImage;
	private Image HRportalImage;
	private Image VGportalImage;
	private Image HGportalImage;
	// Oneil 4 irány vagy dobozzal épp az értéke vagy doboz nélküli
	public Image UoneilImage;
	public Image DoneilImage;
	public Image oneilImage;
	public Image LoneilImage;
	//Oneil dobozzal
	public Image UboxOneil;
	public Image DboxOneil;
	public Image LboxOneil;
	public Image RboxOneil;
	//Oneil zpmel
	public Image UzpmOneil;
	public Image DzpmOneil;
	public Image LzpmOneil;
	public Image RzpmOneil;
	//Oneil doboz nelkul
	public Image UnoboxOneil;
	public Image DnoboxOneil;
	public Image LnoboxOneil;
	public Image RnoboxOneil;
	//replicator
	private Image replicatorImage;
	// jaffa 4 irány
	public Image RjaffaImage;
	public Image UjaffaImage;
	public Image DjaffaImage;
	public Image LjaffaImage;
	//jaffa  dobozzal
	public Image UboxJaffa;
	public Image RboxJaffa;
	public Image DboxJaffa;
	public Image LboxJaffa;
	//Jaffa zpmel
	public Image UzpmJaffa;
	public Image DzpmJaffa;
	public Image LzpmJaffa;
	public Image RzpmJaffa;
	//jaffa   no dobozzal
	public Image UnoboxJaffa;
	public Image RnoboxJaffa;
	public Image DnoboxJaffa;
	public Image LnoboxJaffa;
	// 4 Bullet
	public Image BlueBullet;
	public Image YellowBullet;
	public Image GreenBullet;
	public Image RedBullet;
	
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
		
		
		//Pályaelemek
		groundImage = new ImageIcon("ground.jpg").getImage();
		boxImage = new ImageIcon("box_new.png").getImage();
		doorImage = new ImageIcon("door_new.jpg").getImage();
		doorOImage = new ImageIcon("dooropen_new.jpg").getImage();
		pitImage = new ImageIcon("pit.jpg").getImage();
		scaleImage = new ImageIcon("scale.jpg").getImage();
		ssImage = new ImageIcon("spaceship_new.jpg").getImage();
		swImage = new ImageIcon("specialwall_new.jpg").getImage();
		wallImage = new ImageIcon("wall_new.jpg").getImage();
		zpmImage = new ImageIcon("zpm.png").getImage();
		//replicator
		replicatorImage = new ImageIcon("replicator.png").getImage();
		//Portálok
		VYportalImage = new ImageIcon("yellowportal1_new.jpg").getImage();
		HYportalImage = new ImageIcon("yellowportal2_new.jpg").getImage();
		VBportalImage = new ImageIcon("blueportal1_new.jpg").getImage();
		HBportalImage = new ImageIcon("blueportal2_new.jpg").getImage();
		VRportalImage = new ImageIcon("redportal1_new.jpg").getImage();
		HRportalImage = new ImageIcon("redportal2_new2.jpg").getImage();	
		VGportalImage = new ImageIcon("greenportal1_new.jpg").getImage();
		HGportalImage = new ImageIcon("greenportal2_new.jpg").getImage();	
		//Oneil
		oneilImage = new ImageIcon("ONeilR.png").getImage();
		LoneilImage = new ImageIcon("ONeilL.png").getImage();
		UoneilImage = new ImageIcon("ONeilUp.png").getImage();
		DoneilImage = new ImageIcon("ONeilD.png").getImage();
		//Oneil doboz nélkül
		UnoboxOneil = new ImageIcon("OneilUp.png").getImage();
		RnoboxOneil = new ImageIcon("ONeilR.png").getImage();
		DnoboxOneil = new ImageIcon("ONeilD.png").getImage();
		LnoboxOneil = new ImageIcon("ONeilL.png").getImage();
		//Oneil dobozzal
		UboxOneil = new ImageIcon("UboxO.png").getImage();
		RboxOneil = new ImageIcon("RboxO.png").getImage();
		DboxOneil = new ImageIcon("DboxO.png").getImage();
		LboxOneil = new ImageIcon("LboxO.png").getImage();
		//Oneil zpmel
		UzpmOneil = new ImageIcon("UzpmO.png").getImage();
		RzpmOneil = new ImageIcon("RzpmO.png").getImage();
		DzpmOneil = new ImageIcon("DzpmO.png").getImage();
		LzpmOneil = new ImageIcon("LzpmO.png").getImage();
		//Jaffa
		UjaffaImage = new ImageIcon("Jaffa1.png").getImage();
		RjaffaImage = new ImageIcon("Jaffa2.png").getImage();
		DjaffaImage = new ImageIcon("Jaffa3.png").getImage();
		LjaffaImage = new ImageIcon("Jaffa4.png").getImage();
		//Jaffa dobozzal
		UboxJaffa = new ImageIcon("UboxJ.png").getImage();
		RboxJaffa = new ImageIcon("RboxJ.png").getImage();
		DboxJaffa = new ImageIcon("DboxJ.png").getImage();
		LboxJaffa = new ImageIcon("LboxJ.png").getImage();
		//Jaffa dobozzal
		UzpmJaffa = new ImageIcon("UzpmJ.png").getImage();
		RzpmJaffa = new ImageIcon("RzpmJ.png").getImage();
		DzpmJaffa = new ImageIcon("DzpmJ.png").getImage();
		LzpmJaffa = new ImageIcon("LzpmJ.png").getImage();
		//Jaffa  no dobozzal
		UnoboxJaffa = new ImageIcon("Jaffa1.png").getImage();
		RnoboxJaffa = new ImageIcon("Jaffa2.png").getImage();
		DnoboxJaffa = new ImageIcon("Jaffa3.png").getImage();
		LnoboxJaffa = new ImageIcon("Jaffa4.png").getImage();
		//Bullets
		BlueBullet = new ImageIcon("bluebullet.png").getImage();
		YellowBullet = new ImageIcon("yellowbullet.png").getImage();
		GreenBullet = new ImageIcon("greenbullet.png").getImage();
		RedBullet = new ImageIcon("redbullet.png").getImage();
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
				view.setPanel(view.getMpanel());	

			if(view.control.game.o.object == null)
			{
				view.getGpanel().UoneilImage = view.getGpanel().UnoboxOneil;
				view.getGpanel().DoneilImage = view.getGpanel().DnoboxOneil;
				view.getGpanel().LoneilImage = view.getGpanel().LnoboxOneil;
				view.getGpanel().oneilImage = view.getGpanel().RnoboxOneil;
			}
		}
		
		if (view.control.game.j != null)
		{
			if (view.control.game.j.getzpmw() == 7)			//ha Jaffa nyer
				view.setPanel(view.getMpanel());
			
			if(view.control.game.j.object == null)
			{
				view.getGpanel().UjaffaImage = view.getGpanel().UnoboxJaffa;
				view.getGpanel().DjaffaImage = view.getGpanel().DnoboxJaffa;
				view.getGpanel().LjaffaImage = view.getGpanel().LnoboxJaffa;
				view.getGpanel().RjaffaImage = view.getGpanel().RnoboxJaffa;
			}
		}
		
		
		for(int i=0;i<20;i++)
		{
			for(int j=0;j<20;j++)
			{
				String[] types = view.control.getDrawData(i,j);
				if(types[0].equals("ground"))
				{
					drawTile(i , j, groundImage, g);
				}
				else if(types[0].equals("door"))
				{
					if(view.control.dooropenat(i, j))
						drawTile(i , j, doorOImage, g);
					else
						drawTile(i , j, doorImage, g);
				}
				else if(types[0].equals("pit"))
				{
					drawTile(i , j, pitImage, g);
				}
				else if(types[0].equals("scale"))
				{
					drawTile(i , j, scaleImage, g);
				}
				else if(types[0].equals("spaceship"))
				{
					drawTile(i , j, ssImage, g);
				}
				else if(types[0].equals("specialwall"))
				{
					drawTile(i , j, swImage, g);
				}
				else if(types[0].equals("wall"))
				{
					drawTile(i , j, wallImage, g);
				}
				else if(types[0].equals("portal"))
				{
					
					if(view.control.game.wh.getBlue() != null && new Coord(i,j).equals(view.control.game.wh.getBlue()))
					{
						if((view.control.game.wh.getBlueDir()==Caracter.Directions.Up)||(view.control.game.wh.getBlueDir()==Caracter.Directions.Down))
							drawTile(i , j, VBportalImage, g);
						else
							drawTile(i , j, HBportalImage, g);
					}
					else if(view.control.game.wh.getYellow() != null && new Coord(i,j).equals(view.control.game.wh.getYellow()))
					{
						if((view.control.game.wh.getYellowDir()==Caracter.Directions.Up)||(view.control.game.wh.getYellowDir()==Caracter.Directions.Down))
							drawTile(i , j, VYportalImage, g);
						else
							drawTile(i , j, HYportalImage, g);
					}
					else if(view.control.game.wh.getGreen() != null && new Coord(i,j).equals(view.control.game.wh.getGreen()))
					{
						if((view.control.game.wh.getGreenDir()==Caracter.Directions.Up)||(view.control.game.wh.getGreenDir()==Caracter.Directions.Down))
							drawTile(i , j, VGportalImage, g);
						else
							drawTile(i , j, HGportalImage, g);
					}
					else if(view.control.game.wh.getRed() != null && new Coord(i,j).equals(view.control.game.wh.getRed()))
					{
						if((view.control.game.wh.getRedDir()==Caracter.Directions.Up)||(view.control.game.wh.getRedDir()==Caracter.Directions.Down))
							drawTile(i , j, VRportalImage, g);
						else
							drawTile(i , j, HRportalImage, g);
					}
					
				}
				
				if(types[1]!=null)
				{
					if(types[1].equals("box"))
					{
						drawTile(i,j,boxImage,g);
					}
					else if(types[1].equals("zpm"))
					{
						drawTile(i , j, zpmImage, g);
					}
					
				}
						
			}
		}
		CharGraphics OGrafInfo = view.control.ODraw();
		CharGraphics JGrafInfo = view.control.JDraw();
		CharGraphics RGrafInfo = view.control.RDraw();
		
		if(OGrafInfo != null)
			switch(OGrafInfo.getDir())
			{
				case Up:
					drawTile(OGrafInfo.getX(),OGrafInfo.getY(),UoneilImage,g); 
				break;
				case Down:
					drawTile(OGrafInfo.getX(),OGrafInfo.getY(),DoneilImage,g); 
				break;
				case Left:
					drawTile(OGrafInfo.getX(),OGrafInfo.getY(),LoneilImage,g); 
				break;
				case Right:
					drawTile(OGrafInfo.getX(),OGrafInfo.getY(),oneilImage,g); 
				break;
				
			}
		
		if(JGrafInfo != null)
			switch(JGrafInfo.getDir())
			{
				case Up:
					drawTile(JGrafInfo.getX(),JGrafInfo.getY(),UjaffaImage,g); 
				break;
				case Down:
					drawTile(JGrafInfo.getX(),JGrafInfo.getY(),DjaffaImage,g); 
				break;
				case Left:
					drawTile(JGrafInfo.getX(),JGrafInfo.getY(),LjaffaImage,g); 
				break;   
				case Right:
					drawTile(JGrafInfo.getX(),JGrafInfo.getY(),RjaffaImage,g); 
				break;
				
			}
		
		if(RGrafInfo != null)
			drawTile(RGrafInfo.getX(),RGrafInfo.getY(),replicatorImage,g);
		
		for(int i=0;i<view.control.game.map.shots.size();i++)
		{
			Bullet current = view.control.game.map.shots.get(i);
			if (current.Color().equals("blue"))
				drawTile(current.loc.getX(),current.loc.getY(),BlueBullet,g);
			if (current.Color().equals("yellow"))
				drawTile(current.loc.getX(),current.loc.getY(),YellowBullet,g);
			if (current.Color().equals("red"))
				drawTile(current.loc.getX(),current.loc.getY(),RedBullet,g);
			if (current.Color().equals("green"))
				drawTile(current.loc.getX(),current.loc.getY(),GreenBullet,g);
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
