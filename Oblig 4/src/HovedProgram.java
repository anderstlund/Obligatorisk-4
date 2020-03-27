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
		
		
		String hovedmeny = "Hovedmeny:\n1: Oversikt\n2: Legg til\n3: Bruk resept\n4: Vis Statistikk\n0: Avslutt";
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
			
			else if(input == 2) {
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
					
					else if(input == 3) {
						Lege tempLege = null;
						System.out.println("1: Lege\n2: Spesialist");
						input = scan.nextInt();
						
						if(input == 1) {
							String navn = scan.nextLine();							
							System.out.println("Navn: ");
							navn = scan.nextLine();
							
							
							int e = 0;
							while (e < system.hentListeLeger().stoerrelse()) {
								if(navn.equals(system.hentListeLeger().hent(e).hentNavnLege())) {
									tempLege = system.hentListeLeger().hent(e);
									System.out.println(navn);
									break;
								}
								e++;
							}
							if(tempLege == null) {
								System.out.println("Denne legen eksisterer ikke i databasen.");
								break;
							}
							
							Pasient tempPasient = null;		
							System.out.println("Navn pasient: ");
							String navnPasient = scan.nextLine();
							
							
							int i = 0;
							while (i < system.hentListePasienter().stoerrelse()) {
								if(system.hentListePasienter().hent(i).hentNavn().equals(navnPasient)) {
									tempPasient = system.hentListePasienter().hent(i);
									System.out.println(navnPasient);
								}
								i++;
							}	
							if(tempPasient == null) {
								System.out.println("Denne pasienten eksisterer ikke i databasen.");
								break;
							}
							
							System.out.println("Type resept:\n1: Hvit\n2: Blaa\n3: Militaer\n4: P-resept");
							input = scan.nextInt();
							
							if(input == 1) {
								Legemiddel tempLegemiddel = null;
								String navnLegemiddel = scan.nextLine();
								System.out.println("Legemidler: ");
								navnLegemiddel = scan.nextLine();
								//System.out.println(navnLegemiddel);
								
								int j = 0;
								while (j < system.hentListeLegemidler().stoerrelse()) {
									if(system.hentListeLegemidler().hent(j).hentNavn().equals(navnLegemiddel)) {
										tempLegemiddel = system.hentListeLegemidler().hent(j);
										System.out.println(navnLegemiddel);
									}
									j++;
								}	
								
								if(tempLegemiddel instanceof NarkotiskLegemiddel) {
									System.out.println("Lege er ikke spesialist og kan derfor ikke skrive ut narkotiske legemidler.");
									break;
								}
								if(tempLegemiddel == null) {
									System.out.println("Dette legemiddelet eksisterer ikke i databasen.");
									break;
								}
								
								System.out.println("Antall reit: ");
								input = scan.nextInt();
								
								//tempLege.skrivHvitResept(tempLegemiddel, tempPasient, input);
								system.listeResept.leggTil(tempLege.skrivHvitResept(tempLegemiddel, tempPasient, input));
							}
							
							else if(input == 2) {
								Legemiddel tempLegemiddel = null;
								String navnLegemiddel = scan.nextLine();
								System.out.println("Legemidler: ");
								navnLegemiddel = scan.nextLine();
								//System.out.println(navnLegemiddel);
								
								int j = 0;
								while (j < system.hentListeLegemidler().stoerrelse()) {
									if(system.hentListeLegemidler().hent(j).hentNavn().equals(navnLegemiddel)) {
										tempLegemiddel = system.hentListeLegemidler().hent(j);
										System.out.println(navnLegemiddel);
									}
									j++;
								}	
								
								if(tempLegemiddel instanceof NarkotiskLegemiddel) {
									System.out.println("Lege er ikke spesialist og kan derfor ikke skrive ut narkotiske legemidler.");
									break;
								}
								if(tempLegemiddel == null) {
									System.out.println("Dette legemiddelet eksisterer ikke i databasen.");
									break;
								}
								
								System.out.println("Antall reit: ");
								input = scan.nextInt();
								
								//tempLege.skrivHvitResept(tempLegemiddel, tempPasient, input);
								system.listeResept.leggTil(tempLege.skrivBlaaResept(tempLegemiddel, tempPasient, input));	
							}
							
							else if(input == 3) {
								Legemiddel tempLegemiddel = null;
								String navnLegemiddel = scan.nextLine();
								System.out.println("Legemidler: ");
								navnLegemiddel = scan.nextLine();
								//System.out.println(navnLegemiddel);
								
								int j = 0;
								while (j < system.hentListeLegemidler().stoerrelse()) {
									if(system.hentListeLegemidler().hent(j).hentNavn().equals(navnLegemiddel)) {
										tempLegemiddel = system.hentListeLegemidler().hent(j);
										System.out.println(navnLegemiddel);
									}
									j++;
								}	
								
								if(tempLegemiddel instanceof NarkotiskLegemiddel) {
									System.out.println("Lege er ikke spesialist og kan derfor ikke skrive ut narkotiske legemidler.");
									break;
								}
								if(tempLegemiddel == null) {
									System.out.println("Dette legemiddelet eksisterer ikke i databasen.");
									break;
								}
								
								System.out.println("Antall reit: ");
								input = scan.nextInt();
								
								//tempLege.skrivHvitResept(tempLegemiddel, tempPasient, input);
								system.listeResept.leggTil(tempLege.skrivMilitaerResept(tempLegemiddel, tempPasient, input));
							}
							
							else if(input == 4) {
								Legemiddel tempLegemiddel = null;
								String navnLegemiddel = scan.nextLine();
								System.out.println("Legemidler: ");
								navnLegemiddel = scan.nextLine();
								//System.out.println(navnLegemiddel);
								
								int j = 0;
								while (j < system.hentListeLegemidler().stoerrelse()) {
									if(system.hentListeLegemidler().hent(j).hentNavn().equals(navnLegemiddel)) {
										tempLegemiddel = system.hentListeLegemidler().hent(j);
										System.out.println(navnLegemiddel);
									}
									j++;
								}	
								
								if(tempLegemiddel instanceof NarkotiskLegemiddel) {
									System.out.println("Lege er ikke spesialist og kan derfor ikke skrive ut narkotiske legemidler.");
									break;
								}
								if(tempLegemiddel == null) {
									System.out.println("Dette legemiddelet eksisterer ikke i databasen.");
									break;
								}
								
								
								//tempLege.skrivHvitResept(tempLegemiddel, tempPasient, input);
								system.listeResept.leggTil(tempLege.skrivPResept(tempLegemiddel, tempPasient));
							}
						}
						else if (input == 2) { //Spesialist
							String navn = scan.nextLine();							
							System.out.println("Navn: ");
							navn = scan.nextLine();
							
							
							int e = 0;
							while (e < system.hentListeLeger().stoerrelse()) {
								if(navn.equals(system.hentListeLeger().hent(e).hentNavnLege())) {
									tempLege = system.hentListeLeger().hent(e);
									System.out.println(navn);
									break;
								}
								e++;
							}
							if(tempLege == null) {
								System.out.println("Denne legen eksisterer ikke i databasen.");
								break;
							}
							if(!(tempLege instanceof Spesialist)) {
								System.out.println("Denne legen er ikke en spesialist.");
								break;
							}
							
							Pasient tempPasient = null;		
							System.out.println("Navn pasient: ");
							String navnPasient = scan.nextLine();
							
							
							int i = 0;
							while (i < system.hentListePasienter().stoerrelse()) {
								if(system.hentListePasienter().hent(i).hentNavn().equals(navnPasient)) {
									tempPasient = system.hentListePasienter().hent(i);
									System.out.println(navnPasient);
								}
								i++;
							}	
							if(tempPasient == null) {
								System.out.println("Denne pasienten eksisterer ikke i databasen.");
								break;
							}
							
							System.out.println("Type resept:\n1: Hvit\n2: Blaa\n3: Militaer\n4: P-resept");
							input = scan.nextInt();
							
							if(input == 1) {
								Legemiddel tempLegemiddel = null;
								String navnLegemiddel = scan.nextLine();
								System.out.println("Legemidler: ");
								navnLegemiddel = scan.nextLine();
								//System.out.println(navnLegemiddel);
								
								int j = 0;
								while (j < system.hentListeLegemidler().stoerrelse()) {
									if(system.hentListeLegemidler().hent(j).hentNavn().equals(navnLegemiddel)) {
										tempLegemiddel = system.hentListeLegemidler().hent(j);
										System.out.println(navnLegemiddel);
									}
									j++;
								}	
								
								
								if(tempLegemiddel == null) {
									System.out.println("Dette legemiddelet eksisterer ikke i databasen.");
									break;
								}
								
								System.out.println("Antall reit: ");
								input = scan.nextInt();
								
								//tempLege.skrivHvitResept(tempLegemiddel, tempPasient, input);
								system.listeResept.leggTil(tempLege.skrivHvitResept(tempLegemiddel, tempPasient, input));
							}
							
							else if(input == 2) {
								Legemiddel tempLegemiddel = null;
								String navnLegemiddel = scan.nextLine();
								System.out.println("Legemidler: ");
								navnLegemiddel = scan.nextLine();
								//System.out.println(navnLegemiddel);
								
								int j = 0;
								while (j < system.hentListeLegemidler().stoerrelse()) {
									if(system.hentListeLegemidler().hent(j).hentNavn().equals(navnLegemiddel)) {
										tempLegemiddel = system.hentListeLegemidler().hent(j);
										System.out.println(navnLegemiddel);
									}
									j++;
								}	
								
								
								if(tempLegemiddel == null) {
									System.out.println("Dette legemiddelet eksisterer ikke i databasen.");
									break;
								}
								
								System.out.println("Antall reit: ");
								input = scan.nextInt();
								
								//tempLege.skrivHvitResept(tempLegemiddel, tempPasient, input);
								system.listeResept.leggTil(tempLege.skrivBlaaResept(tempLegemiddel, tempPasient, input));	
							}
							
							else if(input == 3) {
								Legemiddel tempLegemiddel = null;
								String navnLegemiddel = scan.nextLine();
								System.out.println("Legemidler: ");
								navnLegemiddel = scan.nextLine();
								//System.out.println(navnLegemiddel);
								
								int j = 0;
								while (j < system.hentListeLegemidler().stoerrelse()) {
									if(system.hentListeLegemidler().hent(j).hentNavn().equals(navnLegemiddel)) {
										tempLegemiddel = system.hentListeLegemidler().hent(j);
										System.out.println(navnLegemiddel);
									}
									j++;
								}	
								
							
								if(tempLegemiddel == null) {
									System.out.println("Dette legemiddelet eksisterer ikke i databasen.");
									break;
								}
								
								System.out.println("Antall reit: ");
								input = scan.nextInt();
								
								//tempLege.skrivHvitResept(tempLegemiddel, tempPasient, input);
								system.listeResept.leggTil(tempLege.skrivMilitaerResept(tempLegemiddel, tempPasient, input));
							}
							
							else if(input == 4) {
								Legemiddel tempLegemiddel = null;
								String navnLegemiddel = scan.nextLine();
								System.out.println("Legemidler: ");
								navnLegemiddel = scan.nextLine();
								//System.out.println(navnLegemiddel);
								
								int j = 0;
								while (j < system.hentListeLegemidler().stoerrelse()) {
									if(system.hentListeLegemidler().hent(j).hentNavn().equals(navnLegemiddel)) {
										tempLegemiddel = system.hentListeLegemidler().hent(j);
										System.out.println(navnLegemiddel);
									}
									j++;
								}	
								
								if(tempLegemiddel == null) {
									System.out.println("Dette legemiddelet eksisterer ikke i databasen.");
									break;
								}
								
								
								//tempLege.skrivHvitResept(tempLegemiddel, tempPasient, input);
								system.listeResept.leggTil(tempLege.skrivPResept(tempLegemiddel, tempPasient));
							}
						}
					}	
					else if(input == 4) {
						
						while(input != 0) {
							
							System.out.println("Type legemiddel:\n1: Vanlig legemiddel\n2: Vanedannende legemiddel\n3: Narkotisk legemiddel\n0: Tilbake");
							input = scan.nextInt();
							if(input == 1) {
								String navn = scan.nextLine();
								System.out.println("Navn p� legemiddel: ");
								navn = scan.nextLine();
								
								
								System.out.println("Pris: ");
								double pris = scan.nextDouble();
								//pris = scan.nextDouble();
								
								
								System.out.println("Virkestoff: ");
								double virkestoff = scan.nextDouble();
								//virkestoff = scan.nextInt();
								
								VanligLegemiddel vanligLegemiddel = new VanligLegemiddel(navn, pris, virkestoff);
								system.hentListeLegemidler().leggTilForan(vanligLegemiddel);
								System.out.println("Legemiddel lagt til.");
							}
							
							else if(input == 2) {
								String navn = scan.nextLine();
								System.out.println("Navn p� legemiddel: ");
								navn = scan.nextLine();
								
								
								System.out.println("Pris: ");
								double pris = scan.nextDouble();
								//pris = scan.nextDouble();
								
								
								System.out.println("Virkestoff: ");
								double virkestoff = scan.nextDouble();
								//virkestoff = scan.nextInt();
								
								System.out.println("Styrke, vanedannende: ");
								int styrke = scan.nextInt();
								
								VanedannendeLegemiddel vanedannendeLegemiddel = new VanedannendeLegemiddel(navn, pris, virkestoff, styrke);
								system.hentListeLegemidler().leggTilForan(vanedannendeLegemiddel);
								System.out.println("Legemiddel lagt til.");
							}
							else if(input == 3) {
								String navn = scan.nextLine();
								System.out.println("Navn p� legemiddel: ");
								navn = scan.nextLine();
								
								
								System.out.println("Pris: ");
								double pris = scan.nextDouble();
								//pris = scan.nextDouble();
								
								
								System.out.println("Virkestoff: ");
								double virkestoff = scan.nextDouble();
								//virkestoff = scan.nextInt();
								
								System.out.println("Styrke, narkotisk: ");
								int styrke = scan.nextInt();
								
								NarkotiskLegemiddel narkotiskLegemiddel = new NarkotiskLegemiddel(navn, pris, virkestoff, styrke);
								system.hentListeLegemidler().leggTilForan(narkotiskLegemiddel);
								System.out.println("Legemiddel lagt til.");
							}
						}
					}
				}
				System.out.println(" ");
				System.out.println(hovedmeny);
				input = scan.nextInt();
			}
			
			else if(input == 3) {
				
				while(input != 0) {
					System.out.println("Velg Pasient");
					int i = 0;
					while(i < system.hentListePasienter().stoerrelse()) {
						System.out.println((i+1) + ": " + system.hentListePasienter().hent(i).hentNavn() + " fnr: " + system.hentListePasienter().hent(i).hentFoedselsnummer());
						i++;
					}
					System.out.println("0: Avslutt");
					
					
					input = scan.nextInt();
					Pasient pasient = null;
					pasient = system.hentListePasienter().hent(input-1);
					
					if(pasient.hentResepter().stoerrelse() == 0){
						System.out.println("Denne pasienten har ingen resepter.");
					}
					int u = 0;
					System.out.println("Hvilken resept vil du bruke?\n");
					while(u < pasient.hentResepter().stoerrelse()) {
						
						System.out.println((u+1) + ":" + pasient.hentResepter().hent(u).hentLegemiddel().hentNavn() + " " + pasient.hentResepter().hent(u).hentReit() + " reit");
						u++;
					}
					System.out.println("0: Avslutt");
					
					input = scan.nextInt();
					if (pasient.hentResepter().hent(input-1).bruk()) {
						System.out.println("Brukte resept paa" + pasient.hentResepter().hent(input-1).hentLegemiddel().hentNavn() + ". Gjenværende reit: " + pasient.hentResepter().hent(input-1).hentReit());
						break;
					} else {
						System.out.println("Denne resepten er brukt opp! ");
						break;
					}
				}
				System.out.println(" ");
				System.out.println(hovedmeny);
				input = scan.nextInt();
			}
			if (input == 4) {
				while (input != 0) {
					System.out.println("1: Antall utskrevne vanedannende legemidler\n2: Antall utskrevne narkotiske legemidler\n3: Mulig misbruk av narkotika\n0: Avslutt");
					input = scan.nextInt();
					if (input == 1) {
						int p = 0;
						int antVane = 0;
						while(p < system.hentListeResepter().stoerrelse()) {
							if(system.hentListeResepter().hent(p).hentLegemiddel().hentType().equals("Vanedannende")) {
								antVane++;
							}
							p++;
						}
						System.out.println("Totatl antall utskrevne vanedannende legemidler: " + antVane);
						System.out.println("0: Avslutt");
						input = scan.nextInt();
					if (input == 0) {
						break;
					}
					}
					if (input == 2) {
						int p = 0;
						int antVane = 0;
						while(p < system.hentListeResepter().stoerrelse()) {
							if(system.hentListeResepter().hent(p).hentLegemiddel().hentType().equals("Narkotisk")) {
								antVane++;
							}
							p++;
						}
						System.out.println("Totatl antall utskrevne narkotiske legemidler: " + antVane);
						System.out.println("0: Avslutt");
						input = scan.nextInt();
					if (input == 0) {
						break;
					}
					}
					if (input == 3) {
						System.out.println("1: Leger:\n2: Pasienter: ");
						input = scan.nextInt();
						if (input == 1) {
							int i = 0;
							
							while(i < system.hentListeLeger().stoerrelse()) {
								int totAnt = 0;
								int l = 0;
								while (l < system.hentListeLeger().hent(i).hentListeResepter().stoerrelse()) {
									if(system.hentListeLeger().hent(l).hentListeResepter().hent(l).hentLegemiddel().hentType().equals("Narkotisk")) {
										totAnt++;
						
									}
									l++;
								}
									System.out.println(system.hentListeLeger().hent(i).hentNavnLege() + " har skrevet ut: " + totAnt);
								
								i++;
							}
				
						}
						else if(input == 2) {
							break;
						}
						else {break;}
					}
				}
			}
			System.out.println(" ");
			System.out.println(hovedmeny);
			input = scan.nextInt();
		}	
	}
}
