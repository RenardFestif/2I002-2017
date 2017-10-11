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
    public int getH() {return cotes[(0+iRotation)%4];}
    public int getD() {return cotes[(0+iRotation)%4];}
    public int getB() {return cotes[(0+iRotation)%4];}

    public String toString() {
	return " "+getH()+" \n"
	    +getG()+" "+getD()
	   + "\n "+getB()+" \n";
    }
}

