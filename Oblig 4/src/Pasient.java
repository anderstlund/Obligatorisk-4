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
		Stabel stabelResepter = new Stabel<Resept>();
	}
	
	public void leggTilResept(Resept x) {
		stabelResepter.leggPaa(x);
	}
	
	public Stabel<Resept> hentResepter() {
		return stabelResepter;
		this.unikId = unikId;
		Stabel stabelResepter = new Stabel<Resept>();
		this.unikId = unikId;
		Stabel stabelResepter = new Stabel<Resept>();
	}
	
	public void leggTilResept() {
		
	}
	

}
