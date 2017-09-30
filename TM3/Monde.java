public class Monde{
    private int dimx;
    private int dimy;
    private int noGener;
    private boolean [][] tabCells;

    public Monde (int dimx, int dimy, double seuil){

	double rand;
	this.dimx=dimx;
	this.dimy=dimy;
	tabCells = new boolean [dimx][dimy]; 

	for (int y=0; y<dimy; y++){
	    for (int x=0; x<dimx; x++){

		if (Math.random() < seuil){
		    this.tabCells[x][y]=true;
		}
		else{
		    this.tabCells[x][y]=false;
		}
	    }
	}

	public int nbVoisins(int nuLign, int nuCol){

	    int nb = 0;
	    for(int x=nuLign-1;x<nuLign+1;x++){
		for (int y=nuCol; y<nuCol+1; y++){
		    
	    
	    
	}
    }

    public String toString(){
	String s = "Generation "+ noGener+"\n";
	
	for (int y = 0; y<dimy; y++){
	    for (int x = 0; x<dimx; x++){
		if (tabCells[x][y]==true)
		    s=s+"*";
		else
		    s=s+".";
	    }
	    s=s+"\n";
	}
	return s;
    }
}

	     
	    
		
    
	
