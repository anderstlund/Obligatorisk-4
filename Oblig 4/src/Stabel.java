class Stabel<T> extends Lenkeliste<T>{

  public void leggPaa(T x){
    int pos = super.stoerrelse();

    super.leggTil(pos, x); //kaller på metoden fra Lenkeliste 
  }

  public T taAv(){
    int pos = super.stoerrelse()-1;
    return super.fjern(pos);
  }
}


