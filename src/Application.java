
public class Application {

	public static void main(String[] args) 
	{
		Game game = new Game();
		Control control = new Control(game);
		View view = new View(control);
		control.game.init();
		control.addView(view);
				
		view.setPanel(new GamePanel(view));
		view.Paint();
		

	}

}
