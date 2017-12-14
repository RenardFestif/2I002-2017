public class Avant{
	private PieceA a1;
	private PieceA a2;
	private PieceB b1;

	public Avant(PieceA a1, PieceA a2, PieceB b1){
		this.a1 = a1;
		this.a2 = a2;
		this.b1 = b1;
	}

	public String toString(){
		return "Partie avant : "+ a1.toString()+ " et "+a2.toString()+" et "+b1.toString();
	}
    
    public Avant clone (){
      	Avant copie = new Avant(a1.clone(), a2.clone(), b1.clone());
        return copie;
    }
}