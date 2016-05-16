import java.io.IOException;


//Az MVC kialakitasahoz szukseges osztaly
public class Game 
{
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
		o = new ONeil(map,3);			//ONeil létrehozása 3 élettel
		j= new Jaffa(map,3);			//Jaffa létrehozása 3 élettel
		r= new Replicator(map,1);		//Jaffa létrehozása 1 élettel
		try {
			map.initmap(o,j,r);			//Map betöltése
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






	

