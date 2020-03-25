import java.util.concurrent.atomic.AtomicInteger;

//package test1;
		
/*public class UnikId{
	int reseptId = 0;
	int legemiddelId = 0;
	int pasientId = 0;
	
	public UnikId(String )
}
*/

//Lager klassen legemiddel
abstract class Legemiddel{
	String navn;
	double pris;
	double virkemiddel;
	private int unikId = 0;
	private static int teller = 0;
	String legemiddelType;
	
	public Legemiddel(String pNavn, double pPris, double pVirkemiddel, String pLegemiddelType) {
		navn = pNavn;
		pris = pPris;
		virkemiddel = pVirkemiddel;
		unikId = unikId + teller;
		teller++;
		legemiddelType = pLegemiddelType;
	}
	
	public String hentNavn() {
		return navn;
	}
	
	public double hentPris() {
		return pris;
	}
	
	public double hentVirkemiddel() {
		return virkemiddel;
	}
	
	public double settNyPris(double nyPris) {
		return pris = nyPris;
	}
	
	public int hentId() { 
		return unikId;
	}
	
	public String hentType() {
		return legemiddelType;
	}
	
	public String toString() {
		String returnString;
		
		returnString = "\n********************\n";
		returnString += "Legemiddel: " + "\n";
		returnString += "Id: " + hentId() + "\n"; 
		returnString += "Navn: " + hentNavn() + "\n";
		returnString += "Virkemiddel: " + hentVirkemiddel() + "\n";
		returnString += "Type: " + hentType() + "\n";
		returnString += "Pris: " + hentPris() + "\n";
		
		
		return returnString;
	}
}
//Vanlig legemiddel, subklasse av legemiddel
class VanligLegemiddel extends Legemiddel{
	public VanligLegemiddel(String pNavn, double pPris, double pVirkemiddel) {
		super(pNavn, pPris, pVirkemiddel, "Vanlig");
	}
}
//Narkotisk legemiddel, subklasse av legemiddel
class NarkotiskLegemiddel extends Legemiddel{
	int styrke;
	public NarkotiskLegemiddel(String pNavn, double pPris, double pVirkemiddel, int pStyrke) {
		super(pNavn, pPris, pVirkemiddel, "Narkotisk");
		styrke = pStyrke;
	}
	
	public double hentNarkotiskStyrke() {
		return styrke;
	}
	
	public String toString() {
		String returnString = super.toString();
		
		returnString += "Narkotisk styrke: " + hentNarkotiskStyrke();
		
		return returnString;
	}
}
//Vanedannende legemiddel, subklasse av legemiddel
class VanedannendeLegemiddel extends Legemiddel{
	int styrke;
	public VanedannendeLegemiddel(String pNavn, double pPris, double pVirkemiddel, int pStyrke) {
		super(pNavn, pPris, pVirkemiddel, "Vanedannende");
		styrke = pStyrke;
	}
	
	public double hentVanedannendeStyrke() {
		return styrke;
	}
	
	public String toString() {
		String returnString = super.toString();
		
		returnString += "Vanedannende styrke: " + hentVanedannendeStyrke();
		
		return returnString;
	}
}


//Lager klassen resept
abstract class Resept{
	Legemiddel legemiddel;
	Lege utskrivendeLege;
	Pasient pasient;
	int reit;
	private int unikId = 0;
	private static int teller = 0;
	String farge;
	boolean militaerResept = false;
	boolean pResept = false;
	
	public Resept(Legemiddel pLegemiddel, Lege pUtskrivendeLege, Pasient pPasient, int pReit, String pFarge) {
		legemiddel = pLegemiddel;
		utskrivendeLege = pUtskrivendeLege;
		pasient = pPasient;
		reit = pReit;	
		unikId = unikId + teller;
		teller++;
		farge = pFarge;
	}
	//Sjekker om resepten er brukt opp
	public boolean bruk() {
	if (reit == 0) {
		return false;
		}
	else {
		reit --;
		return true;
		}
	}
	
	public void settMilitaerResept() {
		militaerResept = true;
	}
	
	public boolean hentMilitaerResept() {
		return militaerResept;
	}
	
	public void settPResept() {
		pResept = true;
	}
	
	public boolean hentPResept() {
		return pResept;
	}
	
	public int hentId() {
		return unikId;
	}
	
	public String hentFarge() {
		return farge;
	}
	
