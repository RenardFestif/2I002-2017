 import indexation.Index;
 import indexation.ParserCISI;
 import indexation.Stemmer;

 public class MainIndexation {
    public static void main(String[] args) {

        Stemmer     st      = new Stemmer();
        ParserCISI  parser  = new ParserCISI();
        Index       i       = new Index("index", parser,st);
        i.index("./"); // CHEMIN ABSOLU PAR RAPPORT A MON ORDINATEUR 
        
        TestIndexation test = new TestIndexation(i);
        
        //test.test();
        
        test.nbTermesDoc("55");
        //test.nbDocTerme("attempt");
        //test.getTextIncludesStem("attempt");
        
        test.scoreAlea();
  
    }

 }
