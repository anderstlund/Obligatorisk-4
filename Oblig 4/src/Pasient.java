public class Pasient {
	
	public String navn;
	public String foedselsnummer;
	private int unikIid = 0;
	private static int teller = 0;
	public Stabel<Resept> stabelResepter;
	
	public Pasient(String navn, String foedselsnummer) {
		this.navn = navn;
		this.foedselsnummer = foedselsnummer;
		unikIid = unikIid + teller;
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
		return unikIid;
	}
	
	//public Resept brukResept() {
	//	stabelResepter.taAv();
	//}
	
	@Override
	public String toString() {
		return "Navn: " + navn + " . Foedselsnummer: " + foedselsnummer + " . Unik id: " + hentIid();
	}
	
}
