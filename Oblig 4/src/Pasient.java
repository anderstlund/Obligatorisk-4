import java.util.concurrent.atomic.AtomicInteger;

public class Pasient {
	
	private static final AtomicInteger id = new AtomicInteger(0);
	public String navn;
	public String foedselsnummer;
	public int unikId;
	public Stabel<Resept> stabelResepter;
	
	public Pasient(String navn, String foedselsnummer, int unikId) {
		this.navn = navn;
		this.foedselsnummer = foedselsnummer;
		this.unikId = id.getAndIncrement();
		stabelResepter = new Stabel<Resept>();
	}
	
	public void leggTilResept(Resept x) {
		stabelResepter.leggPaa(x);
	}
	
	public Stabel<Resept> hentResepter() {
		return stabelResepter;
	}
	
	//public Resept brukResept() {
	//	stabelResepter.taAv();
	//}
	
	@Override
	public String toString() {
		return "Navn: " + navn + " . Foedselsnummer: " + foedselsnummer + " . Unik id: " + unikId;
	}
	
}
