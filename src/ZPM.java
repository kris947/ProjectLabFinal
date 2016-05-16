
import java.util.Random;

public class ZPM extends Useable {
	public Map m;
	public Coord[] randc = new Coord[8];
	//Konstruktor
	ZPM(Map map)
	{ 
		type="zpm";
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

	/*
	 * A ZPM modul beváltása során új ZPM modul helyezõdik el a pályán 
	 * az uj zpm modul helye , egy elõre meghatározott tömb elemei közül random kiválaszotott koordináta lesz.
	 */
	@Override
	public boolean redeem() 
	{ 
		ZPMCount++;
		if(ZPMCount % 2 == 0)
		{
			Random rand = new Random(); 
			int value = rand.nextInt(8); 
			Coord added = randc[value];
			m.map[added.getX()][added.getY()].setObj(new ZPM(m));
		}

		return true;
	}
}
	