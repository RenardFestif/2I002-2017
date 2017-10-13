public class PlateauJeu{

    private Piece [] plateau;

    public PlateauJeu(Piece p1,Piece p2,Piece p3,Piece p4,Piece p5,Piece p6,Piece p7,Piece p8,Piece p9){
	plateau = new Piece[] {p1,p2,p3,p4,p5,p6,p7,p8,p9};
    }

    public PlateauJeu(Piece[] pieces){
	plateau = new Piece[9];
	for (int i = 0; i<9; i++)
	    plateau[i]=pieces[i];
    }
	     
    public int CompterErreur(){
	int cptErr=0;
	for (int hb=0; hb<6;hb++)
	    cptErr+=(plateau[hb].getB() + plateau[hb+3].getH() == 9) ? 0:1;

	for (int gd=0; gd<8;gd++){
	    if (gd==2 || gd==5){
		gd++;
		continue;
	    }
	    cptErr+=(plateau[gd].getD() + plateau[gd+1].getG() == 9) ? 0:1;
	}
	return cptErr;
    }

    public String toString(){
	String s=" ";
	for (int i=0 ; i<9; i+=3){
	    
	    for(int h=0;h+i<3+i;h++){ // Boucle Haut ligne 1
    
		s+= plateau[h+i].getH()+"   ";
		if (h == 2){
		    s+="\n";

		    for (int gd=0; gd+i<3+i; gd ++){ //Boucle gauche-droite ligne 1

			s+= plateau[gd+i].getG()+" "+plateau[gd+i].getD()+" ";
			if ( gd == 2){
			    s+= "\n ";

			    for (int b = 0; b+i<3+i; b++){ // boucle bas

				s+= plateau[b+i].getB() + "   ";
			    }
			}
		    }
		}
	    }
	    s+="\n\n ";
	}
	return s;
    }

    public void rotationPT( int i ){
	plateau[i].rotation();
    }
}
	
    
