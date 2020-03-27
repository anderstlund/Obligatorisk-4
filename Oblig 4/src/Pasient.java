public class Pasient{
	
	public String navn;
	public String foedselsnummer;
	private int unikId = 0;
	private static int teller = 0;
	public Stabel<Resept> stabelResepter;
	
	public Pasient(String navn, String foedselsnummer) {
		this.navn = navn;
		this.foedselsnummer = foedselsnummer;
		unikId = unikId + teller;
		teller++;
		stabelResepter = new Stabel<Resept>();
	}
	
	public void leggTilResept(Resept x) {
		stabelResepter.leggPaa(x);
	}
	
	public Stabel<Resept> hentResepter() {
		return stabelResepter;
	}
	
	public String hentNavn() {
		return this.navn;
	}
	
	public String hentFoedselsnummer() {
		return this.foedselsnummer;
	}
	
	public int hentIid() {
		return unikId;
	}
	
	//public Resept brukResept() {
	//	stabelResepter.taAv();
	//}
	
	@Override
	public String toString() {
		String returnString = "";
	
			returnString = hentNavn() + "\n";
			returnString += "Foedselsnummer: " + hentFoedselsnummer() + "\n";
			returnString += "Unik Pasient Id: " + hentIid() + "\n";
			returnString += "\n";

			return returnString;
	}
	
}
