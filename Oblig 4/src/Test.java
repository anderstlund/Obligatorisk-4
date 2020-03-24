
public class Test {
	public static void main(String[] args) throws UlovligUtskrift {
		Lege drLund = new Lege("Dr. Lund");
		VanligLegemiddel vLegemiddel = new VanligLegemiddel("Hasj", 420, 8);
		NarkotiskLegemiddel nLegemiddel = new NarkotiskLegemiddel("Narkooootika", 1000, 6.9, 69);
		Pasient pasient0 = new Pasient("Dabfrid", "42069");
		Spesialist drHermann = new Spesialist("Dr. Hermann", 123456789);
		
		drHermann.skrivMillitaerResept(nLegemiddel, pasient0, 0);
		drLund.skrivBlaaResept(vLegemiddel, pasient0, 9);
		drLund.skrivHvitResept(vLegemiddel, pasient0, 3);
		drLund.skrivPResept(vLegemiddel, pasient0);
		
		System.out.println(drLund.hentListeResepter());
		
	}
}
