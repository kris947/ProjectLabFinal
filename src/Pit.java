import java.awt.Image;

import javax.swing.ImageIcon;

//Oszt�ly a szakad�k kezel�s�re
public class Pit extends Tile {

	Game game;
	Coord startpoz=new Coord(2,1);
	
	//Konstruktor
	Pit( Game g,Coord c ){
		super(c);
		game = g;
		ImageIcon ic = new ImageIcon("pit.jpg");
        image = ic.getImage();
		
	}

	//Kezeli az esetet amikor Oneill a szakad�kba l�p
	@Override
	public Coord stepOn(Coord c) {
		
		if (game.o.getLoc().equals(location))
		{
			game.o.DecrementLife();
			return startpoz;
		}
		
		
		if (game.j.getLoc().equals(location))
		{
			game.j.DecrementLife();
			return startpoz;
		}
		
		if (game.r.getLoc().equals(location))
		{
			game.r.DecrementLife();
			return startpoz;
		}
		
		else return startpoz;
	

		
		
		
		
		}
	
}
