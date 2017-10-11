public class Arriere{
	private PieceA a1;
	private PieceC c1;

	public Arriere(PieceA a1, PieceC c1){
		this.a1 = a1;
		this.c1 = c1;
	}

	public String toString(){
		return "Partie arriere : "+ a1.toString()+ " et "+c1.toString();
	}
    public Arriere clone (){
    	Arriere copie = new Arriere(a1.clone(), c1.clone());
		return copie;
	}
}