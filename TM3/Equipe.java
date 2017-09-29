public class Equipe {
    private String nom;
    private Villageois [] tab = new Villageois[20];
    private int nb;

    public Equipe(String nom){
	this.nom = nom;
	this.nb = 0;
    }

    public void embaucher (Villageois v){
	tab[nb] = v;
	nb++;
    }

    public double poidsSouleve(){
	double poidTotal = 0;

	for (int i=0; i<nb; i++){
	    poidTotal = poidTotal + tab[i].poidsSouleve();
	}

	return poidTotal;
    }

    public String toString(){
	String s = "L'equipe "+this.nom+" Contient les Villageois : \n";

	for (int i = 0; i<nb; i++){
	    s= s + tab[i].toString()+"\n";
	}

	s = s + "L'equipe souleve un poids total de  "+this.poidsSouleve()+"Kg";

	return s;
    }
}

	
