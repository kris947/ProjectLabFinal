//oszt�ly a p�lya koordin�t�inak a t�rol�s�ra
public class Coord {
	private int x;  //adott pont x koordin�t�j�t t�rolja
	private int y;  //adott pont y koordin�t�j�t t�rolja
	
	//Konstruktor, x,y attrib�tum �rt�keinek be�ll�t�s�ra
	public  Coord(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	//Met�dus az x koordin�ta lek�rdez�s�re
	public int getX() {
		return x;
	}
	
	//Met�dus az y koordin�ta lek�rdez�s�re
	public int getY() {
		return y;
	}
	
	//Met�dus az x koordin�ta be�ll�t�s�ra
	public void setX(int x) {
		this.x=x;
	}
	
	//Met�dus az y koordin�ta be�ll�t�s�ra
	public void setY(int y) {
		this.y=y;
	}
	
	public boolean equals(Coord c2)
	{
		if( x==c2.getX() && y == c2.getY() ){ return true;} 
		
		else return false;
	}
}
