//A main-t tartalmazo osztaly
public class Application {

	public static void main(String[] args) 
	{
		Game game = new Game();						//Game létrehozása
		Control control = new Control(game);		//Control létrehozása
		View view = new View(control);				//View létrehozása
		control.game.init();						//Karakterek és pálya betöltése
		control.addView(view);						//Az adott nézet hozzáadása
				
		view.setPanel(view.getMpanel());			//Menüpanel beállítása
		view.Paint();								//Kirajzolás
		(new ReplicatorThread(game.r)).start();		//Replikátor elindítása
		

	}

}
