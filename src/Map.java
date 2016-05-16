import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;

//A pálya osztálya
public class Map {
	public ONeil oneil;
	public Replicator replicator;
	private int sizeX;
	private int sizeY;
	private int ZPMcount;
	Game game;
	public Tile[][] map = new Tile[20][20]; // Sorokszáma/Oszlopok száma
	public ArrayList<Bullet> shots = new ArrayList();
	
	
	
	public int getSizeX() {
		return sizeX;		
	}
	public int getSizeY() {
		return sizeY;
	}
	public Map(Game g) {
		game = g;
		
	}
/*
 * A pálya betöltõ metódus, mely egy *.csv fájlból olvas be karaktereket illetve bizonyos karaktereknél számjegyeket is.
 * Minden karakterhez egy megfelelõ pályaelem tartozik.
 * A Scale beolvasásánál határozzuk meg , és hozzuk létre a hozzá tartozó Door-t , mivel a Scale-nek már tudnia kill ,hogy melyik ajtóhoz 
 * van kötve.
 */
	public void initmap(ONeil o,Jaffa j,Replicator r) throws IOException{
		oneil=o;
		replicator = r;
		int Y=0;
		
		BufferedReader br = new BufferedReader(new FileReader("FinalMap.csv")); // Amikor ezt lecseréljük írjuk át a map nagyságát is 
			try {
				String line; ;
				while ((line= br.readLine())!= null) {
					String[]c=line.split(";");
					sizeX= c.length+1;
					sizeY = Y+1 ;
					for(int i=0;i<c.length;i++){
						if (c[i].equals("W")){
							map[Y][i]=new Wall(new Coord(i,Y));
						}
						else if (c[i].equals("w")){
							map[Y][i]=new Wall(new Coord(i,Y));
						}			
						else if (c[i].equals("(-")){  //Ball felsõ
							map[Y][i]=new Wall(new Coord(i,Y));
						}			
						else if (c[i].equals("-)")){    //Jobb felsõ
							map[Y][i]=new Wall(new Coord(i,Y));
						}		
						else if (c[i].equals("_)")){   //Bal alsó
							map[Y][i]=new Wall(new Coord(i,Y));
						}		
						else if (c[i].equals("(_")){  // Jobb alsó
							map[Y][i]=new Wall(new Coord(i,Y));
						}		
						else if (c[i].equals("G")){
							map[Y][i]=new Ground(new Coord(i,Y));
						}
						else if (c[i].equals("S")){
							map[Y][i]=new SpecialWall(new Coord(i,Y));
						}
						else if (c[i].equals("s")){
							map[Y][i]=new SpecialWall(new Coord(i,Y));
						}
						else if (c[i].equals("B")){
							map[Y][i]=new Ground(new Coord(i,Y));
							map[Y][i].setObj(new Box());
						}
						else if (c[i].equals("Z")){
							map[Y][i]=new Ground(new Coord(i,Y));
							map[Y][i].setObj(new ZPM(this));
						}
						else if (c[i].equals("P")){
							map[Y][i]=new Pit(game,new Coord(i,Y));
						}	
						else if (c[i].equals("D")){
						}
		    		
						else if (c[i].contains("SS")){
							map[Y][i]=new SpaceShip(new Coord(i,Y));
						}
						else if (c[i].contains("SC")){
							int Dx,Dy;
							Dx=Character.getNumericValue(c[i].charAt(2))*10; 
							Dx+=Character.getNumericValue(c[i].charAt(3)); 
							Dy=Character.getNumericValue(c[i].charAt(4))*10;
							Dy+=Character.getNumericValue(c[i].charAt(5)); 
							map[Y][i]=new Scale(new Coord(i,Y),new Coord(Dy,Dx),this);
							map[Dx][Dy]=new Door(new Coord(Dy,Dx));  
						}
		    	}
		        Y++;
		    }
		} 
		finally {
			map[14][18].setObj(new ZPM(this));
		    br.close();  
		    
		}
	}
	public int getZPMcount()
	{
		return ZPMcount;
	}
	
}
