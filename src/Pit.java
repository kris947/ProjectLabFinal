import java.awt.Image;

import javax.swing.ImageIcon;

//Osztály a szakadék kezelésére
public class Pit extends Tile {

	Game game;
	Coord startpoz=new Coord(2,1); // Oneil , vagy Jaffa kiinduló piziciója
	
	//Konstruktor
	Pit( Game g,Coord c ){
		super(c);
		game = g;
        type="pit";
		
	}

	//Kezeli az esetet amikor Oneill a szakadékba lép
	@Override
	public Coord stepOn(Coord c) {
		
		Caracter.Directions od=game.o.direction;
		Caracter.Directions jd=game.j.direction;
		Caracter.Directions rd=null;
		if (game.r != null)
			rd=game.r.direction;
		
		switch(od)  // Ha oneil iránya ... akkor megnézem hogy abba az irányban egyel a pit elõtt áll e mielõtt belelép
		{
			case Down:
				if(game.o.getLoc().equals(new Coord(location.getX(),location.getY()-1)))
				{
					game.o.DecrementLife();
					System.out.println(game.o.lives);
					return startpoz;
				}break;
			case Up:
				if(game.o.getLoc().equals(new Coord(location.getX(),location.getY()+1)))
				{
					game.o.DecrementLife();
					return startpoz;
				}break;
			case Left:
				if(game.o.getLoc().equals(new Coord(location.getX()+1,location.getY())))
				{
					game.o.DecrementLife();
					return startpoz;
				}break;
			case Right:
				if(game.o.getLoc().equals(new Coord(location.getX()-1,location.getY())))
				{
					game.o.DecrementLife();
					return startpoz;
				}break;	
		}
		
		
		if(rd != null)
		switch(rd)
		{
			case Up:
				if(game.r.getLoc().equals(new Coord(location.getX(),location.getY()+1)))
				{
					game.r.loc=location;
					game.r.DecrementLife();
					return location;
				}break;
			case Down:
				if(game.r.getLoc().equals(new Coord(location.getX(),location.getY()-1)))
				{
					game.r.loc=location;
					game.r.DecrementLife();
					return location;
					
				}break;
			case Left:
				if(game.r.getLoc().equals(new Coord(location.getX()+1,location.getY())))
				{
					game.r.loc=location;
					game.r.DecrementLife();
					return location;
					
				}break;
			case Right:
				if(game.r.getLoc().equals(new Coord(location.getX()-1,location.getY())))
				{
					game.r.loc=location;
					game.r.DecrementLife();
					return location;
					
				}break;
		}
		
		if (game.j.getLoc().equals(location))
		{
			game.j.DecrementLife();
			return startpoz;
		}
		else 
			return startpoz;		
		}
	
	@Override
	public boolean setObj(Useable o)
	{
		return true;
	}
	
}
