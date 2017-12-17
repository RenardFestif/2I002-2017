package interrogation;

import java.util.HashMap;
import indexation.Index;


public class VectorielCosinus extends ModelIR {
    
    private Weighter w;
    
    public VectorielCosinus(Index index, Weighter w){
        super(index);
        this.w = w;
    }
    
    public double freqQuery(String word, HashMap<String, Integer> queryProcessed){
        double freq = 0.0;
        int nbWord = 0;
        int occ = queryProcessed.get(word);
        for (String words : queryProcessed.keySet())
            nbWord += queryProcessed.get(words);
        freq = occ/nbWord;
        return freq;    
    }

    public double cardQuery (HashMap<String,Integer> queryProcessed){ //Retrourne le cardinal de query
        double card = 0;
        
        for (HashMap.Entry<String,Integer> entry : queryProcessed.entrySet()){
            card += queryProcessed.get(entry.getKey());
        }
        return card;
    }
    
    public double cardDoc (String id){  //retourne le cardinal du doc (nb de mot du doc)
        double card = 0;
        HashMap<String, Integer> tfs = index.getTfsForDoc(id);
        
        for (HashMap.Entry<String, Integer> entry : tfs.entrySet()){
            card += tfs.get(entry.getKey());
        }
        return card;
    }
    public  HashMap<String, Double> getDocScores (HashMap<String, Integer> queryProcessed){
        
        HashMap<String, Double> ret = new HashMap<>();
        HashMap<String, String> docs = new HashMap<>();
        
        
        docs = index.getDocs();
        double freqdoc;
        double freqQuery;
        double cardQuery;
        double cardDoc;
        double div;  
        double res;
        double somme = 0;
        
        for(HashMap.Entry<String, String> entry2 : docs.entrySet()){    //Parcours de tout les docs
            
            cardDoc = this.cardDoc(entry2.getKey());
            cardQuery = this .cardQuery(queryProcessed);
            
            div = cardDoc*cardQuery;
            for (HashMap.Entry<String,Integer> entry : queryProcessed.entrySet()){
            
                freqQuery = this.freqQuery(entry.getKey(),queryProcessed);  //Frequence qi
                freqdoc = w.frequence(entry2.getKey(), entry.getKey());              //Frequence di
                somme += freqQuery*freqdoc;                                // Somme ponderé qi*di
                
                
                
                
                
            }
            // on ajoute la frequence dans la HashMap ret + on remet somme a 0 car on passe au doc suivant
            res = somme/div;
            
            ret.put(entry2.getKey(),res );
            somme = 0;
            
        }
        
        return ret;
    
    }
    
}
