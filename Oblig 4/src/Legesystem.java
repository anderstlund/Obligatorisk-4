import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Legesystem{
	
	public File fil;
	
	public void lesFraFil(String a) {
		fil = new File(a);
		Scanner skan;
		try {
			skan = new Scanner(fil);
			skan.nextLine();
			String nr1 = "";
			while (skan.hasNext() && !nr1.equals("#")) {
				String linje = skan.nextLine();
				String[] ord = linje.split(",");
				String navn = ord[0];
				String foedselsnr = ord[1];
				System.out.println(navn + foedselsnr);
				
				
				String[] deler = linje.split("");
				String nr2 = deler[0].strip();
				nr1 = nr2;
				System.out.println(nr1);
				
				//if (nr1.equals("#")) {
					//System.out.println(skan.nextLine());
					
					
				//}
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Finner ikke filen");
		}

	}
}