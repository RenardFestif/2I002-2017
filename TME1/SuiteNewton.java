public class SuiteNewton {
	private int x;
	private int x0;

	public SuiteNewton(int x){
		this.x=x;
		this.x0=x/2;
	}

	public double uI(int i){
		if(i==1){
			return x0;
		}
		else{
			return ((this.uI(i-1)+x)/this.uI(i-1))/2;
		}
		
	}
}