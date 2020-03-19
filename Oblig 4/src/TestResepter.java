
public abstract class TestResepter {

	public static void main(String[] args) {
		
	// TODO Auto-generated method stub
			System.out.println("Hei");
			VanligLegemiddel legemiddel = new VanligLegemiddel("Paracetamol ", 70, 500);
			System.out.println(legemiddel.toString());
			NarkotiskLegemiddel legemiddel2 = new NarkotiskLegemiddel("Morfin ", 500, 70, 9);
			System.out.println(legemiddel2.toString());
			Lege testLege = new Lege("Anders Lund");
			
			
			testVanligLegemiddel(legemiddel);
			testNarkotiskLegemiddel(legemiddel2);
			//HvitResept resept = new HvitResept(legemiddel, "Lund", 10, 2);
			testHvitResept(legemiddel, testLege);
			testHvitResept(legemiddel, testLege);
			testBlaaResept(legemiddel2, testLege);
			//System.out.println(resept.toString());
			
		}
		
		public static void testVanligLegemiddel(Legemiddel pLegemiddel) {
			System.out.println("Registrert legemiddel med navn:" + pLegemiddel.hentNavn() + pLegemiddel.hentPris());
		//	pLegemiddel.settNyPris(45);
			//System.out.println("Ny pris: " + pLegemiddel.hentPris());
		}
		
		public static void testNarkotiskLegemiddel(Legemiddel pLegemiddel) {
			System.out.println("Registrert legemiddel med navn:" + pLegemiddel.hentNavn());
		}
		
		public static void testHvitResept(Legemiddel pLegemiddel, Lege pLege) {
			HvitResept resept = new HvitResept(pLegemiddel, pLege, 10, 2);
			System.out.println("Test HvitResept");
			System.out.println(resept.toString());
			
		}
		
		public static void testBlaaResept(Legemiddel pLegemiddel, Lege pLege) {
			BlaaResept resept = new BlaaResept(pLegemiddel, pLege, 10, 2);
			System.out.println("Test BlaaResept");
			System.out.println(resept.toString());
			
		}
	}

