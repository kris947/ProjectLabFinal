import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;

//A pálya osztálya
public class Map {
	public ONeil oneil;
	private int sizeX;
	private int sizeY;
	private int ZPMcount;
	Game game;
	public Tile[][] map = new Tile[20][20]; // Sorokszáma/Oszlopok száma
	
	
	public int getSizeX() {
		return sizeX;		
	}
	public int getSizeY() {
		return sizeY;
	}
	public Map(Game g) {
		game = g;
		
	}

	public void initmap(ONeil o,Jaffa j) throws IOException{
		oneil=o;
		int Y=0;
		
		BufferedReader br = new BufferedReader(new FileReader("FinalMap.csv")); // Amikor ezt lecseréljük írjuk át a map nagyságát is 
			try {
				Image image;
				String line; ;
				while ((line= br.readLine())!= null) {
					String[]c=line.split(";");
					sizeX= c.length+1;
					sizeY = Y+1 ;
					for(int i=0;i<c.length;i++){
						if (c[i].equals("W")){
							ImageIcon ic = new ImageIcon("wall2.jpg");
					        image = ic.getImage();
							map[Y][i]=new Wall(new Coord(i,Y),image);
						}
						else if (c[i].equals("w")){
							ImageIcon ic = new ImageIcon("wall1.jpg");
					        image = ic.getImage();
							map[Y][i]=new Wall(new Coord(i,Y),image);
						}			
						else if (c[i].equals("(-")){  //Ball felsõ
							ImageIcon ic = new ImageIcon("wall12.jpg");
					        image = ic.getImage();
							map[Y][i]=new Wall(new Coord(i,Y),image);
						}			
						else if (c[i].equals("-)")){    //Jobb felsõ
							ImageIcon ic = new ImageIcon("wall21.jpg");
					        image = ic.getImage();
							map[Y][i]=new Wall(new Coord(i,Y),image);
						}		
						else if (c[i].equals("_)")){   //Bal alsó
							ImageIcon ic = new ImageIcon("wall112.jpg");
					        image = ic.getImage();
							map[Y][i]=new Wall(new Coord(i,Y),image);
						}		
						else if (c[i].equals("(_")){  // Jobb alsó
							ImageIcon ic = new ImageIcon("wall121.jpg");
					        image = ic.getImage();
							map[Y][i]=new Wall(new Coord(i,Y),image);
						}		
						else if (c[i].equals("G")){
							map[Y][i]=new Ground(new Coord(i,Y));
						}
						else if (c[i].equals("S")){
							ImageIcon ic = new ImageIcon("specialwall2.jpg");
					        image = ic.getImage();
							map[Y][i]=new SpecialWall(new Coord(i,Y),image);
						}
						else if (c[i].equals("s")){
							ImageIcon ic = new ImageIcon("specialwall1.jpg");
					        image = ic.getImage();
							map[Y][i]=new SpecialWall(new Coord(i,Y),image);
						}
						else if (c[i].equals("B")){
							map[Y][i]=new Ground(new Coord(i,Y));
							map[Y][i].setObj(new Box(1));
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
