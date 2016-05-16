//A main-t tartalmazo osztaly
public class Application {

	public static void main(String[] args) 
	{
		Game game = new Game();						//Game l�trehoz�sa
		Control control = new Control(game);		//Control l�trehoz�sa
		View view = new View(control);				//View l�trehoz�sa

		control.addView(view);						//Az adott n�zet hozz�ad�sa
				
		view.setPanel(view.getMpanel());			//Men�panel be�ll�t�sa
		view.Paint();								//Kirajzol�s
	}
}
