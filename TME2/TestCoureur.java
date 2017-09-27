
public class TestCoureur {
	public static void main (String [] args ) {
		Coureur c1 = new Coureur();
		Coureur c2 = new Coureur();
		Coureur c3 = new Coureur();
		Coureur c4 = new Coureur();
		
		System.out.println(c1.toString());
		
		c2.setALeTemoin(false);
		System.out.println(c2.getAleTemoin());
		c2.setALeTemoin(true);
		System.out.println(c2.getAleTemoin());
		
		System.out.println(c3.getNuDossard());
		System.out.println(c4.getTempsAu100());
		
		c1.courir();
		c2.courir();
		c3.courir();
		c4.courir();
		
		double tempsTot = c1.getTempsAu100()+c2.getTempsAu100()+c3.getTempsAu100()+c4.getTempsAu100();
		
		System.out.println("Temps total relais :"+tempsTot);
		
	}

}
