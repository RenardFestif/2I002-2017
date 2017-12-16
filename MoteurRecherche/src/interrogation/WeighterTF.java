package interrogation;

import indexation.Index;
import indexation.ParserCISI;
import indexation.Stemmer;
import core.Document;
import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class WeighterTF extends Weighter{
    private Index index;
    public WeighterTF(Index index){
        super(index);
    }
    public double frequence(String id,String mot){
        HashMap<String, Integer> p=new HashMap<String, Integer>();
        HashMap<String, Double> res= new HashMap<String, Double>();
        p=index.getTfsForDoc(id);
        double freq =0;
        int somme=0;
		for (HashMap.Entry<String,Integer> entry : p.entrySet()){   //On parcours toutes les entrées de p
                somme+=entry.getValue().intValue();     //nombre total de mots

        }

        for (HashMap.Entry<String,Integer> entry : p.entrySet()){   //On parcours toutes les entrées de p
             int val =entry.getValue().intValue();  // je récupère la valeur de l'integer
             double i=val/somme;
             res.put(entry.getKey(),i);
              
        }
        
        for (HashMap.Entry<String, Double> entry : res.entrySet()){
              if (entry.getKey().compareTo(mot)==0)
                    freq=entry.getValue();
                    
        }
        return freq;
    }
}
