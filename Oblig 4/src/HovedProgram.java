
public class HovedProgram {

	public static void main(String[] args) {
		
		Lege nyLege = new Lege("Dangfart Tønnesen"); //Oppretter en lege
		Spesialist spesialist = new Spesialist("Knut Knudsen", 2); //Oppretter spesialist
		//toString: skriver ut
		System.out.println(nyLege.toString());
		System.out.println(spesialist.toString());
		
		//Legemidler:
		VanligLegemiddel vanligLegemiddel = new VanligLegemiddel("Paracetamol", 70.50, 500); //Oppretter vanlig legemiddel
		NarkotiskLegemiddel narkotiskLegemiddel = new NarkotiskLegemiddel("Morfin", 638.90, 15.0, 9); //Oppretter narkotisk legemiddel
		VanedannendeLegemiddel vanedannendeLegemiddel = new VanedannendeLegemiddel("Nesespray", 35.50, 20, 6); //Oppretter vanedannende Legemiddel
		VanligLegemiddel vanligLegemiddel1 = new VanligLegemiddel("Prevensjon", 112.50, 500);//For pResept
		//toString: skriver ut
		System.out.println(vanligLegemiddel.toString());
		System.out.println(narkotiskLegemiddel.toString());
		System.out.println(vanedannendeLegemiddel.toString());
		System.out.println(vanligLegemiddel1.toString());
		
		//Resept:
		HvitResept hvitResept = new HvitResept(vanligLegemiddel, nyLege, 1, 1);//Oppretter hvit resept med paracetamol som legemiddel, og Dangfart Tønnesen som lege
		MilitaerResept militaerResept = new MilitaerResept(narkotiskLegemiddel, nyLege, 2, 5);
		PResept pResept = new PResept(vanligLegemiddel1, nyLege, 3, 1);
		BlaaResept blaaResept = new BlaaResept(narkotiskLegemiddel, nyLege, 4, 3);
		//toString: skriver ut
		System.out.println(hvitResept.toString());
		System.out.println(militaerResept.toString());
		System.out.println(pResept.toString());
		System.out.println(blaaResept.toString());
		
	}

}
