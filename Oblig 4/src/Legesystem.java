import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

public class Legesystem {
	
	public File fil;
	public Lenkeliste<Pasient> listePasienter;
	public Lenkeliste<Legemiddel> listeLegemidler;
	public SortertLenkeliste<Lege> listeLeger; //Må kanskje gjøre sortert
	public Lenkeliste<Resept> listeResept;
	
	public Legesystem() {
		listePasienter = new Lenkeliste<Pasient>();
		listeLegemidler = new Lenkeliste<Legemiddel>();
		listeLeger = new SortertLenkeliste<Lege>(); //kanksje gjøres sortert
		listeResept = new Lenkeliste<Resept>();
	}
	
	public void lesFraFil(String a) throws FileNotFoundException, UlovligUtskrift { //String a: variabel for aa ta inn filen (gjoeres i test.java)
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
					//System.out.println(linje);
					
				}	
				//System.out.println(" ");
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
					//System.out.println(linje);
				}
				//System.out.println(" ");
			}
			
			else if(kontrollOrd[1].equals("Leger")) {
				while(!scan.hasNext("#")) {
					
					linje = scan.nextLine();
					String[] ord = linje.split(",");
					String navn = ord[0];
					int type = Integer.parseInt(ord[1]);
					if (type == 0) {
						Lege obj = new Lege(navn);
						listeLeger.leggTil(obj);; //kanskje implimentere sortert lenkeliste
					}
					else if (type != 0){
						Spesialist obj = new Spesialist(navn, type);
						listeLeger.leggTil(obj); //kanskje implimentere sortert lenkeliste
					}
					//System.out.println(linje);
				}	
				//System.out.println(" ");
			}
			
			else if(kontrollOrd[1].equals("Resepter")) {
				while(scan.hasNext()) {
					
					linje = scan.nextLine();
					String[] ord = linje.split(",");
					int unikIdLegemiddel = Integer.parseInt(ord[0]);
					String navnLege = ord[1];
					int unikeIdPasient = Integer.parseInt(ord[2]);
					String typeResept = ord[3];
					int reit = 0;
					try {
						int Reit = Integer.parseInt(ord[4]);
						reit = Reit;
					} catch (ArrayIndexOutOfBoundsException ignored){}
					int i = 0;
					Lege tempLege = null;
					Legemiddel tempResept = null;
					Pasient tempPasient = null;
					while (i < listeLegemidler.stoerrelse()) {
						if(listeLegemidler.hent(i).hentId() == unikIdLegemiddel) {
							tempResept = listeLegemidler.hent(i);
						}
						i++;
					}
					int e = 0;
					while (e < listeLeger.stoerrelse()) {
						if(listeLeger.hent(e).hentNavnLege().equals(navnLege)) {
							tempLege = listeLeger.hent(e);
						}
						e++;
					}
					int b = 0;
					while (b < listePasienter.stoerrelse()) {
						if(listePasienter.hent(b).hentIid() == unikeIdPasient) {
							tempPasient = listePasienter.hent(b);
						}
						b++;
					}
					if (typeResept.equals("hvit")) {
						listeResept.leggTilForan(tempLege.skrivHvitResept(tempResept, tempPasient, reit));
					}
					if (typeResept.equals("blaa")) {
						listeResept.leggTilForan(tempLege.skrivBlaaResept(tempResept, tempPasient, reit));
					}
					if (typeResept.equals("millitaer")) { //millitær med en eller to l'er i testfil
						listeResept.leggTilForan(tempLege.skrivMilitaerResept(tempResept, tempPasient, reit)); //to l'er
					}
					if(typeResept.equals("p")) {
						listeResept.leggTilForan(tempLege.skrivPResept(tempResept, tempPasient));
					}
					//System.out.println(linje);
				}	
			}
		}
		
		scan.close();
	}

	public Lenkeliste<Pasient> hentListePasienter() {
		return listePasienter;
	}
	
	public Lenkeliste<Legemiddel> hentListeLegemidler(){
		return listeLegemidler;
	}
	
	public SortertLenkeliste<Lege> hentListeLeger(){
		return listeLeger;
	}
	
	public Lenkeliste<Resept> hentListeResepter(){
		return listeResept;
	}
		
}