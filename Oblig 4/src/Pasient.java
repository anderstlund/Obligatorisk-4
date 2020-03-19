
public class Pasient {
	
	public String navn;
	public String foedselsnummer;
	public int unikId;
	//public Stabel<Resept> stabelResepeter;
	
	public Pasient(String navn, String foedselsnummer, int unikId) {
		this.navn = navn;
		this.foedselsnummer = foedselsnummer;
		this.unikId = unikId;
		Stabel<Resept> stabelResepeter = new Stabel<Resept>();
	}
	
	public void leggTilResept() {
		
	}
	

}
