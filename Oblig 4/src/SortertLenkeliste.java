
public class SortertLenkeliste<T extends Comparable<T>> extends Lenkeliste<T>{
	
	public void leggTil(T x) throws UgyldigListeIndeks {
		
		int i = 0;
		boolean plassFunnet = false; 
		Node temp = start; //midlertidig node
		Node prev = start; //forrige node
		Node nyNode = new Node(x);
		//temp.data.compareTo(o)
		try {
			if(start == null) { //Hvis listen er tom, legg til foran
				leggTilForan(x);
			}
			else {
				if(start.data.compareTo(x) > 0) { //Hvis start.data sammenliknet med x er stoerre enn 0, betyr det at vi kan legge til foran
					leggTilForan(x);
				}
				else {
					while(temp.neste != null && !plassFunnet) { //saa lenge temp.neste ikke er null, plss ikke er funnet, skal while loekken gaa gjennom lista 
						prev = temp;
						temp = temp.neste;
						i++;
						
						if(temp.data.compareTo(x) > 0) { //Hvis temp.data sammenliknet med x er stoerre enn null, peker prev.neste på nyNode, og nyNode.neste på temp
							prev.neste = nyNode;
							nyNode.neste = temp;
							
							plassFunnet = true; //plass er funnet, plassFunnet settes til true
						}
					}
					if(!plassFunnet) {
						super.leggTil(x);
					}
				}
			}
		}
		catch (RuntimeException e) {
			throw new UgyldigListeIndeks(i);
		}
	}
	
	
	public T fjern() throws UgyldigListeIndeks{
		
		Node temp = start;
		int i = 0;
		try {
			
			
			if(start.neste == null) { //Fjerner eneste element i liste med ett element
				return super.fjern(i); //kaller paa metoden fjern fra lenkeliste, med indeks i som pos
			}
			else {
				while(temp.neste != null) { //gaar gjennom listen
					temp = temp.neste;
					i++;
				}
				return super.fjern(i);
			}
		}
		catch (RuntimeException e) {
			throw new UgyldigListeIndeks(i);
		}
	}
	
	public void sett(int pos, T x) {
		throw new UnsupportedOperationException();
	}
	
	public void leggTil(int pos, T x) {
		throw new UnsupportedOperationException();
	}
}


