import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EnumSet;
import java.lang.Object;

public class Game {
	/*public static void main(String[] args) throws IOException  
	{
		manualtest();			
	}*/
	
	
	
	
	//----------------------------------
	//Az eddigi Game osztály van ebben , és ha ez arra jó ,ha tesztelni akarjuk stdinputtba tudunk beírni parancsokat
	public static void manualtest() throws IOException{
		String n;	
		Map map = new Map();
		ONeil o = null;
		Jaffa j=null;
		Replicator r=null;
		WormHole wh=new WormHole();
		o = new ONeil(map,3);
		j= new Jaffa(map,3);
		map.initmap(o,j);
		String[] params;
		o = new ONeil(map,3);
		j= new Jaffa(map,3);
		r=new Replicator(map,3);
		wh= new WormHole();
		ReplicatorThread rThread=new ReplicatorThread(map);
		map.initmap(o,j);
	
		 BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
			try {
			  
			    String line ;
	
			    while ((line = br2.readLine())!= null) {			        
			        n=line;
			
					params = n.split(":");
								
					if(params[0].equals("ListMap"))
					{
						map.getMap();
					}
					
					else if (params[0].equals("OMove"))
					{
						int count =Integer.parseInt(params[1]);
						if(params[2].equals("Up"))
						{
							if(o.direction!=ONeil.Directions.Up)
								count--;
							o.direction=ONeil.Directions.Up;
								
						}
						else if(params[2].equals("Down"))
						{
							if(o.direction!=ONeil.Directions.Down)
								count--;
							o.direction=ONeil.Directions.Down;
								
						}
							
						else if(params[2].equals("Right"))
						{
							if(o.direction!=ONeil.Directions.Right)
								count--;
							o.direction=ONeil.Directions.Right;
								
						}
						else if(params[2].equals("Left"))
						{
							if(o.direction!=ONeil.Directions.Left)
								count--;
							o.direction=ONeil.Directions.Left;
						}
						
						for (int i = 0; i < count; i++)
						{
							o.move();	
						}
						System.out.println(params[0]+":"+o.loc.getX()+":"+o.loc.getY()+":");
						/*if (map.map[o.loc.getX()][o.loc.getY()] instanceof Pit)
							System.out.println(params[0]+":"+o.loc.getX()+":"+o.loc.getY()+":"+o.direction+":"+"fell into pit");
						if (map.map[o.loc.getX()][o.loc.getY()] instanceof Door)
							System.out.println(params[0]+":"+o.loc.getX()+":"+o.loc.getY()+":"+o.direction+":"+"stepped on scale -> door opened");
						if (map.map[o.loc.getX()][o.loc.getY()] instanceof Portal)
							System.out.println(params[0]+":"+o.loc.getX()+":"+o.loc.getY()+":"+o.direction+":"+"stepped on portal");
						if (map.map[map.oneil.loc.getY()][map.oneil.loc.getX()] instanceof Wall || map.map[map.oneil.loc.getY()][map.oneil.loc.getX()] instanceof SpecialWall)
							System.out.println(params[0]+":"+o.loc.getX()+":"+o.loc.getY()+":"+o.direction+":"+"denied");*/
						
						
					}
					else if (params[0].equals("RMove"))
					{
						rThread.start();
						
						
						
					}
					
					else if (params[0].equals("JMove"))
					{
						if(params[2].equals("Up"))
							j.direction = ONeil.Directions.Up;
						else if(params[2].equals("Down"))
							j.direction = ONeil.Directions.Down;
						else if(params[2].equals("Right"))
							j.direction = ONeil.Directions.Right;
						else if(params[2].equals("Left"))
							j.direction = ONeil.Directions.Left;
						
						for (int i = 0; i < Integer.parseInt(params[1]); i++)
						{
							j.move();	
						}
						System.out.println(params[0]+":"+o.loc.getX()+":"+o.loc.getY()+":");
					}
					
					else if (params[0].equals("OShootB"))
					{
						o.shoot('b', wh);
					}
					else if (params[0].equals("OShootY"))
					{
						o.shoot('y', wh);
					}
					
					else if (params[0].equals("JShootR"))
					{
						j.shoot('r', wh);
					}
					else if (params[0].equals("JShootG"))
					{
						j.shoot('g', wh);
					}
					
					else if (params[0].equals("OUse"))
					{
						if(o.object!=null)
							o.dropDown();
						else
							o.pickUp();
						//System.out.println(params[0]+":"+o.loc.getX()+":"+o.loc.getY()+":");
						
						switch (map.oneil.direction) {
						case Up:   //Fel
							int t1=map.oneil.loc.getY()-1;
							System.out.println(params[0]+":"+map.oneil.loc.getX()+":"+t1+":");
						break;
						case Down: //le
							int t2=map.oneil.loc.getY()+1;
							System.out.println(params[0]+":"+map.oneil.loc.getX()+":"+t2+":");
						break;
						case Left: //Balra
							int t3=map.oneil.loc.getX()-1;
							System.out.println(params[0]+":"+t3+":"+map.oneil.loc.getY()+":");
						break;
						case Right: //Jobb
							int t4=map.oneil.loc.getX()+1;
							System.out.println(params[0]+":"+t4+":"+map.oneil.loc.getY()+":");
						break;		
					}
						
					}
					
					else if (params[0].equals("JUse"))
					{
						if(j.object!=null)
							j.dropDown();
						else
							j.pickUp();
					}
						
					else if(n.equals("MissionDetails")){
						if(map!=null && o!=null){
						System.out.println("Collected ZPMs: "+new ZPM(map).getZPMcount());
						System.out.println("Remaining life: "+o.lives);
							//System.out.println("blue"+wh.getBlue().getX()+wh.getBlue().getY()+" Yellow "+wh.getYellow().getX()+wh.getYellow().getY());
					}
						else 
							System.out.println("Rosszcsont !! ELöbb töltsd be a pályát és kezd játszani.");
							
					}
					
					
		    //--------------
			    }
				   // String everything = sb.toString();
				} 
			finally 
				{
				    br2.close();
				}		
	}
	//---------------------------
	
	
}






	

