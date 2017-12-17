package interrogation;

import indexation.Index;
import java.util.HashMap;


public class WeighterTFIDF extends Weighter{
    
    public WeighterTFIDF(Index index){
        super(index);
    }
    
    
    public double frequence(String id, String word){
        double idf;

        HashMap<String,Integer> tmp= index.getTfsForStem(word);
        double nbdoc=0;
        double nbelem;
        for (HashMap.Entry<String, Integer> entry1 : tmp.entrySet()){ //nbr mot total dans le doc
            nbdoc += tmp.get(entry1.getKey());
        }

    
    
        nbelem = tmp.get(word); // occurences du mot dans le doc
    
        WeighterTF wtf = new WeighterTF(index);
        idf=nbelem/nbdoc;
        idf=Math.log(idf);
        idf=(wtf.frequence(id,word)*idf); 
        return idf;

    }
    
  
}

