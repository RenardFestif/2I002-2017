public class TestHisto{
	public static void main(String [] args){
		int [] tab = new int[150];

		for(int i=0;i<tab.length;i++){
			tab[i] = (int)(Math.random()*20);
		}
		Histo h = new Histo(tab);
		h.afficheHistogramme();
		System.out.println();
		h.afficheHistogrammeTableau();
	}
}