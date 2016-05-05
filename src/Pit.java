//Osztály a szakadék kezelésére
public class Pit extends Tile {
	ONeil oneil;
	
	//Konstruktor
	Pit( ONeil oneill,Coord c ){
		super(c);
		oneil=oneill;
		//System.out.println("Pit: konstruktor hívás");
		
	}

	//Kezeli az esetet amikor Oneill a szakadékba lép
	@Override
	public Coord stepOn(Coord c) {
		//System.out.println("Coord: stepOn metódus hívás");
		Coord tempcord=new Coord(2,1);
		
		if(oneil.lives>1){ //Ha van még élete..
		oneil.lives--;  //..Akkor csökkentjük
		//System.out.println("O'neil élete csökken és visszakerül a kezdõ pozícióba");
		return tempcord;
		}
		endGame(); //Ha már nincs élete akkor vége ajátéknak
		return null;
	}
	
	//Játék vége a kezelése
	public void endGame(){
		//System.out.println("Pit: endGame metódus meghívása");
		//System.out.println("A játéknak vége a misszió elbukott");
		System.exit(0);
		
	}
	
}
