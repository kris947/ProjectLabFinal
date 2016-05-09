
public class Application {

	public static void main(String[] args) {
		
		Control control = new Control();
		View view = new View(control);
				
		view.setPanel(new Menu());
		view.Paint();

	}

}
