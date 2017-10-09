public class Monde{

	private Cellule[][] tabCells;
	private int nbGen;

	public Monde(double seuil){
		nbGen = 0;
		tabCells = new Cellule[20][20];
		for(int i=0;i<20;i++){
			for(int j=0;j<20;j++){
				if(Math.random() < seuil){
					tabCells[i][j] = new Cellule(true);
				}
				else{
					tabCells[i][j] = new Cellule (false);
				}
			}
		}
	}

	public Monde(int x, int y, double seuil){
		nbGen = 0;
		tabCells = new Cellule[x][y];
		for(int i=0;i<x;i++){
			for(int j=0;j<y;j++){
				if(Math.random() < seuil){
					tabCells[i][j] = new Cellule (true);
				}
				else{
					tabCells[i][j] = new Cellule (false);
				}
			}
		}
	}

	public Monde(int x, int y){
		nbGen = 0;
		tabCells = new Cellule[x][y];
	}

	public int getX(){
		return tabCells.length;
	}

	public int getY(){
		return tabCells[0].length;
	}

	public int getNbGen(){
		return nbGen;
	}

	public Cellule get(int x, int y){
		return tabCells[x][y];
	}

	public String toString(){
	String s = "Generation "+ nbGen+"\n";
	
	for (int x = 0; x<getX(); x++){
	    for (int y = 0; y<getY();y++){
			if (tabCells[x][y].getAge() == -1)
			    s=s+".";
			else
			    s=s+"*";
	    	}
	    	s=s+"\n";
		}
		return s;
    }

    public int nbVoisins(int x, int y){
    	int x1, y1;
    	int nb = 0;
		for(int i=x-1;i<x+1;i++){
	    	for (int j=y; j<y+1; j++){
				x1=(i+getX())%getX();
				y1=(j+getY())%getY();
				if (tabCells[x1][y1].getAge() != -1)
		    		nb++;
	     	}
		}
		return nb;
    }

    public Monde clone(){
    	Monde clone = new Monde(this.getX(), this.getY());
    	for(int i=0;i<getX();i++){
    		for(int j=0;j<getY();j++){
    			clone.tabCells[i][j] = this.tabCells[i][j];
    		}
    	}
    	return clone;
    }

    public boolean etatSuivant(int x, int y){
    	
    	if(this.nbVoisins(x,y) < 2 || this.nbVoisins(x,y) > 3){
    
    		return false;
    	}
    	else if(this.nbVoisins(x,y) == 3 && tabCells[x][y].getAge() == -1){
    	
    		return true;
    	}
    	else{
    	
    		return true;
    	}
    }

    public void etatSuivant(){

    	Monde temp = this.clone();
    	this.nbGen ++;

    	for (int i=0; i<getX(); i++ ){
    		for (int j=0; j<getY(); j++){
    		
    			if (temp.etatSuivant(i,j))
    				this.tabCells[i][j].vieillir(true);
    			else
    				this.tabCells[i][j].mourir();   			
    		}
    	}
    }
}
