import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Legesystem{
	
	public File fil;
	
	public void lesFraFil(String a) throws FileNotFoundException { //String a: variabel for aa ta inn filen (gjoeres i test.java)
		fil = new File(a);
		Scanner scan = new Scanner(fil);
		
		while (scan.hasNext()) {
			String linje = scan.nextLine();
			String[] kontrollOrd = linje.split(" ");
			
			//if(scan.nextLine().equals("# Pasienter (navn, fnr)")) {
			if(kontrollOrd[1].equals("Pasienter")) {
				while(!scan.hasNext("#")) {
				
					linje = scan.nextLine();
					System.out.println(linje);
					
				}	
				System.out.println(" ");
			}
			
			
			
			else if(kontrollOrd[1].equals("Legemidler")) {
				while(!scan.hasNext("#")) {
					
					linje = scan.nextLine();
					System.out.println(linje);
					
				}
				System.out.println(" ");
			}
			
			
			else if(kontrollOrd[1].equals("Leger")) {
				while(!scan.hasNext("#")) {
					
					linje = scan.nextLine();
					System.out.println(linje);
					
					
				}	
				System.out.println(" ");
			}
			
			else if(kontrollOrd[1].equals("Resepter")) {
				while(scan.hasNext()) {
					
					linje = scan.nextLine();
					System.out.println(linje);
					
					
				}	
			}
			
			
			
			/*String linje = scan.nextLine();
			String[] ord = linje.split(",");
			String navn = ord[0];
			String foedselsnr = ord[1];
			System.out.println(navn + foedselsnr);
			
			
			String[] deler = linje.split("");
			String nr2 = deler[0].strip();
			nr1 = nr2;
			System.out.println(nr1);*/
			
			//if (nr1.equals("#")) {
				//System.out.println(skan.nextLine());
				
				
			//}
		}

	}
}