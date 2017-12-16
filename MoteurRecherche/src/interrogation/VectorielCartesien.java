/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interrogation;

import java.util.HashMap;
import indexation.Index;



/**
 *
 * @author Jörmungandr
 */
public class VectorielCartesien extends ModelIR {
    
    private Weighter w;
    
    public VectorielCartesien(Index index, Weighter w){
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

    
    public  HashMap<String, Double> getDocScores (HashMap<String, Integer> queryProcessed){
        
        HashMap<String, Double> ret = new HashMap<>();
        HashMap<String, String> docs = new HashMap<>();
        
        
        docs = index.getDocs();
        double freqdoc =0.0;
        double freqQuery =0.0;
        double somme = 0;
        
        for(HashMap.Entry<String, String> entry2 : docs.entrySet()){    //Parcours de tout les docs
            for (HashMap.Entry<String,Integer> entry : queryProcessed.entrySet()){
            
                freqQuery = this.freqQuery(entry.getKey(),queryProcessed);  //Frequence qi
                freqdoc = w.frequence(entry2.getKey(), entry.getKey());              //Frequence di
                somme += freqQuery*freqQuery;                                // Somme ponderé
                
                
                       
            }
            // on ajoute la frequence dans la HashMap ret + on remet somme a 0 car on passe au doc suivant
            somme = 0;
            ret.put(entry2.getKey(), somme);
        }
        
        return ret;
    
    }
    
}
