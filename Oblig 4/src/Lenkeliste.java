import java.util.Iterator;

public class Lenkeliste<T> implements Liste<T> {
	class Node {
		Node neste = null; //lager .neste
		T data;
		Node(T x){
			data = x; 
		}
	}
	public Node start = null; //lager start
	
	@Override
	public T hent(int pos) throws UgyldigListeIndeks { //henter ut et element
		
		if (pos < 0) { //sjekker for ugyldig indeks
			throw new UgyldigListeIndeks(pos);
		}
		try {
			
			Node temp = start; //lager en midlertidig node
		
			for(int i = 0; i < pos; i++) { //gaar gjennom listen til i = pos
				temp = temp.neste;
			}
			
			return temp.data;
		}
		catch (RuntimeException e) {
			throw new UgyldigListeIndeks(pos);
		}
	}
	
	@Override
	public void leggTil(int pos, T x) throws UgyldigListeIndeks { //legger til en ny node paa gitt pos, og skyver neste node i listen bakover
	
		if (pos < 0 ) { //sjekker for ugyldig indeks
			throw new UgyldigListeIndeks(pos);
		}
			
		try{
			Node nyNode = new Node(x); //lager ny node
			Node temp = start;
			
			
			for(int i = 0; i < pos - 1; i++) { //gaar gjennom listen til i = pos
				temp = temp.neste;
			}
			if(pos == 0) {
				leggTilForan(x); //Hvis posisjonen hvor ny node skal legges til er 0, kan vi kalle p� leggTilForan()
			}
			else { 
				nyNode.neste = temp.neste; //Setter ny node paa riktig posisjon, og skyver neste element bakover i listen
				temp.neste = nyNode;
			}
			
		}
		catch (RuntimeException e){
			throw new UgyldigListeIndeks(pos);
		}
	}
	
	public void leggTilForan(T x) { //Legger til en ny node foran i listen
		Node nyNode = new Node(x);
		if (start == null) { //Hvis listen er tom, setter start til nyNode
			start = nyNode;
		}
		else {
			nyNode.neste = start; //Setter nyNode til start, skyver neste element bakover i listen
			start = nyNode;
		}
	}
	@Override
	public void sett(int pos, T x) throws UgyldigListeIndeks { //Setter inn en ny node paa en gitt posisjon, og overskriver det som var der fra foer
		//System.out.println("Metoden sett med posisjon: " + pos + " " + toString());
		
			
		if (pos < 0 ) {
			throw new UgyldigListeIndeks(pos);	
		}
		
		try {
			
			Node nyNode = new Node(x);
			Node temp = start;
			if (pos <= stoerrelse()) {
				for(int i = 0; i < pos - 1; i++) { //Gaar gjennom listen
					temp = temp.neste;
				}
				if (pos == 0 ) { //Eget tilfelle hvor pos = 0
					nyNode.neste = start.neste;
					start = nyNode;
				}
				else {
					nyNode.neste = temp.neste.neste;
					temp.neste = nyNode;
				}
			}
		}
		catch (RuntimeException e){
			throw new UgyldigListeIndeks(pos);
		}
		//System.out.println("Liste etter sett: " + pos + " " + toString());
	}
	
	@Override
	public String toString() throws UgyldigListeIndeks { //toString, brukt for aa teste kode
		
		String returnString = "Lenkeliste: ";
		Node temp = start;
		while(temp.neste != null) {
			returnString += temp.data.toString() + ", ";
			temp = temp.neste;
		}
		
		return returnString;
	}

	@Override
	public int stoerrelse() throws UgyldigListeIndeks { //sjekker stoerrelsen p� lista
		
		try {
			int i = 0;
			Node temp = start;
			while(temp != null) { //Gaar gjennom lista
				temp = temp.neste;
				i++; //Indeks som oeker med en for hvert element while-loekken finner.
			}
			
			
			return i;
		}
		catch (NullPointerException e){
			throw new UgyldigListeIndeks(0);
		}
	}

	@Override
	public void leggTil(T x) throws UgyldigListeIndeks { //Setter inn et element paa slutten av listen
		
		try {
			Node nyNode = new Node(x);
			if (start == null) {
				start = nyNode;
			}
			else {
				Node temp = start;
				while(temp.neste != null) {
					temp = temp.neste;
				}
				temp.neste = nyNode;
			}	
		}
		catch (RuntimeException e){
			throw new UgyldigListeIndeks(0);
		}
	}

	@Override
	public T fjern(int pos) throws UgyldigListeIndeks{ //fjerner node paa gitt posisjon
		
			
		if (pos < 0) {
			throw new UgyldigListeIndeks(pos);
		}
		
		try {
			
			Node temp = start;
			Node returnNode = start;
		
			for(int i = 0; i < pos-1; i++) {
				temp = temp.neste;
			}
			
			if (pos == 0) {
				start = temp.neste;
				returnNode = temp;
			}
			else {
				returnNode = temp.neste;
				temp.neste = returnNode.neste;
			}
			
			return returnNode.data;
			
		}
		catch (RuntimeException e) {
			throw new UgyldigListeIndeks(pos);
		}
	}

	@Override
	public T fjern() throws UgyldigListeIndeks { //fjerner elementet paa starten av listen
		try {
			Node temp = start;
			start = temp.neste;
			return temp.data;	
		} catch (NullPointerException e) {
			throw new UgyldigListeIndeks(0);
		}
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		LenkelisteIterator<T> lenkeIterator = new LenkelisteIterator<T>();
		return lenkeIterator;
	}
}
