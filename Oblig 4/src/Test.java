
public class Test {
	public static void main(String[] args) throws UlovligUtskrift {
		Lege drLund = new Lege("Dr. Lund");
		VanligLegemiddel vLegemiddel = new VanligLegemiddel("Hasj", 420, 8);
		NarkotiskLegemiddel nLegemiddel = new NarkotiskLegemiddel("Narkooootika", 1000, 6.9, 69);
		Pasient pasient0 = new Pasient("Dabfrid", "42069");
		Spesialist drHermann = new Spesialist("Dr. Hermann", 123456789);
		Pasient pasient1 = new Pasient("Skrtveig", "123321");
		System.out.println(pasient1);
		System.out.println(pasient0);
		System.out.println(vLegemiddel);
		System.out.println(nLegemiddel);
		
		drHermann.skrivMillitaerResept(nLegemiddel, pasient0, 0);
		drHermann.skrivMillitaerResept(nLegemiddel, pasient0, 80);
		drLund.skrivBlaaResept(vLegemiddel, pasient0, 9);
		//drLund.skrivMillitaerResept(nLegemiddel, pasient0, 69);
		drLund.skrivHvitResept(vLegemiddel, pasient1, 3);
		drLund.skrivPResept(vLegemiddel, pasient0);
		
		System.out.println(drHermann.hentListeResepter());
		
		System.out.println(drLund.hentListeResepter());
		
		Legesystem system = new Legesystem();
		system.lesFraFil("Testeks.txt");
		
		
	}
}
