
public class Test {
	public static void main(String[] args) {
		Lege drLund = new Lege("Dr. Lund");
		VanligLegemiddel vLegemiddel = new VanligLegemiddel("Hasj", 420, 8);
		NarkotiskLegemiddel nLegemiddel = new NarkotiskLegemiddel("Narkooootika", 1000, 6.9, 69);
		Pasient pasient0 = new Pasient("Dabfrid", "42069");
		
		drLund.skrivBlaaResept(vLegemiddel, pasient0, 9);
		
		
	}
}
