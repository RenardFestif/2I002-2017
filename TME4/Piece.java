public class Piece{
    private int [] cotes;
    private int iRotation;

    public Piece ( int g, int h, int d, int b ){
	cotes = new int[] {g,h,d,b};
	iRotation = 0;
    }


    public void rotation(){
	iRotation ++;
    }
    
    public int getG() {return cotes[(0+iRotation)%4];}
    public int getH() {return cotes[(1+iRotation)%4];}
    public int getD() {return cotes[(2+iRotation)%4];}
    public int getB() {return cotes[(3+iRotation)%4];}

    public String toString() {
	return " "+getH()+" \n"
	    +getG()+" "+getD()
	   + "\n "+getB()+" \n";
    }

    public void setRotation ( int rotation ){
	this.iRotation = rotation;
    }

    public Piece clone(){
	Piece clone = new Piece(this.cotes[0], this.cotes[1], this.cotes[2], this.cotes[3]);
	clone.setRotation(this.iRotation);
	return clone;
    }
	    
}

