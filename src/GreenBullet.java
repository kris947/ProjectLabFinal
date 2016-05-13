import java.awt.Image;

//A z�ld l�ved�ket reprezent�l� oszt�ly
public class GreenBullet extends Bullet{
	public WormHole wormhole;
	
	//Konstruktor
	public GreenBullet(Jaffa.Directions directions, Coord coord, Map m,WormHole w)
	{
		super(directions,coord,m);
		wormhole=w;
		type = "green";
	}
	
	//Port�l nyit�s
		public void open() 
		{
			System.out.println("GreenBullett: open met�dus h�v�s");
			if(wormhole.getGreen() != null){
			
				map.map[wormhole.getGreen().getY()][wormhole.getGreen().getX()]=new SpecialWall(new Coord(wormhole.getGreen().getY(),wormhole.getGreen().getX()));
			}

			wormhole.setGreen(new Coord(loc.getY(),loc.getX()));	//Kivalasztjuk a kek portalt
			wormhole.setGreenDir(dir);
			map.map[loc.getY()][loc.getX()]=new Portal(loc,'g',wormhole); //Portal letrehoza a megfelelo helyen
			//System.out.println("GreenBullet: Z�ld port�l ny�lt");*/
		}
	}