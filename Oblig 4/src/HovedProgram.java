import java.io.FileNotFoundException;
import java.util.Scanner;

public class HovedProgram<T> extends LenkelisteIterator<T>{

	public static void main(String[] args) throws UlovligUtskrift {
		
		Legesystem system = new Legesystem();
		try {
			system.lesFraFil("Testeks.txt");
			//System.out.println(system.hentListePasienter());
			//System.out.println(system.hentListeLegemidler());
			//System.out.println(system.hentListeLeger());
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException: Ingen fil");
		}
		
		
		String hovedmeny = "Hovedmeny:\n1: Oversikt\n2: Legg til\n0: Avslutt";
		System.out.println(" ");
		System.out.println(hovedmeny);
		
		
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		
		while(input != 0) {
			if(input == 1) {
				while(input != 0) {
					System.out.println("Oversikt - meny:\n1: Leger\n2: Pasienter\n3: Resepter\n4: Legemidler\n0: Tilbake ");
					input = scan.nextInt(); 
					
					if(input == 0) {
						break;
						}
					else if(input == 1) {
						System.out.println("Leger: ");
						System.out.println(system.hentListeLeger());
						System.out.println("0: Tilbake ");
						input = scan.nextInt();
						}
					else if(input == 2) {
						System.out.println("Pasienter: ");
						System.out.println(system.hentListePasienter());
						System.out.println("0: Tilbake ");
						input = scan.nextInt();
						}
					else if(input == 3) {
						System.out.println("Resepter: ");
						System.out.println(system.hentListeResepter());
						System.out.println("0: Tilbake ");
						input = scan.nextInt();
						}
					else if(input == 4) {
						System.out.println("Legemidler: ");
						System.out.println(system.hentListeLegemidler());
						System.out.println("0: Tilbake ");
						input = scan.nextInt();
						}
					}
				System.out.println(" ");
				System.out.println(hovedmeny);
				input = scan.nextInt();
				}
			
			if(input == 2) {
				while(input != 0) {
					System.out.println("1: Legg til lege\n2: Legg til pasient\n3: Lag ny resept\n4: Legg til legemiddel\n0: Tilbake ");
					input = scan.nextInt();
					if(input == 0) {
						break;
					}
					else if(input == 1) {
						System.out.println("1: Opprett lege\n2: Opprett spesialist");
						input = scan.nextInt();
						if(input == 1) {
							String navn = scan.nextLine();
							System.out.println("Skriv inn navn (Dr. navn): ");
							navn = scan.nextLine();
							String tempLege = navn +"," + 0;
							
							Lege nyLege = new Lege(navn);
							system.hentListeLeger().leggTil(nyLege);
							
						}
						else if(input == 2) {
							int kontrollId; 
							String navn = scan.nextLine();
							
							System.out.println("Skriv inn navn (Dr. navn): ");
							navn = scan.nextLine();
							System.out.println("Skriv inn kontrollId: ");
							input = scan.nextInt();
							
							kontrollId = input;
							String nySpesialist = navn + "," + kontrollId;
							
						}
					}
					
					else if(input == 2) {
						String navn = scan.nextLine();
						System.out.println("Navn: ");
						navn = scan.nextLine();
						
						
						System.out.println("Foedselsnummer: ");
						String fnr = scan.nextLine();
						
						String tempPasient = navn + "," + fnr;
						
						Pasient nyPasient = new Pasient(navn, fnr);
						system.hentListePasienter().leggTilForan(nyPasient);
						
					}
					
					
				}
				System.out.println(" ");
				System.out.println(hovedmeny);
				input = scan.nextInt();
			}
		}
		
	

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*Lege nyLege = new Lege("Dangfart T�nnesen"); //Oppretter en lege
		Spesialist spesialist = new Spesialist("Knut Knudsen", 2); //Oppretter spesialist
		//toString: skriver ut
		System.out.println(nyLege.toString());
		System.out.println(spesialist.toString());
		
		//Legemidler:
		VanligLegemiddel vanligLegemiddel = new VanligLegemiddel("Paracetamol", 70.50, 500); //Oppretter vanlig legemiddel
		NarkotiskLegemiddel narkotiskLegemiddel = new NarkotiskLegemiddel("Morfin", 638.90, 15.0, 9); //Oppretter narkotisk legemiddel
		VanedannendeLegemiddel vanedannendeLegemiddel = new VanedannendeLegemiddel("Nesespray", 35.50, 20, 6); //Oppretter vanedannende Legemiddel
		VanligLegemiddel vanligLegemiddel1 = new VanligLegemiddel("Prevensjon", 112.50, 500);//For pResept
		//toString: skriver ut
		System.out.println(vanligLegemiddel.toString());
		System.out.println(narkotiskLegemiddel.toString());
		System.out.println(vanedannendeLegemiddel.toString());
		System.out.println(vanligLegemiddel1.toString());
		
		//Resept:
		HvitResept hvitResept = new HvitResept(vanligLegemiddel, nyLege, 1, 1);//Oppretter hvit resept med paracetamol som legemiddel, og Dangfart T�nnesen som lege
		MilitaerResept militaerResept = new MilitaerResept(narkotiskLegemiddel, nyLege, 2, 5);
		PResept pResept = new PResept(vanligLegemiddel1, nyLege, 3, 1);
		BlaaResept blaaResept = new BlaaResept(narkotiskLegemiddel, nyLege, 4, 3);
		//toString: skriver ut
		System.out.println(hvitResept.toString());
		System.out.println(militaerResept.toString());
		System.out.println(pResept.toString());
		System.out.println(blaaResept.toString());*/
		
	}

}
