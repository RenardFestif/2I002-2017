package interrogation;

import java.util.HashMap;
import indexation.Index;


public class VectorielCartesien extends ModelIR {
    
    private Weighter w;
    
    public VectorielCartesien(Index index, Weighter w){
        super(index);
        this.w = w;
    }
    
    public double freqQuery(String word, HashMap<String, Integer> queryProcessed){
        double freq;
        double nbWord = 0;
        double occ = queryProcessed.get(word);
        for (HashMap.Entry<String, Integer> entry : queryProcessed.entrySet()){
            nbWord += queryProcessed.get(entry.getKey());
        }
        
        freq = occ/nbWord;
        
        System.out.println("occ "+occ+"nb WOrd "+nbWord+"Frequence query ok ! "+freq);
        return freq;    
    }

    
    public  HashMap<String, Double> getDocScores (HashMap<String, Integer> queryProcessed){
        
        HashMap<String, Double> ret = new HashMap<>();
        HashMap<String, String> docs = index.getDocs();

        double freqdoc;
        double freqQuery ;
        double somme = 0;
        
        for(HashMap.Entry<String, String> entry2 : docs.entrySet()){    //Parcours de tout les docs
            for (HashMap.Entry<String,Integer> entry : queryProcessed.entrySet()){ // parcours des mot de query
     
                freqQuery = this.freqQuery(entry.getKey(),queryProcessed);  //Frequence qi              
                freqdoc = w.frequence(entry2.getKey(), entry.getKey());//Frequence di

                somme += freqQuery*freqdoc;// Somme ponderé
                
                
                }
                ret.put(entry2.getKey(), somme);    // on ajoute la frequence dans la HashMap ret + on remet somme a 0 car on passe au doc suivant
                somme = 0;                      
            }   
        return ret;
    
    }
    
}
