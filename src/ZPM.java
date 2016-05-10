import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

//Eklell d�nten�nk , hogy a ZPMcount  modul hol t�roljuk el;
public class ZPM extends Useable {

public Image image;
 Map m;
public Coord[] randc = new Coord[8];

ZPM(Map map)
{ 
	ImageIcon ic = new ImageIcon("zmp.png");
	image = ic.getImage();
	m=map;
	this.weight=50;
	randc[0]=new Coord(11,7);
	randc[1]=new Coord(11,10);
	randc[2]=new Coord(1,17);
	randc[3]=new Coord(17,1);
	randc[4]=new Coord(15,11);
	randc[5]=new Coord(2,8);
	randc[6]=new Coord(6,8);
	randc[7]=new Coord(18,14);
	
}




	@Override
	public void redeem() {
		//A ZPM modul bev�lt�sa 
		ZPMCount++;
		//System.out.println("A ZPM modul sikeresen elhelyez�d�tt");
		
		//todo: Random zpm lerak�sa
		
		Random rand = new Random(); 
		int value = rand.nextInt(8); 
		Coord added = randc[value];
		m.map[added.getX()][added.getY()].setObj(new ZPM(m));
	}
	@Override
	 public Image getImage() { return image; }
   
}
