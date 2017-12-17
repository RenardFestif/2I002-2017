package interrogation;

import indexation.Index;
import java.util.HashMap;

public class Boolean extends ModelIR {
    
    
    
    public Boolean(Index index){
        super(index);
        
    }
    

   
    public  HashMap<String, Double> getDocScores (HashMap<String, Integer> queryProcessed){
        
        HashMap<String, Double> score = new HashMap<>();
        HashMap<String,String> docs = index.getDocs();
        
        
        for (HashMap.Entry<String, String> entry : docs.entrySet()){    // Boucle qui parcours tout les docs
            String docText = docs.get(entry.getKey());                  //Recupere le text du doc
            score.put (entry.getKey(),1.0);                             // On met le score du doc a 1
            
            for (HashMap.Entry<String,Integer> entryQ : queryProcessed.entrySet()){ // Boucle qui parcours tout les termes de Query 
                String wordQ = entryQ.getKey();                         //On reccupere un mot de la requete
                
                if (!docText.contains(wordQ)){
                    score.put (entry.getKey(),0.0);                     // Si le mot de la requete n'est pas dans le doc Score = 0
                }
            }
        }     
        return score;        
    }
   
    
            
            
}
