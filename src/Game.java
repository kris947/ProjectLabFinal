import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EnumSet;
import java.lang.Object;

//Az MVC kialakitasahoz szukseges osztaly
public class Game {
public	ONeil o = null;  //ONeil referencia
public 	Jaffa j = null;  //Jaffa referencia
public 	Replicator r=null; //Replicator referencia
	Map map = new Map(this); 
	WormHole wh=new WormHole();

	//Konstruktor
	Game()
	{
		
	}
	
	//Inicializáló függvény
	public void init()
	{
		o = new ONeil(map,3);
		j= new Jaffa(map,3);
		r= new Replicator(map,1);
		try {
			map.initmap(o,j);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	//visszaadja a mapot
	public Map getMap()
	{
		return map;
	}
	
	
	
	
	
	
	
}






	

