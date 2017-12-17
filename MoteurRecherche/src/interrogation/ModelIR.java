
package interrogation;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import indexation.TextRepresenter;
import indexation.Index;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


        

public abstract class ModelIR {
    
    protected Index index;
    
    public ModelIR(Index index){
        this.index = index;
    }
            
    
    
    public abstract HashMap<String, Double> getDocScores (HashMap<String, Integer> queryProcessed);
    
    
    
    public  LinkedHashMap<String, Double> getRanking (HashMap<String, Double> docScores){
        
        
        List<Map.Entry<String , Double>> entries = new ArrayList<Map.Entry<String ,Double>>(docScores.entrySet ( ) ) ;
        
        Collections.sort( entries , new Comparator<Map. Entry<String , Double>>() {
            public int compare(Map.Entry<String , Double> a , Map.Entry<String , Double> b) {
            return b.getValue().compareTo( a.getValue( ));
        }
        }) ;
        LinkedHashMap<String , Double> ret = new LinkedHashMap<String , Double>() ;
        for (Map.Entry<String , Double> entry : entries ) {
            ret.put(entry.getKey() , entry.getValue());
        }
        
        return ret ;
    }
    
    
    
    public  HashMap<String, Integer> getQueryProcessed (String query){
        TextRepresenter textRep=index.getTextRepresenter ( ) ;
        HashMap<String , Integer> ret=textRep.getTextRepresentation ( query ) ;

        return ret ;
    }
   
    public LinkedHashMap<String , Double> runModel ( String query ) {
        HashMap<String , Integer> queryProcessed= getQueryProcessed ( query ) ;
        HashMap<String , Double> docsScore= getDocScores ( queryProcessed ) ;
        return getRanking ( docsScore ) ;
    }
    
   
    

}
    

