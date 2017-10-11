public class TestMachine{
	public static void main(String[] args){
		PieceA a1 = new PieceA(113);
		PieceA a2 = new PieceA(225, "Carbone");
		PieceA a3 = new PieceA(003, "Mousse");
		PieceB b1 = new PieceB(554, 21.5);
		PieceC c1 = new PieceC(999, true);

		Avant av = new Avant(a1, a2, b1);
		Arriere ar = new Arriere(a3, c1);

		Machine m = new Machine("Blouge", av, ar);
		System.out.println(m.toString()+"\n\n\n");


		Machine m2 = m;
		b1.setLongueur(7.0);
		m2.setCouleur("Rawse");
		System.out.println(m2.toString()+"\n\n\n");
		System.out.println(m.toString()+"\n\n\n");


		
		Machine m3 = m2.clone();
		b1.setLongueur(546.0);
		m3.setCouleur("Orenj");
		System.out.println(m2.toString()+"\n\n\n");
		System.out.println(m3.toString()+"\n\n\n");



	}
}