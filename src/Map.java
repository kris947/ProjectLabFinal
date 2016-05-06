import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//A pálya osztálya
public class Map {
	public ONeil oneil;
	private int sizeX;
	private int sizeY;
	private int ZPMcount;
	public Tile[][] map = new Tile[20][20]; // Sorokszáma/Oszlopok száma
	public int getSizeX() {
		return sizeX;		
	}
	public int getSizeY() {
		return sizeY;
	}
	public Map() {
		
	}

	public void initmap(ONeil o,Jaffa j) throws IOException{
		oneil=o;
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
						else if (c[i].equals("G")){
							map[Y][i]=new Ground(new Coord(i,Y));
						}
						else if (c[i].equals("S")){
							map[Y][i]=new SpecialWall(new Coord(i,Y));
						}
						else if (c[i].equals("B")){
							map[Y][i]=new Ground(new Coord(i,Y));
						}
						else if (c[i].equals("Z")){
							map[Y][i]=new Ground(new Coord(i,Y));
						}
						else if (c[i].equals("P")){
							map[Y][i]=new Pit(oneil,new Coord(i,Y));
						}	
						else if (c[i].equals("D")){
						}
		    		
						else if (c[i].equals("SS")){
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
		    br.close();
		}
	}
	//
	public void getMap(){
		System.out.println(getSizeY());
		System.out.println(getSizeX());
		System.out.println();
		for (int i=0;i<getSizeY()-1;i++){
			for (int j=0;j<getSizeX()-1;j++){
				if (j==oneil.loc.getX()&& i==oneil.loc.getY())
					System.out.print("O"+i+j+"  ");
				else if (map[i][j] instanceof Portal)
					System.out.print("P"+i+j+"  ");
				else if (map[i][j] instanceof Ground)
					System.out.print("G"+i+j+"  ");
				else if (map[i][j] instanceof SpecialWall)
					System.out.print("S"+i+j+"  ");
				else if (map[i][j] instanceof Door){
					System.out.print("D"+i+j+"  ");}
				else if (map[i][j] instanceof Wall)
					System.out.print("W"+i+j+"  ");
				
				else if (map[i][j] instanceof Pit)
					System.out.print("P"+i+j+"  ");
				else if (map[i][j] instanceof SpaceShip)
					System.out.print("SS"+i+j+"  ");
				
				else if (map[i][j] instanceof Scale)
					System.out.print("SC"+i+j+"  ");				
			}
			System.out.println();
		}

	}
	public int getZPMcount(){return ZPMcount;}
}
