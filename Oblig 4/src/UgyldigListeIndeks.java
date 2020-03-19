
class UgyldigListeIndeks extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 7647387214777143818L;

	UgyldigListeIndeks(int indeks){
        super("Ugyldig indeks:" + indeks);
    }
}