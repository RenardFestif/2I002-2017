public class Machine{
	private String couleur;
	private Avant pavant;
	private Arriere parriere;
	public Machine(String couleur, Avant pavant, Arriere parriere){
		this.couleur = couleur;
		this.pavant = pavant;
		this.parriere = parriere;
	}
	public String toString(){
		return "Machine a schtroumpfer de couleur "+couleur+
				"\navec partie avant :\n "+pavant.toString()+
				"\net partir arriere \n"+parriere.toString();
	}

	public void setCouleur (String c){
		this.couleur = c;

	}

    public Machine clone (){
		Machine copie = new Machine(this.couleur, pavant.clone(), parriere.clone());
    	return copie;
	}

}