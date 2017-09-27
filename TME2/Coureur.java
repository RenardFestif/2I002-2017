
public class Coureur {
	private int nuDossard;
	private double tempsAu100;
	private boolean aLeTemoin;
	
	public Coureur() {
		this((int) (Math.random()*1000+1));

	}

	public Coureur(int nuDossard) {
		this.nuDossard = nuDossard;
		this.tempsAu100 = Math.random()*4+12;
		this.aLeTemoin = false;
	}
	
	public int getNuDossard() {
		return nuDossard;
	}
	
	public double getTempsAu100() {
		return tempsAu100;
	}
	
	public boolean getAleTemoin() {
		return aLeTemoin;
	}
	
	public void setALeTemoin(boolean b) {
		this.aLeTemoin=b;
	}
	
	public String toString() {
		String s ="Coureur : "+nuDossard+"\nTemps au 100 : "+tempsAu100+"\nA Le dossard : "+aLeTemoin;
		return s;
	}
	
	public void passeTemoin(Coureur c) {
		System.out.println("Moi, coureur "+this.nuDossard+", je passe le temoin au coureur "+c.nuDossard);
		this.aLeTemoin=false;
		c.setALeTemoin(true);				
	}
	
	public void courir() {
		System.out.println("je suis le coureur "+this.nuDossard+ " Et je cours");
	}
	
	
	

}
