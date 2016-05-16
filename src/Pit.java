import java.awt.Image;

import javax.swing.ImageIcon;

//Osztály a szakadék kezelésére
public class Pit extends Tile {

	Game game;
	Coord startpoz=new Coord(9,12); // Oneil , vagy Jaffa kiinduló piziciója
	
	//Konstruktor
	Pit( Game g,Coord c )
	{
		super(c);
		game = g;		
	}

	@Override
	public String getType(){ return "pit";}
	
	//Kezeli az esetet amikor Oneill a szakadékba lép
	@Override
	public Coord stepOn(Coord c) 
	{
		
		Caracter.Directions rd=null;
		if (game.r != null)
			rd=game.r.direction;
		Caracter.Directions od=null;
		if (game.o != null)
			od=game.o.direction;
		Caracter.Directions jd=null;
		if (game.j != null)
			jd=game.j.direction;
		
		if(od != null)
		switch(od)  // Ha oneil iránya ... akkor megnézem hogy abba az irányban egyel a pit elõtt áll e mielõtt belelép
		{
			case Down:
				if(game.o.getLoc().equals(new Coord(location.getX(),location.getY()-1)))
				{
					game.o.DecrementLife();
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
		
		if(jd != null)
		switch(jd)  // Ha jaffa iránya ... akkor megnézem hogy abba az irányban egyel a pit elõtt áll e mielõtt belelép
		{
			case Down:
				if(game.j.getLoc().equals(new Coord(location.getX(),location.getY()-1)))
				{
					game.j.DecrementLife();
					return startpoz;
				}break;
			case Up:
				if(game.j.getLoc().equals(new Coord(location.getX(),location.getY()+1)))
				{
					game.j.DecrementLife();
					return startpoz;
				}break;
			case Left:
				if(game.j.getLoc().equals(new Coord(location.getX()+1,location.getY())))
				{
					game.j.DecrementLife();
					return startpoz;
				}break;
			case Right:
				if(game.j.getLoc().equals(new Coord(location.getX()-1,location.getY())))
				{
					game.j.DecrementLife();
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
