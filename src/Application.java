
public class Application {

	public static void main(String[] args) 
	{
		Game game = new Game();
		Control control = new Control(game);
		View view = new View(control);
				
		view.setPanel(new Menu());
		view.Paint();

	}

}
