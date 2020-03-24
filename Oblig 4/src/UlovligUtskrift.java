
public class UlovligUtskrift extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	UlovligUtskrift(Lege l, Legemiddel lm){
		super("Legen " + l.hentNavnLege() + " har ikke lov til å skrive ut " + lm.hentNavn());
	}

}
