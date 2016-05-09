import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EnumSet;
import java.lang.Object;

public class Game {
public	ONeil o = null;
public 	Jaffa j = null;
public 	Replicator r=null;
	Map map = new Map(this);
	WormHole wh=new WormHole();

	
	Game()
	{

	}
	
	public void init()
	{
		o = new ONeil(map,3);
		j= new Jaffa(map,3);
		r= new Replicator(map,1);
		try {
			map.initmap(o,j);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public Map getMap()
	{
		return map;
	}
	
	
	
	
	
	
	
}






	

