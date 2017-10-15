public class Solveur{
    private PlateauJeu jeu;

    public Solveur ( Piece [] p ){
	this.jeu = new PlateauJeu(p);
    }

    public void resoudre(){
	int err = jeu.compterErreur();
	PlateauJeu res = null;
	int errTmp = 0;
	int rotTmp = 0;
        
	while(err!=0){
	    jeu.alea();
	    errTmp = jeu.compterErreur();
	    for(int i=0; i<9; i++){
		for( int nbRot = 0; nbRot < 4; nbRot++){
		    
		    jeu.rotationPT(i);
		    if (jeu.compterErreur()<errTmp){
			errTmp = jeu.compterErreur();
			rotTmp = i;
		    }

		    do {
			jeu.rotationPT(i);
			rotTmp--;
		    }while (rotTmp!= 0);
		}
	    }
	}
    }
}
