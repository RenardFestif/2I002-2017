package interrogation;

import indexation.Index;

import java.util.HashMap;

public class WeighterTF extends Weighter{
   
    public WeighterTF(Index index){
        super(index);
    }


   
    public double frequence(String id,String word){
        
        HashMap<String, Integer> p=index.getTfsForDoc(id);
        HashMap<String, Double> res= new HashMap<>();
        
        double freq;
        double occ;
        double nbword=0;
        
        for (HashMap.Entry<String, Integer> entry : p.entrySet()){ //On parcours toutes les entrées de p
            nbword += p.get(entry.getKey());
        }
        //nombre total de mots
        
        occ = p.get(word);
        
        freq = occ/nbword;
        
        
        
        System.out.println("NB occ "+occ+"\nnombre de mot dans le doc "+nbword+"\nFrequence doc ok !"+freq);
        return freq;
    }
}
