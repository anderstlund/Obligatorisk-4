
public class Pasient {
	
	public String navn;
	public String fødselsnummer;
	public int unikId;
	//public Stabel<Resept> stabelResepeter;
	
	public Pasient(String navn, String fødselsnummer, int unikId) {
		this.navn = navn;
		this.fødselsnummer = fødselsnummer;
		this.unikId = unikId;
		Stabel<Resept> stabelResepeter = new Stabel<Resept>();
	}
	
	public void leggTilResept() {
		
	}
	

}
