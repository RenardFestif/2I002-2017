public class PieceB {  
        private int noSerie;  
        private double longueur;  

        public PieceB(int n) { noSerie=n; }  
        public PieceB(int n,double l) { noSerie=n; longueur=l; }    

        public void setLongueur(double l) { longueur=l; }    

        public String toString() {      
                return "pieceB no "+ noSerie+ " de longueur "+ longueur +"\n";  
        }
        public PieceB clone (){
        	PieceB copie = new PieceB(this.noSerie, this.longueur);
        	return copie;
        }
}