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
	// Oneil 4 irány
	private Image UoneilImage;
	private Image DoneilImage;
	private Image oneilImage;
	private Image LoneilImage;
	//replicator
	private Image replicatorImage;
	// jaffa 4 irány
	private Image jaffaImage;
	private Image UjaffaImage;
	private Image DjaffaImage;
	private Image LjaffaImage;
	
	// Rajzolás 0,1 secenként
	Timer drawTimer;
	

	public GamePanel(View v) 
	{
		setLayout(null);
		setBounds(0, 0, 1000, 1000);
		view = v;
		drawTimer =new javax.swing.Timer(100, new drawTimerListener());
		drawTimer.start();
		
		//Pályaelemek
		groundImage = new ImageIcon("ground.jpg").getImage();
		boxImage = new ImageIcon("box.png").getImage();
		doorImage = new ImageIcon("door1.jpg").getImage();
		pitImage = new ImageIcon("pit.jpg").getImage();
		scaleImage = new ImageIcon("scale.jpg").getImage();
		ssImage = new ImageIcon("spaceship.jpg").getImage();
		swImage = new ImageIcon("specialwall1.jpg").getImage();
		wallImage = new ImageIcon("wall1.jpg").getImage();
		zpmImage = new ImageIcon("zpm.png").getImage();
		//replicator
		replicatorImage = new ImageIcon("replicator.png").getImage();
		//Portálok
		VYportalImage = new ImageIcon("yellowportal1.jpg").getImage();
		HYportalImage = new ImageIcon("yellowportal2.jpg").getImage();
		VBportalImage = new ImageIcon("blueportal1.jpg").getImage();
		HBportalImage = new ImageIcon("blueportal2.jpg").getImage();
		HRportalImage = new ImageIcon("redportal1.jpg").getImage();
		VRportalImage = new ImageIcon("redportal2.jpg").getImage();
		HGportalImage = new ImageIcon("greenportal1.jpg").getImage();
		VGportalImage = new ImageIcon("greenportal2.jpg").getImage();
		//Oneil
		oneilImage = new ImageIcon("ONeil.png").getImage();
		LoneilImage = new ImageIcon("ONeil.png").getImage();
		UoneilImage = new ImageIcon("ONeil.png").getImage();
		DoneilImage = new ImageIcon("ONeil.png").getImage();
		//Jaffa
		UjaffaImage = new ImageIcon("Jaffa.png").getImage();
		DjaffaImage = new ImageIcon("Jaffa.png").getImage();
		LjaffaImage = new ImageIcon("Jaffa.png").getImage();
		jaffaImage = new ImageIcon("Jaffa.png").getImage();
		
	}
	
	public void drawTile(int x, int y, Image images, Graphics g)
	{
		g.drawImage(images, x*50, y*50,50,50,this);
		
	}

	//Az összes pálya elem kirajzolása a Control.getDrawData függvénnyel
	@Override
    public void paint(Graphics g) 
	{
        //super.paint(g);
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
					else if(new Coord(i,j).equals(view.control.game.wh.getYellow()))
					{
						if((view.control.game.wh.getYellowDir()==Caracter.Directions.Up)||(view.control.game.wh.getYellowDir()==Caracter.Directions.Down))
							drawTile(i , j, VYportalImage, g);
						else
							drawTile(i , j, HYportalImage, g);
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
		
		switch(OGrafInfo.getDir())
		{
			case Up:
				drawTile(OGrafInfo.getX(),OGrafInfo.getY(),oneilImage,g); 
			break;
			case Down:
				drawTile(OGrafInfo.getX(),OGrafInfo.getY(),jaffaImage,g); 
			break;
			case Left:
				drawTile(OGrafInfo.getX(),OGrafInfo.getY(),replicatorImage,g); 
			break;
			case Right:
				drawTile(OGrafInfo.getX(),OGrafInfo.getY(),oneilImage,g); 
			break;
			
		}
		
		switch(JGrafInfo.getDir())
		{
			case Up:
				drawTile(JGrafInfo.getX(),JGrafInfo.getY(),oneilImage,g); 
			break;
			case Down:
				drawTile(JGrafInfo.getX(),JGrafInfo.getY(),jaffaImage,g); 
			break;
			case Left:
				drawTile(JGrafInfo.getX(),JGrafInfo.getY(),replicatorImage,g); 
			break;
			case Right:
				drawTile(JGrafInfo.getX(),JGrafInfo.getY(),oneilImage,g); 
			break;
			
		}
		
		drawTile(RGrafInfo.getX(),RGrafInfo.getY(),replicatorImage,g);
		
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
