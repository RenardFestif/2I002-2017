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
    }

    public int nbVoisins(int nuLign, int nuCol){
	
	int x2;
	int y2;
	
	int nb = 0;
	for(int x=nuLign-1;x<nuLign+1;x++){
	    for (int y=nuCol; y<nuCol+1; y++){
		x2=(x+dimx)%dimx;
		y2=(y+dimy)%dimy;
		if (tabCells[x2][y2])
		    nb++;
	     	       
	
	    }
	}

	return nb;
	
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


    public void genSuiv(){
	this.noGener++;

	for (int y=0; y<dimy; y++){
	    for (int x=0; x<dimx; x++){
		
		if (tabCells[x][y] == true && this.nbVoisins(x,y) < 2 ){
		    tabCells[x][y] = false;
		}
		else if (tabCells[x][y] == true && this.nbVoisins(x,y) > 3){
		    tabCells[x][y] = false;
		}
		else if ( tabCells[x][y] == false && this.nbVoisins(x,y) == 3){
		    tabCells[x][y] = true;
		}
		
	    }
	}
    }

	
	    
			 
}

	     
	    
		
    
	
