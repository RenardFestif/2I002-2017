public class PieceC {  
        private int noSerie;  
        private boolean luxe;  

        public PieceC(int n) { noSerie=n; }    
        public PieceC(int n,boolean b) { noSerie=n; luxe=b; }    

        public void setLuxe(boolean b) { luxe=b; }  

        public String toString() {      
                String s="pieceC no "+ noSerie;      
                if (luxe) s +=" de luxe \n";      
                else s +=" ordinaire\n";      
                return s;  
        }
        public PieceC clone (){
                PieceC copie = new PieceC(this.noSerie, this.luxe);
                return copie;
        }
}