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



public class WeighterTFIDF extends Weighter{
    
    public WeighterTFIDF(Index index){
        super(index);
    }
    public double frequence(String id, String mot){
        double idf;

      	HashMap<String,Integer> tmp= index.getTfsForStem(mot);
	int nbdoc=0;

        nbdoc = tmp.entrySet().stream().map((_item) -> 1).reduce(nbdoc, Integer::sum); //Parcours de Hasmap on compte le nb de doc contenant le mot
        
        HashMap<String,Integer> liste= index.getTfsForDoc(id);
	int nbelem=0;
	for (HashMap.Entry<String, Integer> entry : liste.entrySet()){
            nbelem=nbelem+entry.getValue();  // dans value il y a  le nombre d'occurence du mot
	}

        
        WeighterTF wtf = new WeighterTF(index);
 	idf=nbelem/nbdoc;
 	idf=Math.log(idf);
 	idf=(wtf.frequence(id,mot)*idf); 
 	return idf;

	}
    
  
}

