public class Tracteur{

    private Roue rav1, rav2, rar1, rar2;
    private Cabine cab;

    public Tracteur(Roue rav1, Roue rav2, Roue rar1, Roue rar2, Cabine cab){

	this.rav1 = rav1;
	this.rav2 = rav2;
	this.rar1 = rar1;
	this.rar2 = rar2;
	this.cab = cab;

    }

    public String toString(){

	return " Tracteur avec "+cab.toString()+" Et "+rav1.toString()+rav2.toString()+rar1.toString()+rar2.toString();
    }

    public void peindre (String c){
	cab.setCouleur(c);
    }
}

    
