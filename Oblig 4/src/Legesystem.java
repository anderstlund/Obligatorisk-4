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
			while (skan.hasNext()) {
				String linje = skan.nextLine();
				String[] ord = linje.split(",");
				String navn = ord[0];
				String foedselsnr = ord[1];
				System.out.println(navn + foedselsnr);
				
				String[] deler = navn.split("");
				String nr1 = deler[0].strip();
				System.out.println(nr1);
				
				if (nr1.equals("#")) {
					skan.nextLine();
					
					
				}
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Finner ikke filen");
		}

	}
}