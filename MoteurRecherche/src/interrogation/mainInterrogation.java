package interrogation;

import indexation.Index;

import indexation.Stemmer;
import indexation.ParserCISI;

        

public class mainInterrogation {
    public static void main ( String [] args ) {

        Stemmer     st      = new Stemmer();
        ParserCISI  parser  = new ParserCISI();
        Index       index       = new Index("index", parser,st);
        index.index("./");
        
        String query = "attempt attempt young bradford" ;

        ModelIR mod=new Boolean ( index ) ;
        mod.runModel ( query ) ;


        WeighterTF w = new WeighterTF( index ) ;
        ModelIR modCos = new VectorielCosinus ( index , w) ;
        System.out.println (modCos.runModel( query ) ) ;

 
        WeighterTFIDF w1 = new WeighterTFIDF( index ) ;
        ModelIR modCart = new VectorielCosinus(index , w1) ;
        System.out.println (modCart.runModel ( query ) ) ;
    }
}
