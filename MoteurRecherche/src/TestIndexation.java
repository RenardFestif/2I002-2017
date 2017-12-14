import indexation.Index;
import core.Document;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map;
import java.util.Map.Entry;

public class TestIndexation {
    private Index i;
    
    public TestIndexation(Index i){
        this.i=i;
    }
    
    public void test(){
       
        
        try{
            
            System.out.println("Text du document 55:\n"+i.getStrDoc("55"));
        
        }catch(IOException e){
            System.out.println("erreur !");
        }
       
       
        
        System.out.println("Tout les mots du document 55 et leur nombre d'occurence :\n"+i.getTfsForDoc("55"));
        System.out.println("Ensemble des documents qui contient le mot attempt et son nombre d'occurence :\n"+i.getTfsForStem("attempt"));   

        
    }
    
    public void nbTermesDoc(String doc){
        int nbTerme = 0;
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        map = i.getTfsForDoc(doc);
        
     
        Set<Entry<String, Integer>> setMap = map.entrySet();
        Iterator<Entry<String, Integer>> it = setMap.iterator();
        while(it.hasNext()){
            Entry<String, Integer> e = it.next();
            nbTerme++;
      }
        System.out.println("Nombre de termes differents dans le document "+doc+" : "+nbTerme);
        
    }
    
    public void nbDocTerme(String word){
        int nbDoc = 0;
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        map = i.getTfsForStem(word);
        
     
        Set<Entry<String, Integer>> setMap = map.entrySet();
        Iterator<Entry<String, Integer>> it = setMap.iterator();
        while(it.hasNext()){
            Entry<String, Integer> e = it.next();
            nbDoc++;
      }
        System.out.println("Nombre de documents qui contiennent le terme "+word+" : "+nbDoc);
        
    }
    
    public void getTextIncludesStem(String word){
    
        Map<String, Integer> map = new HashMap<String, Integer>();
        map = i.getTfsForStem(word);
        // Document doc = null;
        System.out.println("Parcours des documents contenant le mot :"+word);
        Set<Entry<String, Integer>> setMap = map.entrySet();
        Iterator<Entry<String, Integer>> it = setMap.iterator();
        while(it.hasNext()){
            Entry<String, Integer> e = it.next();
            
            try {
                //doc = i.getDoc(e.getKey());
                System.out.println(i.getStrDoc(e.getKey())); // affiche tout le doc
                
            }catch(IOException err){
                System.out.println("Erreur !");
            }
            //System.out.println(doc.getText());  // Affiche qu'une ligne du doc
      }
       
    }
        
    public void scoreAlea(){
        HashMap<String,Double> map = new HashMap<String,Double>();
        HashMap<String,String> docs = new HashMap<String,String>();
        
        docs = i.getDocs();
        
        Set<Entry<String, String>> setDocs = docs.entrySet();
        Iterator<Entry<String,String>> it = setDocs.iterator();
        while(it.hasNext()){
            Entry<String, String> e = it.next();
            map.put(e.getKey(), Math.random());
            System.out.println(e.getKey()+":"+map.get(e.getKey()));
          
      }
        
        
    }
    
}
