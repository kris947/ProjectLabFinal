//Oszt�ly a szakad�k kezel�s�re
public class Pit extends Tile {
	ONeil oneil;
	
	//Konstruktor
	Pit( ONeil oneill,Coord c ){
		super(c);
		oneil=oneill;
		//System.out.println("Pit: konstruktor h�v�s");
		
	}

	//Kezeli az esetet amikor Oneill a szakad�kba l�p
	@Override
	public Coord stepOn(Coord c) {
		//System.out.println("Coord: stepOn met�dus h�v�s");
		Coord tempcord=new Coord(2,1);
		
		if(oneil.lives>1){ //Ha van m�g �lete..
		oneil.lives--;  //..Akkor cs�kkentj�k
		//System.out.println("O'neil �lete cs�kken �s visszaker�l a kezd� poz�ci�ba");
		return tempcord;
		}
		endGame(); //Ha m�r nincs �lete akkor v�ge aj�t�knak
		return null;
	}
	
	//J�t�k v�ge a kezel�se
	public void endGame(){
		//System.out.println("Pit: endGame met�dus megh�v�sa");
		//System.out.println("A j�t�knak v�ge a misszi� elbukott");
		System.exit(0);
		
	}
	
}
