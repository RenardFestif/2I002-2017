public class PieceA {  
        private int noSerie;  
        private String matiere;  

        public PieceA(int n) { noSerie=n; matiere="bois"; }    
        public PieceA(int n,String m) { noSerie=n; matiere=m; }   


        public String toString() {      
                return "pieceA no "+ noSerie+ " en "+ matiere+"\n";
        }

        public PieceA clone (){
        	PieceA copie = new PieceA(this.noSerie, this.matiere);
        	return copie;
        }
}