public class Vecteur{
	private double x, y;

	public Vecteur(double x, double y){
		this.x = x;
		this.y = y;
	}

	public Vecteur(){
		return ;
	}

	public Vecteur addition(Vecteur v1, Vecteur v2){
		 this.x =v1.x+v2.x;
		 this.y =v1.y+v2.y;
		 return this;
	}

	public String toString(){
		return x+","+y;
	}

	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}

	public Vecteur rotation(double teta){
		double x1, y1;
		x1 = x * Math.cos(teta) - y * Math.sin(teta);
		y1 = x* Math.sin(teta) + y * Math.cos(teta);
		this.x = x1;
		this.y = y1;
		return this;
	}
}