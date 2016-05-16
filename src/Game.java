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
	
	//Inicializ�l� f�ggv�ny
	public void init()
	{
		o = new ONeil(map,3);			//ONeil l�trehoz�sa 3 �lettel
		j= new Jaffa(map,3);			//Jaffa l�trehoz�sa 3 �lettel
		r= new Replicator(map,1);		//Jaffa l�trehoz�sa 1 �lettel
		try {
			map.initmap(o,j,r);			//Map bet�lt�se
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






	

