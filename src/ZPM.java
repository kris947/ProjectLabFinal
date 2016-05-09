import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

//Eklell döntenünk , hogy a ZPMcount  modul hol tároljuk el;
public class ZPM extends Useable {

public Image image;
 Map m;
public Coord[] randc = new Coord[8];

ZPM(Map map)
{
	m=map;
	randc[0]=new Coord(0,0);
	randc[1]=new Coord(0,2);
	randc[2]=new Coord(1,1);
	randc[3]=new Coord(1,2);
	randc[4]=new Coord(2,0);
	randc[5]=new Coord(2,1);
	randc[6]=new Coord(3,0);
	randc[7]=new Coord(4,1);
	ImageIcon ic = new ImageIcon("zmp.png");
    Image image = ic.getImage();
}




	@Override
	public void redeem() {
		//A ZPM modul beváltása 
		ZPMCount++;
		//System.out.println("A ZPM modul sikeresen elhelyezõdött");
		
		//todo: Random zpm lerakása
		
		Random rand = new Random(); 
		int value = rand.nextInt(8); 
		Coord added = randc[value];
		m.map[added.getX()][added.getY()].setObj(new ZPM(m));
		
	}
   
}
