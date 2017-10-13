public class Solveur{
    private int PlateauJeu jeu;

    public Solveur ( Piece [] p ){
	this.jeu = new PlateauJeu(p);
    }

    public PlateauJeu resoudre(){
	int err = jeu.compterErreur();
	PlateauJeu res = null;
	while(err){
	    jeu.alea();
	    if 
	    for(int i=0; i<9; i++){
		
		jeu.rotation(i);
		
	}
    }

}
