import java.util.Iterator;

public class Lenkeliste<T> implements Liste<T> {
	class Node {
		Node neste = null;
		T data;
		Node(T x){
			data = x;
		}
	}
	private Node start = null;
	
	@Override
	public T hent(int pos) {
		//Får inn en verdi fra pos, bruker denne verdien i en for-løkke. 
		//Denne for-løkken bruker neste for å hoppe til riktig node. 
		//F.eks. kan for-løkken ha en indeks på 3, da sørger for-løkken for at neste hopper over to noder, til posisjon tre. Henter data ut fra denne posisjonen.
		if (pos > stoerrelse()) {
			return null;
		}
		else {
			Node temp = start;
		
			for(int i = 0; i < pos; i++) {
				temp = temp.neste;
			}
			
			return temp.data;
		}
	}
	
	@Override
	public void leggTil(int pos, T x) {
		Node nyNode = new Node(x);
		Node temp = start;
		if (pos <= stoerrelse()) {
			for(int i = 0; i < pos - 1; i++) {
				temp = temp.neste;
			}
			if(pos == 0) {
				leggTilForan(x);
			}
			else {
				nyNode.neste = temp.neste;
				temp.neste = nyNode;
			}
		}
	}
	
	public void leggTilForan(T x) {
		Node nyNode = new Node(x);
		if (start == null) {
			start = nyNode;
		}
		else {
			nyNode.neste = start;
			start = nyNode;
		}
	}
	@Override
	public void sett(int pos, T x) {
		Node nyNode = new Node(x);
		Node temp = start;
		if (pos <= stoerrelse()) {
			for(int i = 0; i < pos - 1; i++) {
				temp = temp.neste;
			}
			if (pos == 0 ) {
				leggTilForan(x);
			}
			else {
				nyNode = temp.neste;
				temp.neste = nyNode;
				
			}
		}
		
	}

	@Override
	public int stoerrelse() {
		// TODO Auto-generated method stub
		int i = 0;
		Node temp = start;
		while(temp != null) {
			temp = temp.neste;
			i++;
		}
		
		
		return i;
	}

	@Override
	public void leggTil(T x) {
		// TODO Auto-generated method stub
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

	@Override
	public T fjern(int pos) {	
		if (pos < 1 || pos > stoerrelse()) {
			return null;
		}
		else {
			Node current = start;
		
			for(int i = 0; i < pos; i++) {
				current = current.neste;
			}
			current = current.neste;
			return current.data;
		}
	}

	@Override
	public T fjern() {
		Node temp = start;
		temp = temp.neste;
		return temp.data;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
