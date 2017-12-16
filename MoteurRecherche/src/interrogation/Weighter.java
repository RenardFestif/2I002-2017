package interrogation;

import indexation.Index;


public abstract class Weighter{
    protected Index index;

    public Weighter(Index index){
        this.index=index;
    }
 
    public abstract double frequence(String id,String mot);
}
