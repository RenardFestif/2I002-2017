package interrogation;

import indexation.Index;
import java.util.HashMap;
import java.util.Iterator;

import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;


public class Boolean extends ModelIR {
    
    
    
    public Boolean(Index index){
        super(index);
        
    }
    

   
    public  HashMap<String, Double> getDocScores (HashMap<String, Integer> queryProcessed){
        
        HashMap<String, Double> score = new HashMap<String, Double>();
        HashMap<String,String> docs = new HashMap<String,String>();
        
        docs = index.getDocs();
        
            
            Set<Map.Entry<String, String>> setDoc = docs.entrySet();
            Iterator<Map.Entry<String, String>> it2 = setDoc.iterator();
       
            while(it2.hasNext()){   // Boucle qui parcours tout les docs
                Map.Entry<String, String> e2 = it2.next();
                String docWord = docs.get(e2.getKey()) ;    //Recupere le text du doc
                
                score.put(docWord, 1.0); // On met le score du doc a 1
                
                Set<Entry<String, Integer>> setQuery = queryProcessed.entrySet();
                Iterator<Entry<String,Integer>> it = setQuery.iterator();
                while(it.hasNext()){        // Boucle qui parcours tout les termes de Query     
                    Map.Entry<String, Integer> e = it.next();
            
                    String word = e.getKey();    //On reccupere un mot de la requete*/
            
            
                    if (!docWord.contains(word)){ // Si le mot de la requete n'est pas dans le doc Score = 0
                        score.put(docWord, 0.0);
                }
            }         
        }        
        return score;        
    }
   
    
            
            
}