	public Lege hentLege() {
		return utskrivendeLege;
	}
	
	public Pasient hentPasient() {
		return pasient;
	}
	public String toString() {
		String returnString = "\n********************\n";
		returnString += "Resept med farge: " + hentFarge() +"\n";
		if(hentMilitaerResept()) {
			returnString += "Type resept: Militaer resept \n";
		}
		
		if(hentPResept()) {
			returnString += "Type resept: P-Resept \n";
		}
		returnString += "Legemiddel: " + legemiddel.hentNavn() + "\n";
		returnString += "Utskrivende lege: " + utskrivendeLege.hentNavnLege() + "\n";
		returnString += "Pasient Id: " + hentPasient() + "\n"; //** denne er det noe feil med, må endres til hentPasient() ??
		returnString += "Reit: " + reit + "\n";
		returnString += "Pris � betale: " + prisAaBetale() + "\n";
															//legge til en toString som skriver unikId med hentId() istedenfor
		return returnString;
	}
	
	abstract public String farge();
	abstract public double prisAaBetale();
}


//Hvit resept, subklasse av resept
class HvitResept extends Resept {
	public HvitResept(Legemiddel pLegemiddel, Lege pUtskrivendeLege, Pasient pPasient, int pReit) {
		super(pLegemiddel, pUtskrivendeLege, pPasient, pReit, "Hvit");
	}
	
	public String farge() {
		return hentFarge();
	}
	
	public double prisAaBetale() {
		return legemiddel.hentPris();
	}
}
//Militaer resept, subklasse av hvit resept
class MilitaerResept extends HvitResept {
	int rabatt = 100;
	
	public MilitaerResept(Legemiddel pLegemiddel, Lege pUtskrivendeLege, Pasient pPasient, int pReit) {
		super(pLegemiddel, pUtskrivendeLege, pPasient, pReit);
		settMilitaerResept();
	}
	
	public double prisAaBetale() {
		return (100 - rabatt)*legemiddel.hentPris()/100;
	}
}
//P-Resept, subklasse av hvit resept
class PResept extends HvitResept {
	int rabatt = 108;
	
	public PResept(Legemiddel pLegemiddel, Lege pUtskrivendeLege, Pasient pPasient, int pReit) {
		super(pLegemiddel, pUtskrivendeLege, pPasient, 3);
		settPResept();
	}
	
	public double prisAaBetale() {
		double vPris = legemiddel.hentPris() - rabatt;
		
		if(vPris < 0) {
			vPris = 0;
		}
		return vPris;
	}
}
//Blaa resept, subklasse av resept
class BlaaResept extends Resept {
	int rabatt = 75;
	
	//Constructor for BlaaResept.
	public BlaaResept(Legemiddel pLegemiddel, Lege pUtskrivendeLege, Pasient pPasient, int pReit) {
		super(pLegemiddel, pUtskrivendeLege, pPasient, pReit, "Blaa");
	}
	
	public String farge() {
		return hentFarge();
	}
	
	public double prisAaBetale() {
		return ((100-rabatt)*legemiddel.hentPris())/100;
	}
}
//Lager klassen lege
class Lege implements Comparable<Lege>{
	String navn;
	public Lenkeliste<Resept> utskrevedeResepter;
	
	public Lege(String pNavn) {
		navn = pNavn;
		utskrevedeResepter = new Lenkeliste<Resept>();
	}
	
	public String hentNavnLege() {
		return navn;
	}
	
	public String toString() {
		String returnString = "\n********************\n";
		returnString += "Navn paa lege: " + hentNavnLege() + "\n";
		
		return returnString;
	}
	
	@Override
	public int compareTo(Lege other) {
		int sjekkTall = this.navn.compareTo(other.hentNavnLege());
		if (sjekkTall < 0) return -1;
		if (sjekkTall > 0) return 1;
		return 0;
		
	}
	
	public Lenkeliste<Resept> hentListeResepter(){
		return utskrevedeResepter;
	}
	
	//burde kommentere litt her
	public HvitResept skrivHvitResept(Legemiddel pLegemiddel, Pasient pPasient, int pReit) throws UlovligUtskrift{
			if (pLegemiddel instanceof NarkotiskLegemiddel) {
				throw new UlovligUtskrift(this, pLegemiddel);
			}
			try {
				HvitResept resept = new HvitResept(pLegemiddel, this, pPasient, pReit);
				utskrevedeResepter.leggTilForan(resept);
				return resept;
			}
			catch (Exception e){
				throw new UlovligUtskrift(this, pLegemiddel);
			}
	}
	
