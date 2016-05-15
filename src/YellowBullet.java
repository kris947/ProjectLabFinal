
//Osztály: Sárga lövedék
public class YellowBullet extends Bullet {
	public WormHole wormhole;
	

	public YellowBullet(ONeil.Directions directions, Coord coord, Map m,WormHole w) {
		super(directions,coord,m); //Ososztály konstruktoranak hivasa
		wormhole=w;	
		
	}
	
	@Override
	public String Color()
	{
		return "yellow";
	}
	
	public void open()
	{
		if(wormhole.getYellow() != null)
		{
			/* /Abban az esetben ,ha új helyre lövünk ki kék portált a megelõzõ helyen bezárja az ott lévõt,
			 * és helyére újra SpecialWall-t helyez
			 */
			map.map[wormhole.getYellow().getY()][wormhole.getYellow().getX()]=new SpecialWall(new Coord(wormhole.getYellow().getY(),wormhole.getYellow().getX()));
		}

		wormhole.setYellow(new Coord( loc.getY(),loc.getX()));      //Kivalasztjuk a sarga portalt
		wormhole.setYellowDir(dir);                                 //A féreglyukba érkezõ lövedék irányának a beállítása
		map.map[loc.getY()][loc.getX()]=new Portal(loc,'y',wormhole);//Portal letrehoza a megfelelo helyen
	}
	
}
