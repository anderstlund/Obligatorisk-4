import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Legesystem{
	
	public File fil;
	public Lenkeliste<Pasient> listePasienter;
	public Lenkeliste<Legemiddel> listeLegemidler;
	public Lenkeliste<Lege> listeLege; //Må kanskje gjøre sortert
	public Lenkeliste<Resept> listeResept;
	
	public Legesystem() {
		listePasienter = new Lenkeliste<Pasient>();
		listeLegemidler = new Lenkeliste<Legemiddel>();
		listeLege = new Lenkeliste<Lege>(); //kanksje gjøres sortert
		listeResept = new Lenkeliste<Resept>();
	}
	
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
					String[] ord = linje.split(",");
					String navn = ord[0];
					String foedselsnr = ord[1];
					Pasient obj = new Pasient(navn, foedselsnr);
					listePasienter.leggTilForan(obj);
					System.out.println(linje);
					
				}	
				System.out.println(" ");
			}
			
			else if(kontrollOrd[1].equals("Legemidler")) {
				while(!scan.hasNext("#")) {
					
					linje = scan.nextLine();
					String[] ord = linje.split(",");
					String navn = ord[0];
					String type = ord[1];
					double pris = Double.parseDouble(ord[2]);
					double virkestoff = Double.parseDouble(ord[3]);
					int styrke = 0;
					try {
						int Styrke = Integer.parseInt(ord[4]);
						styrke = Styrke;
					} catch (ArrayIndexOutOfBoundsException ignored){}
					if (type.equals("narkotisk")) {
						NarkotiskLegemiddel obj = new NarkotiskLegemiddel(navn, pris, virkestoff, styrke);
						listeLegemidler.leggTilForan(obj);
					}
					if (type.equals("vanedannende")) {
						VanedannendeLegemiddel obj = new VanedannendeLegemiddel(navn, pris, virkestoff, styrke);
						listeLegemidler.leggTil(obj);
					}
					if (type.equals("vanlig")) {
						VanligLegemiddel obj = new VanligLegemiddel(navn, pris, virkestoff);
						listeLegemidler.leggTil(obj);
					}
					System.out.println(linje);
				}
				System.out.println(" ");
			}
			
			else if(kontrollOrd[1].equals("Leger")) {
				while(!scan.hasNext("#")) {
					
					linje = scan.nextLine();
					String[] ord = linje.split(",");
					String navn = ord[0];
					int type = Integer.parseInt(ord[1]);
					if (type == 0) {
						Lege obj = new Lege(navn);
						listeLege.leggTilForan(obj); //kanskje implimentere sortert lenkeliste
					}
					else if (type != 0){
						Spesialist obj = new Spesialist(navn, type);
						listeLege.leggTilForan(obj); //kanskje implimentere sortert lenkeliste
					}
					System.out.println(linje);
				}	
				System.out.println(" ");
			}
			
			else if(kontrollOrd[1].equals("Resepter")) {
				while(scan.hasNext()) {
					
					linje = scan.nextLine();
					String[] ord = linje.split(",");
					String unikIdLegemiddel = ord[0];
					String navnLege = ord[1];
					int unikeIdPasient = Integer.parseInt(ord[2]);
					String typeResept = ord[3];
					int reit = 0;
					try {
						int Reit = Integer.parseInt(ord[4]);
						reit = Reit;
					} catch (ArrayIndexOutOfBoundsException ignored){}
					
					
					System.out.println(linje);
				}	
			}
		}
	}

	public Lenkeliste<Pasient> hentListePasienter() {
		return listePasienter;
	}
	
	public Lenkeliste<Legemiddel> hentListeLegemidler(){
		return listeLegemidler;
	}
	
	public Lenkeliste<Lege> hentListeLeger(){
		return listeLege;
	}
	
	public Lenkeliste<Resept> hentListeResepter(){
		return listeResept;
	}
		
}