	public MilitaerResept skrivMillitaerResept(Legemiddel pLegemiddel, Pasient pPasient, int pReit) throws UlovligUtskrift{
		if (pLegemiddel instanceof NarkotiskLegemiddel) {
			throw new UlovligUtskrift(this, pLegemiddel);
		}
		try {
			MilitaerResept resept = new MilitaerResept(pLegemiddel, this, pPasient, pReit);
			utskrevedeResepter.leggTilForan(resept);
			return resept;
		}
		catch (Exception e){
			throw new UlovligUtskrift(this, pLegemiddel);
		}
	}
	
	public PResept skrivPResept(Legemiddel pLegemiddel, Pasient pPasient) throws UlovligUtskrift{
		if (pLegemiddel instanceof NarkotiskLegemiddel) {
			throw new UlovligUtskrift(this, pLegemiddel);
		}
		try {
			PResept resept = new PResept(pLegemiddel, this, pPasient, 3);
			utskrevedeResepter.leggTilForan(resept);
			return resept;
		}
		catch (Exception e){
			throw new UlovligUtskrift(this, pLegemiddel);
		}
	}
	
	public BlaaResept skrivBlaaResept(Legemiddel pLegemiddel, Pasient pPasient, int pReit) throws UlovligUtskrift{
		if (pLegemiddel instanceof NarkotiskLegemiddel) {
			throw new UlovligUtskrift(this, pLegemiddel);
		}
		try {
			BlaaResept resept = new BlaaResept(pLegemiddel, this, pPasient, pReit);
			utskrevedeResepter.leggTilForan(resept);
			return resept;
		}
		catch (Exception e){
			throw new UlovligUtskrift(this, pLegemiddel);
		}
	}
}
//Subklasse av klassen lege
class Spesialist extends Lege implements Godkjenningsfritak { //Tar i bruk interface godkjenningsfritak
	int kontrollId;
	
	public Spesialist(String pNavn, int pKontrollId) {
		super(pNavn);
		kontrollId = pKontrollId;
	}

	@Override
	public int hentKontrollId() {
		
		return kontrollId;
	}
	
	public String toString() {
		String returnString = "\n********************\n";
		returnString += "Navn paa lege: " + hentNavnLege() + "\n";
		returnString += "KontrollId: " + hentKontrollId() + "\n";
		
		return returnString;
	}
	
	@Override
	public HvitResept skrivHvitResept(Legemiddel pLegemiddel, Pasient pPasient, int pReit) throws UlovligUtskrift{
		try {
			HvitResept resept = new HvitResept(pLegemiddel, this, pPasient, pReit);
			utskrevedeResepter.leggTilForan(resept);
			return resept;
		}
		catch (Exception e){
			throw new UlovligUtskrift(this, pLegemiddel);
		}
	}
	
	@Override
	public MilitaerResept skrivMillitaerResept(Legemiddel pLegemiddel, Pasient pPasient, int pReit) throws UlovligUtskrift{
		try {
			MilitaerResept resept = new MilitaerResept(pLegemiddel, this, pPasient, pReit);
			utskrevedeResepter.leggTilForan(resept);
			return resept;
		}
		catch (Exception e){
			throw new UlovligUtskrift(this, pLegemiddel);
		}
	}
	@Override
	public PResept skrivPResept(Legemiddel pLegemiddel, Pasient pPasient) throws UlovligUtskrift{
		try {
			PResept resept = new PResept(pLegemiddel, this, pPasient, 3);
			utskrevedeResepter.leggTilForan(resept);
			return resept;
		}
		catch (Exception e){
			throw new UlovligUtskrift(this, pLegemiddel);
		}
	}
	@Override
	public BlaaResept skrivBlaaResept(Legemiddel pLegemiddel, Pasient pPasient, int pReit) throws UlovligUtskrift{
		try {
			BlaaResept resept = new BlaaResept(pLegemiddel, this, pPasient, pReit);
			utskrevedeResepter.leggTilForan(resept);
			return resept;
		}
		catch (Exception e){
			throw new UlovligUtskrift(this, pLegemiddel);
		}
	}
}


